package com.preving.springboot.backend.apirest.models.entity;

import java.io.Serializable;

public class CestaDatos implements Serializable {

	private Long id;
	private String nombre;
	private String imagen;
	private String precio;
	
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	private static final long serialVersionUID = 1L;
	
}
