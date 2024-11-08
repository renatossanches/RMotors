package com.rmotors.Main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmotors.Main.dtos.CarDTO;
import com.rmotors.Main.entities.Car;
import com.rmotors.Main.services.CarService;


@RestController
@RequestMapping(value = "/cars")
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
		return new ResponseEntity(car, HttpStatus.CREATED);
	}
}
