package com.preving.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity @Table(name="productos")
public class Producto implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id_producto;
	private String nombre;
	private Integer precio;
	private String imagen;
	private String descr;
	@Column(name = "dias_consumicion") private Integer diasConsumicion;
	private String ingredientes;
	private String imagen_oferta;
	
	public Long getId() {
		return id_producto;
	}
	public void setId(Long id_producto) {
		this.id_producto = id_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public Integer getDiasConsumicion() {
		return diasConsumicion;
	}
	public void setDiasConsumicion(Integer diasConsumicion) {
		this.diasConsumicion = diasConsumicion;
	}
	public String getIngredientes() {
		return ingredientes;
	}
	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}
	public String getImagen_oferta() {
		return imagen_oferta;
	}
	public void setImagen_oferta(String imagen_oferta) {
		this.imagen_oferta = imagen_oferta;
	}
	private static final long serialVersionUID = 1L;
}
