package br.edu.unoesc.rent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

	@GetMapping("/contact")
	public String showForm() {
		return "contact/index";
	}

}
