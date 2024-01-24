package com.example.hiber.dao.Reunion;

import com.example.hiber.entity.Reunion;
import com.example.hiber.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;

public class ReunionDaoImpl implements ReunionDao{
    public void addReunion(Reunion reunion){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.merge(reunion);//persist ,session.save();session.saveOrUpdate();session.merge()
        session.getTransaction().commit();
    }
    public List<Reunion> reunionList() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Reunion> result = session.createQuery("from Reunion", Reunion.class).list();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
