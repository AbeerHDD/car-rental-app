package tn.essat.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {
	@Id
	@GeneratedValue
	private Integer num;
	private String nom;
	private String adresse;
	public Client(Integer num, String nom, String adresse) {
		super();
		this.num = num;
		this.nom = nom;
		this.adresse = adresse;
	}
	public Client() {
		
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
