package tn.essat.services;

import java.util.List;

import tn.essat.models.Client;

public interface IGestionService {
public List<Client> getAllClients();
public void addClient(Client c);
}
