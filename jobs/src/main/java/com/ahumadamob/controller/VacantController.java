package com.ahumadamob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vacants/")
public class VacantController {
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable("id") int idVacant, Model model) {
		System.out.println("idVacant: " + idVacant);
		model.addAttribute("id", idVacant);
		
		//TODO: Buscar los detalles de la vacante en la base de datos
		return "vacants/details";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int idVacant, Model model) {
		model.addAttribute("id", idVacant);
		System.out.println("Eliminando vacante con idVacant = " + idVacant);
		return "message";
		
	}

}
