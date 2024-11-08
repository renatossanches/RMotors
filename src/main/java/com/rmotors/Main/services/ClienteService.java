package com.rmotors.Main.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmotors.Main.dtos.ClienteDTO;
import com.rmotors.Main.entities.Cliente;
import com.rmotors.Main.repositories.ClienteRepository;
import com.rmotors.Main.services.exceptions.ServiceExceptions;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteDTO> findAll(){
		List<Cliente> cli = clienteRepository.findAll(); 
		return cli.stream().map(this::toClienteDTO).collect(Collectors.toList());
	}

	public Cliente insert(Cliente cli) {
		cli = clienteRepository.save(cli);
		return cli;
	}
	
	public ClienteDTO findById(String id) {
	    return clienteRepository.findById(id)
	        .map(this::toClienteDTO)
	        .orElseThrow(() -> new ServiceExceptions("Cliente não encontrado"));
	}



	
	
	public ClienteDTO toClienteDTO(Cliente cli) {
		ClienteDTO obj = new ClienteDTO(cli.getId(),cli.getNome(),cli.getEmail(),cli.getCar());
		return obj;
	}
}