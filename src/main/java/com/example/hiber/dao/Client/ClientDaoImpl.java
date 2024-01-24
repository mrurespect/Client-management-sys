package com.example.hiber.dao.Client;

import com.example.hiber.entity.Client;
import com.example.hiber.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;

public class ClientDaoImpl implements ClientDao{
    public void addClient(Client client){
        Session session= HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(client);
        session.getTransaction().commit();
    }
    public List<Client> clientList() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Client> result = session.createQuery("from Client ", Client.class).list();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void deleteByID(int id) {
        Session session= HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Client client =session.find(Client.class,id);
            session.remove(client);
            session.getTransaction().commit();
    }

    @Override
    public Client getByID(int id) {
        Session session =HibernateUtil.getSessionFactory().getCurrentSession();
        return session.get(Client.class,id);
    }
}
