package com.example.hiber.dao.Client;

import com.example.hiber.entity.Client;

import java.util.List;

public interface ClientDao {
    public void addClient(Client client);
    public List<Client> clientList();
    public void deleteByID(int id);
    public Client getByID(int id);
}
