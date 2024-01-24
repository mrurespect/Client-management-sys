package com.example.hiber.vue;

import com.example.hiber.dao.Client.ClientDao;
import com.example.hiber.dao.Client.ClientDaoImpl;
import com.example.hiber.dao.Facture.FactureDao;
import com.example.hiber.dao.Facture.FactureDaoImpl;
import com.example.hiber.entity.Client;
import com.example.hiber.entity.Facture;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ClientServlet", value = "/ClientServlet")
public class ClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientDao clientManager =new ClientDaoImpl();
        List<Client> clients = clientManager.clientList();
        request.setAttribute("clients", clients);

        FactureDao factureManager =new FactureDaoImpl();
        List<Facture> factures =factureManager.factureList();
        if (request.getParameter("clId")==null){
            request.setAttribute("factures",factures);
        }else {
            int id= Integer.parseInt(request.getParameter("clId"));
            List<Facture> clientFact =new ArrayList<>();
            for (Facture facture:factures) {
                if (facture.getClient().getIdClient()==id){
                    clientFact.add(facture);
                }
            }
            request.setAttribute("factures",clientFact);
        }
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String adresse = request.getParameter("adresse");
        String societe = request.getParameter("societe");
        if (!(name==null || adresse==null || societe==null)){
            Client client =new Client(name,surname,societe,adresse);

            ClientDao clientManager =new ClientDaoImpl();
            clientManager.addClient(client);
        }
        response.sendRedirect(request.getContextPath() + "/ClientServlet");
        //doGet(request,response);
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientDao clientManager = new ClientDaoImpl();
        int id = Integer.parseInt(request.getParameter("id"));
        clientManager.deleteByID(id);
        response.sendRedirect(request.getContextPath() + "/ClientServlet");
    }
}
