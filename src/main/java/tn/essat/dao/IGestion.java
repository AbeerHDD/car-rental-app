package tn.essat.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.essat.models.Client;

@Repository
public interface IGestion extends CrudRepository<Client, Integer> {

	
}
