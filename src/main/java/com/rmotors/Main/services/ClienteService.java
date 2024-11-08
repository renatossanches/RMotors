package com.rmotors.Main.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.rmotors.Main.dtos.ClienteDTO;
import com.rmotors.Main.entities.Cliente;
import com.rmotors.Main.repositories.ClienteRepository;

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
	
	public Cliente findById(@PathVariable String id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(()-> new ServiceException("Objeto não encontrado"));
	}
	
	
	
	public ClienteDTO toClienteDTO(Cliente cli) {
		ClienteDTO obj = new ClienteDTO(cli.getId(),cli.getNome(),cli.getEmail(),cli.getCar());
		return obj;
	}
}