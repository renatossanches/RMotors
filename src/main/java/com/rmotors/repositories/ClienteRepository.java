package com.rmotors.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmotors.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
