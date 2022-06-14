package com.spring.rest.repositorios;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest.entidades.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long>{
	Collection<Alumno> findAll();
}
