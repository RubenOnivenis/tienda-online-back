package com.preving.springboot.backend.apirest.models.entity;

import java.util.*;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity @Table(name="devolucion")
public class Devolucion {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id_devolucion;
	
	@NotNull @JoinTable(name="encargos", joinColumns = @JoinColumn(name = "id_encargo")) 
	private Long id_encargo;
	
	@NotNull @Temporal(TemporalType.DATE)
	private Date fch_encargo_cancelado_devuelto;
	
	private String encargo_cncl_devuelto_descripcion;
	
	@NotNull 
	private Boolean encargo_cncl_devuelto;
	
	public void prePersist() {
		fch_encargo_cancelado_devuelto = new Date();
	}

	public Long getId_devolucion() {
		return id_devolucion;
	}

	public void setId_devolucion(Long id_devolucion) {
		this.id_devolucion = id_devolucion;
	}

	public Long getId_encargo() {
		return id_encargo;
	}

	public void setId_encargo(Long id_encargo) {
		this.id_encargo = id_encargo;
	}

	public Date getFch_encargo_cancelado_devuelto() {
		return fch_encargo_cancelado_devuelto;
	}

	public void setFch_encargo_cancelado_devuelto(Date fch_encargo_cancelado_devuelto) {
		this.fch_encargo_cancelado_devuelto = fch_encargo_cancelado_devuelto;
	}

	public String getEncargo_cncl_devuelto_descripcion() {
		return encargo_cncl_devuelto_descripcion;
	}

	public void setEncargo_cncl_devuelto_descripcion(String encargo_cncl_devuelto_descripcion) {
		this.encargo_cncl_devuelto_descripcion = encargo_cncl_devuelto_descripcion;
	}

	public Boolean getEncargo_cncl_devuelto() {
		return encargo_cncl_devuelto;
	}

	public void setEncargo_cncl_devuelto(Boolean encargo_cncl_devuelto) {
		this.encargo_cncl_devuelto = encargo_cncl_devuelto;
	}
	
	
}
