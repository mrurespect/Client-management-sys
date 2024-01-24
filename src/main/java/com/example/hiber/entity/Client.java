package com.example.hiber.entity;

import java.util.HashSet;
import java.util.Set;

public class Client {
    private long IdClient;
    private String nomClient ;
    private String prenomClient ;
    private String societe ;
    private String adresse ;
    private Set<Facture> factures;



    public Client() {
        factures=new HashSet<>();
    }

    public Client(String nomClient, String prenomClient, String societe, String adresse) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.societe = societe;
        this.adresse = adresse;
    }

    public void addFacture(Facture facture){
        factures.add(facture) ;
        facture.setClient(this);
    }

    public long getIdClient() {
        return IdClient;
    }

    public void setIdClient(long idClient) {
        IdClient = idClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Set<Facture> getFactures() {
        return factures;
    }

    public void setFactures(Set<Facture> factures) {
        this.factures = factures;
    }
}
