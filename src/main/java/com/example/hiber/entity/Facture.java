package com.example.hiber.entity;


import com.example.hiber.entity.Client;

import java.util.Date;

public class Facture {
    private Long idFacture ;
    private Date dateFacture ;
    private double montant ;
    private Client client ;

    public Facture() {
    }

    public Facture(Date dateFacture, double montant) {
        this.dateFacture = dateFacture;
        this.montant = montant;

    }


    public void setClient(Client client) {
        this.client=client;
    }

    public Long getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Long idFacture) {
        this.idFacture = idFacture;
    }

    public Date getDateFacture() {
        return dateFacture;
    }

    public void setDateFacture(Date dateFacture) {
        this.dateFacture = dateFacture;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Client getClient() {
        return client;
    }
}
