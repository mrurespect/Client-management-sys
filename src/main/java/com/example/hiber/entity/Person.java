package com.example.hiber.entity;

import java.util.HashSet;
import java.util.Set;

public class Person {
    private Long idPerson ;
    private String nomPerson;
    private String prenomPerson ;
    private int age ;
    private Set<Reunion> reunions =new HashSet<>();

    public Person() {
    }

    public Person(String nomPerson, String prenomPerson, int age) {
        this.nomPerson = nomPerson;
        this.prenomPerson = prenomPerson;
        this.age = age;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getNomPerson() {
        return nomPerson;
    }

    public void setNomPerson(String nomPerson) {
        this.nomPerson = nomPerson;
    }

    public String getPrenomPerson() {
        return prenomPerson;
    }

    public void setPrenomPerson(String prenomPerson) {
        this.prenomPerson = prenomPerson;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Set<Reunion> getReunions() {
        return reunions;
    }

    public void setReunions(Set<Reunion> reunions) {
        this.reunions = reunions;
    }
}
