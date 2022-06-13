package com.spring.rest.controladores;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.rest.entidades.Biblioteca;
import com.spring.rest.repositorios.BibliotecaRepository;

@RestController
@RequestMapping("/api/biblioteca")
public class BibliotecaController {

	@Autowired
	private BibliotecaRepository bibliotecaRepository;
	
	//Response Entity se crea ya automaticamente cuando se genera una clase "clásica", sólo que aquí especificamos sus valores
	@GetMapping  			//Page Pageable -> Sirve para generar diversas capas en el REST (Json)
	public ResponseEntity<Page<Biblioteca>> listarBibliotecas(Pageable pageable){
		return ResponseEntity.ok(bibliotecaRepository.findAll(pageable)); //Extrae las diferentes bibliotecas o clases padre
	}

	@PostMapping												//@Valid se usa para concretar las validaciones en las entidades
	public ResponseEntity<Biblioteca> guardarBiblioteca(@Valid @RequestBody Biblioteca biblioteca) {
		//Guarda en la variable las bibliotecas del repositorio
		Biblioteca bibliotecaGuardada = bibliotecaRepository.save(biblioteca);
		//Extrae el o los id de las bibliotecas guardadas
			//SUCB crea elaces basados en HTTPServletRequest el cual  proporciona un acceso a los datos de cabecera
		URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(bibliotecaGuardada.getId()).toUri();
		//Devuelve un status de creación
		return ResponseEntity.created(ubicacion).body(bibliotecaGuardada);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Biblioteca> actualizarBiblioteca(@PathVariable Integer id, @Valid @RequestBody Biblioteca biblioteca) {
		Optional<Biblioteca> bibliotecaOptional = bibliotecaRepository.findById(id);

		if (!bibliotecaOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		biblioteca.setId(bibliotecaOptional.get().getId());
		bibliotecaRepository.save(biblioteca);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Biblioteca> eliminarBiblioteca(@PathVariable Integer id) {
		Optional<Biblioteca> bibliotecaOptional = bibliotecaRepository.findById(id);

		if (!bibliotecaOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		bibliotecaRepository.delete(bibliotecaOptional.get());
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Biblioteca> obtenerBibliotecaPorId(@PathVariable Integer id){
		Optional<Biblioteca> bibliotecaOptional = bibliotecaRepository.findById(id);

		if (!bibliotecaOptional.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.ok(bibliotecaOptional.get());
	}
	
}




