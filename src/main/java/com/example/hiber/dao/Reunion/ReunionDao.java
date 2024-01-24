package com.example.hiber.dao.Reunion;

import com.example.hiber.entity.Reunion;

import java.util.List;

public interface ReunionDao {
    public void addReunion(Reunion reunion);
    public List<Reunion> reunionList();
}
