package com.clientes.test.services;

import com.clientes.test.models.Persona;
import com.clientes.test.repositories.PersonaRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Directorio {
    ArrayList<Persona> personaToDelete;

    @Autowired
    PersonaRepository personaRepository;

    public ArrayList<Persona> obtenerPersonaPorIdentificacion(Integer identificacion) {
        return personaRepository.findPersonaByIdentificacion(identificacion);
    }

    public ArrayList<Persona> findPersonas() {
        return (ArrayList<Persona>) personaRepository.findAll();
    }

    public boolean eliminarPersonaPorIdentificacion(Integer identificacion) {
        try {
            personaToDelete =
                    personaRepository.findPersonaByIdentificacion(identificacion);
            personaRepository.deleteAll(personaToDelete);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public boolean eliminarPorId(Long id) {
        try {
            personaRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<Persona> obtenerPersonaPorCorreo(String correo) {
        return personaRepository.findByCorreo(correo);
    }
}
