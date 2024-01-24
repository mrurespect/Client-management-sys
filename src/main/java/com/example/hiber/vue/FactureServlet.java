package com.example.hiber.vue;

import com.example.hiber.dao.Facture.FactureDao;
import com.example.hiber.dao.Facture.FactureDaoImpl;
import com.example.hiber.entity.Facture;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "FactureServlet", value = "/FactureServlet")
public class FactureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/ClientServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String datefacture = request.getParameter("datefacture");
        int montant = Integer.parseInt(request.getParameter("montant"));
        int idClient;
        FactureDao factureManager =new FactureDaoImpl();
        if(request.getParameter("idClient")!=null){
            idClient = Integer.parseInt(request.getParameter("idClient"));
            factureManager.addFacture(new Facture(Date.valueOf(datefacture),montant), idClient);
            response.sendRedirect(request.getContextPath() + "/ClientServlet");
        }
        else {
            idClient = Integer.parseInt(request.getParameter("clientId"));
            factureManager.addFacture(new Facture(Date.valueOf(datefacture),montant), idClient);
            response.sendRedirect(request.getContextPath() + "/ClientServlet?clId="+idClient);
        }
    }
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FactureDao factureManager =new FactureDaoImpl();
        int id = Integer.parseInt(request.getParameter("idFact"));
        factureManager.deleteByID(id);
        response.sendRedirect(request.getContextPath() + "/ClientServlet");
    }
}