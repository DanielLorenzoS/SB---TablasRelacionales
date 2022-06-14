package com.spring.rest.repositorios;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest.entidades.Profesor;

@Repository
public interface ProfesorRepository extends CrudRepository<Profesor, Long>{
	Collection<Profesor> findAll();
}
