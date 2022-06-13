package com.spring.rest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.entidades.Biblioteca;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Integer>{
	
}
