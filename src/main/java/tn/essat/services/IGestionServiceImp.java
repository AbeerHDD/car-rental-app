package tn.essat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.essat.dao.IGestion;
import tn.essat.models.Client;

@Service
public class IGestionServiceImp implements IGestionService{
	@Autowired
	IGestion dao;
	public void setDao (IGestion dao) {
		this.dao=dao;
	}
	public List<Client> getAllClients() {
		return (List<Client>) dao.findAll();
	}

	public void addClient(Client c) {
		dao.save(c);
		
	}
	

}
