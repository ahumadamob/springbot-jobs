package com.ahumadamob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ahumadamob.model.Vacant;
import com.ahumadamob.service.IVacantService;

@Controller
@RequestMapping("/vacants/")
public class VacantController {
	
	@Autowired
	private IVacantService serviceVacant;
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable("id") int idVacant, Model model) {
		
		Vacant vacant = serviceVacant.fetchById(idVacant);
		model.addAttribute("vacant", vacant);
		
		System.out.println("vacant: " + vacant);
		
		//TODO: Buscar los detalles de la vacante en la base de datos
		return "details";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int idVacant, Model model) {
		model.addAttribute("id", idVacant);
		System.out.println("Eliminando vacante con idVacant = " + idVacant);
		return "message";
		
	}

}
