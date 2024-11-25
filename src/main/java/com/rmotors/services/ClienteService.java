package com.rmotors.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import com.rmotors.dtos.ClienteDTO;
import com.rmotors.entities.Cliente;
import com.rmotors.repositories.ClienteRepository;
import com.rmotors.services.exceptions.ServiceExceptions;
import com.rmotors.services.exceptions.handler.HandlerConfiguration;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public List<ClienteDTO> findAll(){
		List<Cliente> cli = clienteRepository.findAll(); 
		return cli.stream().map(this::toClienteDTO).collect(Collectors.toList());
	}

	public Cliente insert(Cliente cli) {
		try {
		cli = clienteRepository.save(cli);
		return cli;
		}
		catch(ServiceExceptions e) {
			System.out.println("Erro na digitação " + e.getMessage());
		}
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