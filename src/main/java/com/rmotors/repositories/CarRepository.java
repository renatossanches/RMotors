package com.rmotors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmotors.entities.Car;

public interface CarRepository extends JpaRepository<Car, String>{

}
