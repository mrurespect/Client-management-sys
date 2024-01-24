package com.example.hiber.service;

import com.example.hiber.entity.Person;
import com.example.hiber.entity.Reunion;
import com.example.hiber.util.HibernateUtil;
import org.hibernate.Session;

public class ReunionService {
    public void addReunionToPerson(Long idPerson,Long idReunion){
        Session session= HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Reunion reunion= session.get(Reunion.class,idReunion) ;
        Person person =session.get(Person.class,idPerson); //load
        person.getReunions().add(reunion);
        session.getTransaction().commit();
    }
}
