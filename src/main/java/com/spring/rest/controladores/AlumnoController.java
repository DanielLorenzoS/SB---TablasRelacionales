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

import com.spring.rest.entidades.Alumno;
import com.spring.rest.entidades.Profesor;
import com.spring.rest.repositorios.AlumnoRepository;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoRepository alumnoRepository;

	@GetMapping
	public ResponseEntity<Collection<Alumno>> getAlumnos() {
		return new ResponseEntity<>(alumnoRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Alumno> getAlumnosById(@PathVariable Long id) {
		Alumno alumno = alumnoRepository.findById(id).orElseThrow();

		if (alumno != null) {
			return new ResponseEntity<>(alumnoRepository.findById(id).orElseThrow(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<?> saveAlumno(@RequestBody Alumno alumno) {
		return new ResponseEntity<>(alumnoRepository.save(alumno), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAlumno(@PathVariable Long id) {
		alumnoRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@GetMapping("/{id}/profesores")
	public ResponseEntity<Collection<Profesor>> getProfesores(@PathVariable Long id) {
		Alumno alumno = alumnoRepository.findById(id).orElseThrow();
		
		if (alumno != null) {
			return new ResponseEntity<>(alumno.getProfesores(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
