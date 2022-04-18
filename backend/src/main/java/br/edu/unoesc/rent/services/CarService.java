package br.edu.unoesc.rent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.unoesc.rent.dto.CarDTO;
import br.edu.unoesc.rent.entities.Car;
import br.edu.unoesc.rent.repositories.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	@Transactional(readOnly = true)
	public Page<CarDTO> findAll(Pageable pageable) {
		Page<Car> car = carRepository.findAll(pageable);
		Page<CarDTO> page = car.map(x -> new CarDTO(x));
		return page;
	}

	@Transactional(readOnly = true)
	public CarDTO findById(Long id) {
		Car car = carRepository.findById(id).get();
		CarDTO dto = new CarDTO(car);
		return dto;
	}

}
