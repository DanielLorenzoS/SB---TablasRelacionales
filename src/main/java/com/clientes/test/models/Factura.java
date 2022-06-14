package com.clientes.test.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sun.istack.NotNull;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Validated
@Entity
@Table(name = "Factura")
public class Factura {

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String fecha;
	@NotNull
	private String concepto;
	@NotNull
	private String iva;
	@NotNull
	private double cuotaIva;
	@NotNull
	private double total;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "persona_id")
	@JsonProperty(access = Access.WRITE_ONLY)
	private Persona persona;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public double getCuotaIva() {
		return cuotaIva;
	}

	public void setCuotaIva(double cuotaIva) {
		this.cuotaIva = cuotaIva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
