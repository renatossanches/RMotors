package com.rmotors.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 
public class Cliente {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;
	private String nome; 
	@Column(length = 11, unique = true)
	private String telefone;
	private String endereco;
	@Column(length = 5)
	private Integer numEndereco;
	@Column(unique = true,  nullable = false)
	private String email;
	private String senha;
	@Column(length = 11, unique = true, nullable = false)
	private String cpf;
	

	@OneToMany(cascade = CascadeType.PERSIST, targetEntity = Car.class, orphanRemoval = true)
	@JoinTable(
name = "clients_cars", 
joinColumns = {@JoinColumn(name="client_id", referencedColumnName = "id")}, 
inverseJoinColumns = {@JoinColumn(name= "cars_id", referencedColumnName = "id")})
	@JsonIgnore
	private List<Car> car = new ArrayList<>();
	
	public Cliente(String nome, String telefone, String endereco, Integer numEndereco, String email,
			String senha, String cpf) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.numEndereco = numEndereco;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
	}
	
	
}
