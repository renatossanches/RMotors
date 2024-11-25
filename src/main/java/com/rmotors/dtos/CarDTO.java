package com.rmotors.dtos;

import com.rmotors.entities.Cliente;
import com.rmotors.entities.Enum.Color;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CarDTO {

	private String id;
	private String marca;
	private String modelo;
	private Integer ano;
	private Integer quilometragem;
	private String tipoDeCombustível;
	private String placa;
	private Color cor;
	private Cliente cliente;
	
	public CarDTO(String id, String marca, String modelo, Integer ano, Integer quilometragem, String tipoDeCombustível,
			String placa, Color cor) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.quilometragem = quilometragem;
		this.tipoDeCombustível = tipoDeCombustível;
		this.placa = placa;
		this.cor = cor;
	}
	
}
