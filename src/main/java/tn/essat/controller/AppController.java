package tn.essat.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tn.essat.models.Client;
import tn.essat.services.IGestionService;

@Controller
public class AppController {
	@Autowired
	IGestionService service;

	public void setService(IGestionService service) {
		this.service = service;
	}
	
@RequestMapping(value="/home")
public String get1(Model model) {
	List<Client> liste1=service.getAllClients();
	model.addAttribute("listec",liste1);
	return "accueil";
	}
@RequestMapping(value="/addClient",method=RequestMethod.GET)
public  String ajoutC(Model model) {
	Client c1=new Client();
	model.addAttribute("c",c1);
	return "FormAjout";
	
}
@RequestMapping(value="/saveClient",method=RequestMethod.POST)
public String ajout2(Model model,@ModelAttribute("c")Client c1) {
	service.addClient(c1);
	
	return "redirect:/home";
	
}
}
