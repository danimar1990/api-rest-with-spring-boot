package br.edu.unoesc.rent.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.unoesc.rent.entities.Car;
import br.edu.unoesc.rent.repositories.CarRepository;

@Controller
@CrossOrigin(origins = "*")
public class CarController {
	@Autowired
	CarRepository carRepository;

	@GetMapping("/carros")
	public String listarCarros(Model model) {
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		Calendar cal = Calendar.getInstance();
		String sDataAux;
		dateFormat.applyPattern("dd 'de' MMMM 'de' yyyy");
		sDataAux = dateFormat.format(cal.getTime());
		model.addAttribute("data", LocalDateTime.now());
		model.addAttribute("dataExtenso", "<b>" + sDataAux + "</b>");
		model.addAttribute("carros", carRepository.findAll());
		return "lista_carros";
	}

	@GetMapping("/incluir_carro")
	public String formCarro(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("adicionar", true);
		return "form_carro";
	}

	@PostMapping("/processa_incluir_carro")
	public String processaFormIncluirCarro(@Valid Car car, BindingResult resultado) {
		if (resultado.hasErrors()) {
			return "form_carro";
		}
		carRepository.save(car);
		return "redirect:/carros";
	}

	@GetMapping("/alterar_carro/{id}")
	public String alterar(@PathVariable("id") long id, Model model) {
		Car car = carRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID do carro inválido: " + id));
		model.addAttribute("carro", car);
		model.addAttribute("adicionar", false);
		return "form_carro";
	}

	@PostMapping("/processa_alterar_carro/{id}")
	public String processaFormAlterarCarro(@PathVariable("id") long id, @Valid Car car, BindingResult resultado,
			Model model) {
		if (resultado.hasErrors()) {
			car.setId(id);
			return "form_carro";
		}
		carRepository.save(car);
		return "redirect:/carros";
	}

	@GetMapping("/excluir_carro/{id}")
	public String remover(@PathVariable("id") long id, Model model) {
		Car car = carRepository.findById(id).get();
		carRepository.delete(car);
		return "redirect:/carros";
	}
}