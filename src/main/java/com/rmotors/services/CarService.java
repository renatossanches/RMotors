package com.rmotors.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.rmotors.dtos.CarDTO;
import com.rmotors.entities.Car;
import com.rmotors.repositories.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	public List<CarDTO> findAll(){
		List<Car> obj = carRepository.findAll();
		return obj.stream().map(this::toCarDTO).collect(Collectors.toList());
		
	}
	
	public Car insert(Car car) {
		car = carRepository.save(car);
		return car;
	}
	
	public Car findById(@PathVariable String id) {
		Optional<Car> car = carRepository.findById(id);
		return car.orElseThrow(()-> new ServiceException("Objeto não encontrado"));
	}
	
	public CarDTO toCarDTO(Car car) {
		CarDTO obj = new CarDTO(car.getId(),car.getMarca(),car.getModelo(),car.getAno(),car.getQuilometragem(),car.getTipoDeCombustível(),car.getPlaca(),car.getCor(), car.getCliente());
		return obj;
	}
}
