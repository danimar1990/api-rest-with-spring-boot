package br.edu.unoesc.rent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApiController {

	@GetMapping(value = "/api")
	public String showForm() {
		return "api/index";
	}

}
