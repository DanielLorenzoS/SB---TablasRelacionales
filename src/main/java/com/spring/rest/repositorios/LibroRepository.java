package com.spring.rest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.rest.entidades.Libro;

public interface LibroRepository extends JpaRepository<Libro, Integer>{

}
