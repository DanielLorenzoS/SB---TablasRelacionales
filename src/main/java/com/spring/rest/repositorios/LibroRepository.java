package com.spring.rest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.entidades.Libro;
												//Este repositorio tiene más funciones, específicas al JPA
public interface LibroRepository extends JpaRepository<Libro, Integer>{

}
