package com.example.hiber.dao.Person;

import com.example.hiber.entity.Person;

import java.util.List;

public interface PersonDao {
    public void addPerson(String nom ,String prenom, int age);
    public Person getPerson(Long idPerson);
    public List<Person> personList();
}
