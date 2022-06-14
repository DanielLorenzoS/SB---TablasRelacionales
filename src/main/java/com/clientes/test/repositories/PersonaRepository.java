package com.clientes.test.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.clientes.test.models.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long>{
    public abstract ArrayList<Persona> findPersonaByIdentificacion(Integer identificacion);

    public abstract ArrayList<Persona> deletePersonaByIdentificacion(Integer identificacion);

    public abstract ArrayList<Persona> findByCorreo(String correo);
    
}
