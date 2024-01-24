package com.example.hiber.dao.Person;

import com.example.hiber.entity.Person;
import com.example.hiber.entity.Reunion;
import com.example.hiber.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;

public class PersonDaoImpl implements PersonDao{
    public void addPerson(String nom ,String prenom, int age){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();;
        session.beginTransaction();
        Person person =new Person(nom,prenom,age);
        session.merge(person);
        session.getTransaction().commit();
    }
    public Person getPerson(Long idPerson){
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        return session.get(Person.class,idPerson);
    }
    public List<Person> personList() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            List<Person> result = session.createQuery("from Person ", Person.class).list();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
