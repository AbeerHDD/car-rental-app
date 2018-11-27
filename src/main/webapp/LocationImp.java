package tn.essat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import tn.essat.models.Client;
import tn.essat.models.Contrat;
import tn.essat.models.voiture;


@Repository
public class LocationImp implements ILocation {

	
	@Autowired
	@Qualifier("data1")
	DataSource data;
	public void addClient(Client c) {
		// TODO Auto-generated method stub
		
	}

	public void addVoiture(voiture v) {
		// TODO Auto-generated method stub
		
	}

	public void addContrat(Contrat c1) {
		// TODO Auto-generated method stub
		try {
			Connection cnx=data.getConnection();
			PreparedStatement st=cnx.prepareStatement("insert into contrat values(null,?,?,?,?)");
			st.setInt(1,c1.getClt().getPermis());
			st.setInt(2,c1.getVt().getId());
			st.setString(3, c1.getDate_d());
			st.setString(4,c1.getDate_f());
			st.executeUpdate();
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Client getClient(int permis) {
		Client c=new Client();
		try {
			Connection cnx=data.getConnection();
			PreparedStatement st=cnx.prepareStatement("select * from client where permis=?");
			st.setInt(1, permis);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				c.setPermis(rs.getInt("permis"));
				c.setNom(rs.getString("nom"));
				c.setAdresse(rs.getString("adresse"));
				
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c;
	}

	public voiture getVoiture(int id) {
		voiture v1=new voiture();
		try {
			Connection cnx=data.getConnection();
			PreparedStatement st=cnx.prepareStatement("select * from voiture where id=?");
			st.setInt(1, id);
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				v1.setId(rs.getInt("id"));
				v1.setMarque(rs.getString("marque"));
				v1.setCategorie(rs.getString("categorie"));
                v1.setDispo(rs.getInt("dispo"));
				
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return v1;
	}

	public List<voiture> getAllVoitureNonLoues() {
		List<voiture> liste= new ArrayList<voiture>();
		
		try {
			Connection cnx=data.getConnection();
			PreparedStatement st=cnx.prepareStatement("select * from voiture where dispo=0");
			
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				voiture v1=new voiture();
				v1.setId(rs.getInt("id"));
				v1.setMarque(rs.getString("marque"));
				v1.setCategorie(rs.getString("categorie"));
                v1.setDispo(rs.getInt("dispo"));
				liste.add(v1);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return liste;
		
	}

	public List<Contrat> getAllContrat() {
	List<Contrat> listectr=new ArrayList<Contrat>();
	
	try {
		Connection cnx=data.getConnection();
		PreparedStatement st=cnx.prepareStatement("select * from contrat");
		
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			Contrat c1=new Contrat();
			c1.setId(rs.getInt("id"));
			c1.setClt(getClient(rs.getInt("client")));
			c1.setVt(getVoiture(rs.getInt("voiture")));
            c1.setDate_d(rs.getString("date_d"));
            c1.setDate_f(rs.getString("date_f"));
			listectr.add(c1);
		}
		
		
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return listectr;
	}

	public List<Client> getAllClient() {
List<Client> liste= new ArrayList<Client>();
		
		try {
			Connection cnx=data.getConnection();
			PreparedStatement st=cnx.prepareStatement("select * from client");
			
			ResultSet rs=st.executeQuery();
			while (rs.next()) {
				Client c=new Client();
				c.setPermis(rs.getInt("permis"));
				c.setNom(rs.getString("nom"));
				c.setAdresse(rs.getString("adresse"));
				liste.add(c);
			}
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return liste;
		
	}

	

	

	
}
