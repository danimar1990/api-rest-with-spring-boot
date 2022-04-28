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
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.unoesc.rent.entities.Car;
import br.edu.unoesc.rent.repositories.CarRepository;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class CarController {

	@Autowired
	CarRepository carRepository;

	@GetMapping("/cars")
	public String list(Model model) {
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		Calendar calendar = Calendar.getInstance();
		String dataFormatada;
		dateFormat.applyPattern("dd 'de' MMMM 'de' yyyy");
		dataFormatada = dateFormat.format(calendar.getTime());
		model.addAttribute("data", LocalDateTime.now());
		model.addAttribute("dataExtenso", "<b>" + dataFormatada + "</b>");
		model.addAttribute("cars", carRepository.findAll());
		return "car/list";
	}

	@GetMapping("/car/new")
	public String insert(Model model) {
		model.addAttribute("car", new Car());
		model.addAttribute("insert", true);
		return "car/form";
	}
	
	@GetMapping("/car/update/{id}")
	public String update(@PathVariable("id") long id, Model model) {
		Car car = carRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID do carro inválido: " + id));
		model.addAttribute("car", car);
		model.addAttribute("insert", false);
		return "car/form";
	}

	@PostMapping("/car/insert")
	public String insertCar(@Valid Car car, BindingResult resultado) {
		if (resultado.hasErrors()) {
			return "car/form";
		}
		carRepository.save(car);
		return "redirect:/cars";
	}

	@PostMapping("/car/update/{id}")
	public String updateCar(@PathVariable("id") long id, @Valid Car car, BindingResult resultado,
			Model model) {
		if (resultado.hasErrors()) {
			car.setId(id);
			return "form";
		}
		carRepository.save(car);
		return "redirect:/cars";
	}

	@GetMapping("/car/delete/{id}")
	public String delete(@PathVariable("id") long id, Model model) {
		Car car = carRepository.findById(id).get();
		carRepository.delete(car);
		return "redirect:/cars";
	}
}