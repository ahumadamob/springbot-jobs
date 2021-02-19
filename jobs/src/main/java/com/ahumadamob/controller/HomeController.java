package com.ahumadamob.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ahumadamob.model.Vacant;

@Controller
public class HomeController {
	
	@GetMapping("/vacants")
	public String showVacants (Model model) {
		List<Vacant> vacants = getVacants();
		model.addAttribute("vacants", vacants);
		return "vacants";
	}
	
	@GetMapping("/jobs")
	public String showJobsModel (Model model) {
		List<String> jobs = new LinkedList<String>();
		jobs.add("Ingeniero en Sistemas");
		jobs.add("Arquitecto");
		jobs.add("Vendedor");
		jobs.add("Ilustrador");
		
		model.addAttribute("jobs", jobs);
		return "jobs";
		
	}
	
	@GetMapping("/")
	public String showHome(Model model) {
		/*
		model.addAttribute("message", "Bienvenidos a Empleos App!");
		model.addAttribute("now", new Date() );
		*/
		
		String position = "Auxiliar contable";
		Date postDate = new Date();
		double salary = 75000.0;
		boolean open = true;
		
		model.addAttribute("position", position);
		model.addAttribute("postDate", postDate);
		model.addAttribute("salary", salary);
		model.addAttribute("open", open);
		
		return "home";
	}
	
	@GetMapping("/details")
	public String showDetails(Model model) {
		Vacant vacant = new Vacant();
		vacant.setName("Ingeniero en comunicaciones");
		vacant.setDescription("Se solicita ingeniero para dar soporte en intranet");
		vacant.setPostDate(new Date());
		vacant.setSalary(150000.0);
		model.addAttribute("vacant", vacant);
		return "details";
	}
	
	
	private List<Vacant> getVacants(){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		List<Vacant> vacants = new LinkedList<Vacant>();
		
		try {
			// Creamos la oferta de trabajo 1
			Vacant vacant1 = new Vacant();
			vacant1.setId(1);
			vacant1.setName("Ingeniero Civil");
			vacant1.setDescription("Se solicita Ing. Civil para diseñar puente peatonal");
			vacant1.setPostDate(sdf.parse("15-12-2020"));
			vacant1.setSalary(150000.0);
			vacant1.setHighlight(1);
			
			
			// Creamos la oferta de trabajo 2
			Vacant vacant2 = new Vacant();
			vacant2.setId(2);
			vacant2.setName("Arquero");
			vacant2.setDescription("Solicitamos arquero que no se coma goles como Armani");
			vacant2.setPostDate(sdf.parse("03-01-2021"));
			vacant2.setSalary(7500000.0);	
			vacant2.setHighlight(0);
			
			// Creamos la oferta de trabajo 2
			Vacant vacant3 = new Vacant();
			vacant3.setId(3);
			vacant3.setName("Lateral Izquierdo");
			vacant3.setDescription("Solicitamos marcador de punta izquierdo que juegue además como win y recorte para adentro");
			vacant3.setPostDate(sdf.parse("05-01-2021"));
			vacant3.setSalary(17500000.0);
			vacant3.setHighlight(0);
			vacant3.setLogo("river.png");
			
			// Creamos la oferta de trabajo 4
			Vacant vacant4 = new Vacant();
			vacant4.setId(4);
			vacant4.setName("Delantero nivel Dios");
			vacant4.setDescription("Solicitamos delantero que le haga tres goles o más al Palmeiras");
			vacant4.setPostDate(sdf.parse("08-01-2021"));
			vacant4.setSalary(57500000.0);
			vacant4.setHighlight(1);
			vacant4.setLogo("river.png");
			
			vacants.add(vacant1);
			vacants.add(vacant2);
			vacants.add(vacant3);
			vacants.add(vacant4);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error:" + e.getMessage());
		}
		return vacants;
	}

}
