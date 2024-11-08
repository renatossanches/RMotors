package com.rmotors.Main.entities;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rmotors.Main.entities.Enum.Cor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Car {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String marca;
	private String modelo;
	private Integer ano;
	private Integer quilometragem;
	private String tipoDeCombustível;
	private String placa;
	private Cor cor;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	@JsonIgnore
	private Cliente cliente;

	@Builder
	public Car(String marca, String modelo, Integer ano, Integer quilometragem, String tipoDeCombustível, String placa,
		Cor cor) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.quilometragem = quilometragem;
		this.tipoDeCombustível = tipoDeCombustível;
		this.placa = placa;
		this.cor = cor;
	}

}
