package com.rmotors.Main.dtos;

import java.util.ArrayList;
import java.util.List;

import com.rmotors.Main.entities.Car;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter 
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

	private String id;
	private String nome;
	private String email;
	private List<Car> car = new ArrayList<>();
	
	public ClienteDTO(String id, String nome, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
	}
	
}
