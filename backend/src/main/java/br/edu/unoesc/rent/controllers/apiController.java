package br.edu.unoesc.rent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> 02c77975d692d6960e72b23c6ac1020e7c1d45eb

@Controller
public class apiController {

	@GetMapping(value = "/api")
	public String showForm() {
		return "api/index";
	}
	
}
