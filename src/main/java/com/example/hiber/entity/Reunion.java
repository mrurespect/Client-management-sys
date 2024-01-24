package com.example.hiber.entity;

import java.util.Date;

public class Reunion {
    private Long idReunion;
    private String titre ;
    private Date DateReunion ;

    public Reunion() {
    }

    public Reunion(String titre, Date dateReunion) {
        this.titre = titre;
        DateReunion = dateReunion;
    }


    public Long getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(Long idReunion) {
        this.idReunion = idReunion;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateReunion() {
        return DateReunion;
    }

    public void setDateReunion(Date dateReunion) {
        DateReunion = dateReunion;
    }
}
