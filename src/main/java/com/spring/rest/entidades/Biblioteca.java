package com.spring.rest.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "biblioteca")
public class Biblioteca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	private String nombre;
	
	//Modelo Uno a muchos, este tipo de cascada permite eliminar todos los elementos del hijo al eliminar al padre
	//MappedBy indica que será el encargado de la columna de la clave externa y obtendrá las entidades y aplicará la cascada
	@OneToMany(mappedBy = "biblioteca", cascade = CascadeType.ALL)
	private Set<Libro> libros = new HashSet<>(); //Hash es un arreglo mejorado que permite agregar rápidamente, pero sin orden

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
		
		for (Libro libro : libros) {
			libro.setBiblioteca(this); //Obtención funcional que cada libro
		}
	}

}
