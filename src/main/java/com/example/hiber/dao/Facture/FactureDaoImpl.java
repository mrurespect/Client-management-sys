package com.example.hiber.dao.Facture;

import com.example.hiber.entity.Client;
import com.example.hiber.entity.Facture;
import com.example.hiber.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;

public class FactureDaoImpl implements FactureDao{
    public void addFacture(Facture facture, int idClient) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();
            Client client = session.get(Client.class, idClient);
            client.addFacture(facture);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }
            throw e;
        }
    }

    public List<Facture> factureList() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Facture> result = session.createQuery("from Facture ", Facture.class).list();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
     @Override
    public void deleteByID(int id) {
        Session session= HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Facture facture =session.find(Facture.class,id);
        session.remove(facture);
        session.getTransaction().commit();
    }
}
