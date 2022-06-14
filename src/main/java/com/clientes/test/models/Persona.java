package com.clientes.test.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
@Entity
@Table(name = "Persona")
public class Persona {
  @Id
  @NotNull
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull
  private String nombre;

  @NotNull
  private String apellidoPaterno;

  private String apellidoMaterno;

  @NotNull
  private int identificacion;

  @NotNull
  private String correo;

  @NotNull
  private String contraseña;
  
  @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL)
  private Set<Factura> facturas = new HashSet<>();

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellidoPaterno() {
	return apellidoPaterno;
}

public void setApellidoPaterno(String apellidoPaterno) {
	this.apellidoPaterno = apellidoPaterno;
}

public String getApellidoMaterno() {
	return apellidoMaterno;
}

public void setApellidoMaterno(String apellidoMaterno) {
	this.apellidoMaterno = apellidoMaterno;
}

public int getIdentificacion() {
	return identificacion;
}

public void setIdentificacion(int identificacion) {
	this.identificacion = identificacion;
}

public String getCorreo() {
	return correo;
}

public void setCorreo(String correo) {
	this.correo = correo;
}

public String getContraseña() {
	return contraseña;
}

public void setContraseña(String contraseña) {
	this.contraseña = contraseña;
}

public Set<Factura> getFacturas() {
	return facturas;
}

public void setFacturas(Set<Factura> facturas) {
	this.facturas = facturas;
	for (Factura factura : facturas) {
		factura.setPersona(this);
	}
}
  
  
}
