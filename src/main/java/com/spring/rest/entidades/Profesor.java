package com.spring.rest.entidades;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profesores")
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profesor_id")
	private long id;

	private String nombre;

	@Column(name = "profesor_edad")
	private int edad;

	@ManyToMany
	@JoinTable(name = "alumnos_profesores", joinColumns = @JoinColumn(name = "profesor_id", referencedColumnName = "profesor_id"), inverseJoinColumns = @JoinColumn(name = "alumno_id", referencedColumnName = "alumno_id"))
	private Set<Alumno> alumnos = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Set<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}
