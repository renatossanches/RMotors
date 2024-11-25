package com.rmotors.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmotors.dtos.CarDTO;
import com.rmotors.entities.Car;
import com.rmotors.services.CarService;


@RestController
@RequestMapping(value = "/cars")
@CrossOrigin(origins = "*")
public class CarResource {

	@Autowired
	private CarService repo;
	
	@GetMapping
	public ResponseEntity<List<CarDTO>> findAll() {
		List<CarDTO> lista = repo.findAll();
		return ResponseEntity.ok(lista);
	}
	
	
	@PostMapping
	public ResponseEntity<Car> insert(@RequestBody Car car){
		repo.insert(car);
		return new ResponseEntity<Car>(car, HttpStatus.CREATED);
	}
}
