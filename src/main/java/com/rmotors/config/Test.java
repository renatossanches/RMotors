package com.rmotors.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rmotors.entities.Car;
import com.rmotors.entities.Cliente;
import com.rmotors.entities.Enum.Color;
import com.rmotors.repositories.CarRepository;
import com.rmotors.repositories.ClienteRepository;

@Configuration
@Profile("dev")
public class Test implements CommandLineRunner{
	@Autowired
	ClienteRepository repocli;
	
	@Autowired
	CarRepository repocar;
	
	@Override
	public void run(String... args) throws Exception {
		
		Car car =  new Car("lamborghini", "aventador", 2024, 50000, "bicombustivel", "FE3SDF3A",Color.AMARELO);
		
		Cliente cliente = new Cliente("Maria", "11976542675", "Rua kaieiras", 203,"maria@gmail.com", "mariazinha", "4634123134");
		car.setCliente(cliente);
		cliente.getCar().add(car);
		
		repocli.saveAll(Arrays.asList(cliente));
		repocar.saveAll(Arrays.asList(car));
	}

}
