package com.ahumadamob.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="categories")
public class CategoryController {
	
	@GetMapping("index")
	public String index(Model model) {
		return "categories/index";
	}
	
	@GetMapping("create")
	public String create() {
		return "categories/formCategory";
	}
	
	@PostMapping("save")
	public String save(@RequestParam("name") String name, @RequestParam("description") String description) {
		System.out.println("name: " + name);
		System.out.println("description: " + description);
		return "categories/index";
	}

}
