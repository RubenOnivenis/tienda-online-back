package com.preving.springboot.backend.apirest.models.entity;

import java.io.Serializable;

public class CestaDatos implements Serializable {

	private Long id;
	private Long id_producto;
	private String nombre;
	private String imagen;
	private Float precio;
	private Float precio_oferta;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_producto() {
		return id_producto;
	}
	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
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
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}	
	public Float getPrecio_oferta() {
		return precio_oferta;
	}
	public void setPrecio_oferta(Float precio_oferta) {
		this.precio_oferta = precio_oferta;
	}


	private static final long serialVersionUID = 1L;
	
}
