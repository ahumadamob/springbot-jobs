package com.ahumadamob.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ahumadamob.model.Vacant;
import com.ahumadamob.service.ICategoryService;
import com.ahumadamob.service.IVacantService;
import com.ahumadamob.util.Utils;

@Controller
@RequestMapping("/vacancies/")
public class VacantController {
	
	@Autowired
	private IVacantService serviceVacant;
	
	@Autowired
	private ICategoryService serviceCategory;
	
	@Value("${jobs.path.images}")
	private String imagePath;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Vacant> vacancies = serviceVacant.fetchAll();
		model.addAttribute("vacancies", vacancies);
		return "vacancies/listVacancies";
	}
	
	@GetMapping("/details/{id}")
	public String details(@PathVariable("id") int idVacant, Model model) {
		
		Vacant vacant = serviceVacant.fetchById(idVacant);
		model.addAttribute("vacant", vacant);
		
		System.out.println("vacant: " + vacant);
		
		//TODO: Buscar los detalles de la vacante en la base de datos
		return "details";
	}
	
	@GetMapping("/create")
	public String create(Vacant vacant, Model model) {
		model.addAttribute("categories", serviceCategory.fetchAll());
		return "vacancies/formVacant";
	}
	
	@PostMapping("/save")
	public String save(Vacant vacant, BindingResult result, RedirectAttributes redirectAttributes, 
			@RequestParam("imageFile") MultipartFile multipart) {
		
		if(result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("Detalle del error: " + error.getDefaultMessage());
			}
			return "vacancies/formVacant";
		}
		
		if(!multipart.isEmpty()) {
			String imageName = Utils.saveImage(multipart, imagePath);
			if(imageName != null) {
				vacant.setImage(imageName);
			}
		}
		
		System.out.println("Objeto vacant: " + vacant);
		serviceVacant.save(vacant);
		redirectAttributes.addFlashAttribute("msg", "La vacante ha sido añadida correctamente");
		return "redirect:/vacancies/";
	}
	
	/* Queda comentado por una lección anterior
	@PostMapping("/save")
	public String save(
				@RequestParam("name") String name,
				@RequestParam("description") String description,
				@RequestParam("category") String category,				
				@RequestParam("postDate") String postDate,
				@RequestParam("highlight") Integer highlight,
				@RequestParam("salary") double salary,
				@RequestParam("details") String details		
				
			) {
		
		//Verificar por consola que llegaron correctamente todos los valores del formulario
		System.out.println("Nombre de la vacante: " + name);
		System.out.println("Descripción: " + description);
		System.out.println("Categoría: " + category);
		System.out.println("Fecha de publicación: " + postDate);
		System.out.println("Destacado: " + highlight);
		System.out.println("Salario pretendido: " + salary);
		System.out.println("Detalles: " + details);
		
		return "vacancies/listVacancies";
	}*/
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int idVacant, Model model) {
		model.addAttribute("id", idVacant);
		System.out.println("Eliminando vacante con idVacant = " + idVacant);
		return "message";
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

}
