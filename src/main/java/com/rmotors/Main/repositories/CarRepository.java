package com.rmotors.Main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmotors.Main.entities.Car;

public interface CarRepository extends JpaRepository<Car, String>{

}
