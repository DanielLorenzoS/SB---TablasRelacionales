package com.spring.rest.controladores;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.entidades.Profesor;
import com.spring.rest.repositorios.ProfesorRepository;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

	@Autowired
	private ProfesorRepository profesorRepository;

	@GetMapping
	public ResponseEntity<Collection<Profesor>> getProfesores() {
		return new ResponseEntity<>(profesorRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Profesor> getProfesoresById(@PathVariable Long id) {
		Profesor profesor = profesorRepository.findById(id).orElseThrow();

		if (profesor != null) {
			return new ResponseEntity<>(profesorRepository.findById(id).orElseThrow(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<?> saveProfesor(@RequestBody Profesor profesor) {
		return new ResponseEntity<>(profesorRepository.save(profesor), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProfesor(@PathVariable Long id) {
		profesorRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
