package com.rmotors.Main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmotors.Main.dtos.ClienteDTO;
import com.rmotors.Main.entities.Cliente;
import com.rmotors.Main.services.ClienteService;


@RestController
@RequestMapping(value = "/clients")
public class ClienteResource {

	@Autowired
	private ClienteService repo;
	
	@GetMapping
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<ClienteDTO> lista = repo.findAll();
		return ResponseEntity.ok(lista);
	}
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente cli){
		repo.insert(cli);
		return new ResponseEntity(cli, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> findById(@PathVariable String id) {
	    ClienteDTO cliente = repo.findById(id);
	    return ResponseEntity.ok(cliente);
	}
}
