package com.rmotors.Main.dtos;

import com.rmotors.Main.entities.Cliente;
import com.rmotors.Main.entities.Enum.Cor;

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
	private Cor cor;
	private Cliente cliente;
	
	public CarDTO(String id, String marca, String modelo, Integer ano, Integer quilometragem, String tipoDeCombustível,
			String placa, Cor cor) {
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
