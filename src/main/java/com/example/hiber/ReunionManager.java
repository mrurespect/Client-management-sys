package com.example.hiber;

import com.example.hiber.dao.Client.ClientDao;
import com.example.hiber.dao.Client.ClientDaoImpl;
import com.example.hiber.dao.Facture.FactureDao;
import com.example.hiber.dao.Facture.FactureDaoImpl;
import com.example.hiber.dao.Person.PersonDao;
import com.example.hiber.dao.Person.PersonDaoImpl;
import com.example.hiber.dao.Reunion.ReunionDao;
import com.example.hiber.dao.Reunion.ReunionDaoImpl;
import com.example.hiber.entity.Client;
import com.example.hiber.entity.Facture;
import com.example.hiber.entity.Reunion;
import com.example.hiber.service.ReunionService;
import com.example.hiber.util.HibernateUtil;

import java.util.Date;
import java.util.List;

public class ReunionManager {
    public static void main(String[] args) {
        ReunionDao reunionManager = new ReunionDaoImpl();
        PersonDao personManager = new PersonDaoImpl();
        ReunionService reunionService =new ReunionService();

        reunionManager.addReunion(new Reunion("deliberation",new Date()));
        reunionManager.addReunion(new Reunion("conseil",new Date()));
        reunionManager.addReunion(new Reunion("compte rendu",new Date()));

        personManager.addPerson("mohamed","ELFADILI",21);
        personManager.addPerson("mehdi","benhachmi",21);
        personManager.addPerson("oussama","salhya",21);

        List<Reunion> reunions = reunionManager.reunionList();
        System.out.println("Liste des reunions:");
        for (Reunion reunion : reunions) {
            System.out.printf("""
                    %d -- %s --%s
                    """, reunion.getIdReunion(), reunion.getTitre(), reunion.getDateReunion().toString());
        }
        reunionService.addReunionToPerson(1L,1L);
        reunionService.addReunionToPerson(2L,1L);
        reunionService.addReunionToPerson(3L,1L);
        reunionService.addReunionToPerson(1L,2L);
        reunionService.addReunionToPerson(3L,2L);


        ClientDao clientsManager =new ClientDaoImpl();
        FactureDao factureManager =new FactureDaoImpl();
        clientsManager.addClient(new Client("Mohamed","elfadili","Google","newYork"));
        clientsManager.addClient(new Client("moad","lahyaoui","apple","paris"));
        factureManager.addFacture(new Facture(new Date(),400),1);
        factureManager.addFacture(new Facture(new Date(),1000),2);

        HibernateUtil.getSessionFactory().close();

    }
}

