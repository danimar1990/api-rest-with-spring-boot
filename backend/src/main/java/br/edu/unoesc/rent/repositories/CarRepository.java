package br.edu.unoesc.rent.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.unoesc.rent.entities.Car;

public interface CarRepository extends JpaRepository<Car, Long> {

	
	@Query("select c from Car c")
	List<Car> getAll();
	
	@Query("select c from Car c where c.brand = :brand")
	List<Car> getByBrand(@Param("brand") String brand);

}
