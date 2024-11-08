package com.rmotors.Main.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmotors.Main.dtos.CarDTO;
import com.rmotors.Main.entities.Car;
import com.rmotors.Main.repositories.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	public List<CarDTO> findAll(){
		List<Car> obj = carRepository.findAll();
		return obj.stream().map(this::toCarDTO).collect(Collectors.toList());
		
	}
}
