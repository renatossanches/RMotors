package com.rmotors.Main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmotors.Main.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
