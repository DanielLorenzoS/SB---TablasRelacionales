package com.clientes.test.controllers;

import com.clientes.test.models.Persona;
import com.clientes.test.repositories.PersonaRepository;
import com.clientes.test.services.Directorio;

import java.net.URI;
import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/persona")
public class PersonaController {
    @Autowired
    Directorio personaService;
    
    @Autowired
    PersonaRepository personaRepository;

    @GetMapping
    public ResponseEntity<Page<Persona>> findPersonas(Pageable pageable) {
        return ResponseEntity.ok(personaRepository.findAll(pageable));
    } 
    
    @PostMapping
    public ResponseEntity<Persona> guardarPersona(@Valid @RequestBody Persona persona) {
        Persona personaGuardada = personaRepository.save(persona);
        
        URI ubicacion = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(personaGuardada.getId()).toUri();
        
        return ResponseEntity.created(ubicacion).body(personaGuardada);
    }

    @GetMapping("/query")
    public ArrayList<Persona> obtenerPersonaPorIdentificacion(
            @RequestParam("identificacion") Integer identificacion
    ) {
        return this.personaService.obtenerPersonaPorIdentificacion(identificacion);
    }

    @DeleteMapping(value = "/{identificacion}")
    public String eliminarPersonaPorIdentificador(@PathVariable("identificacion") Integer identificacion) {
        boolean ok =
                this.personaService.eliminarPersonaPorIdentificacion(identificacion);
        if (ok) {
            return "Se eliminó a la persona seleccionada";
        } else {
            return "No se pudo eliminar a la persona seleccionada";
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok = this.personaService.eliminarPorId(id);
        if (ok) {
            return "Se eliminó a la persona seleccionada";
        } else {
            return "No se pudo eliminar a la persona seleccionada";
        }
    }

    @GetMapping("/login/query")
    public ArrayList<Persona> obtenerPersonaPorCorreo(@RequestParam("correo") String correo) {
        return this.personaService.obtenerPersonaPorCorreo(correo);
    }
}
