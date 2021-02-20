package com.ahumadamob.controller;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ahumadamob.model.Vacant;
import com.ahumadamob.service.IVacantService;

@Controller
public class HomeController {
	
	@Autowired
	private IVacantService serviceVacant;
	
	@GetMapping("/vacants")
	public String showVacants (Model model) {
		List<Vacant> vacants = serviceVacant.fetchAll();
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
}
