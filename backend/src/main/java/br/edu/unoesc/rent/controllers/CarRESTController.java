package br.edu.unoesc.rent.controllers;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import br.edu.unoesc.rent.dto.CarDTO;
import br.edu.unoesc.rent.entities.Car;
import br.edu.unoesc.rent.repositories.CarRepository;
import br.edu.unoesc.rent.services.CarService;

@RestController
@RequestMapping(value = "api")
public class CarRESTController {
	@Autowired
	private CarService carService;
	@Autowired
	private CarRepository carRepository;

	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws ServletException {
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}

	@GetMapping(value = "/cars")
	public Page<CarDTO> findAll(Pageable pageable) {
		return carService.findAll(pageable);
	}

	@GetMapping(value = "/car/get/{id}")
	public CarDTO findById(@PathVariable Long id) {
		return carService.findById(id);
	}

	@PostMapping("/car/create")
	public Car createCar(@RequestBody Car car) {
		return carRepository.save(car);
	}

	@PutMapping(value = "/car/update/{id}")
	public Car updateCar(@RequestBody Car updtCar, @PathVariable Long id) {
		return carRepository.findById(id).map(car -> {
			car.setBrand(updtCar.getBrand());
			car.setModel(updtCar.getModel());
			car.setVyear(updtCar.getVyear());
			car.setPrice(updtCar.getPrice());
			// car.setPhoto(updtCar.getPhoto());
			return carRepository.save(car);
		}).orElseGet(() -> {
			updtCar.setId(id);
			return carRepository.save(updtCar);
		});
	}

	@DeleteMapping(value = "/car/delete/{id}")
	public ResponseEntity<String> deleteCar(@PathVariable Long id) {
		carRepository.deleteById(id);
		return new ResponseEntity<>("Car deleted", HttpStatus.OK);
	}

	@GetMapping(value = "/cars/brand/{brand}")
	public List<Car> getCarsByBrand(@PathVariable String brand) {
		return carRepository.getByBrand(brand);
	}

}
