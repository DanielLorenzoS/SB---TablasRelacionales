package com.spring.rest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.entidades.Biblioteca;
														//Este repositorio tiene más funciones, específicas al JPA		
public interface BibliotecaRepository extends JpaRepository<Biblioteca, Integer>{
	
}
