package com.example.hiber.dao.Facture;

import com.example.hiber.entity.Facture;
import com.example.hiber.entity.Reunion;
import com.example.hiber.util.HibernateUtil;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;

public interface FactureDao {
    public void addFacture(Facture facture , int idClient);
    public List<Facture> factureList() ;
    public void deleteByID(int id);
}
