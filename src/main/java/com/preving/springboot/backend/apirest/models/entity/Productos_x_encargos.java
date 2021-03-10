package com.preving.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity @Table(name="producto_x_encargo")
public class Productos_x_encargos implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
	@NotNull private Long id_encargo;
	@NotNull private Long id_producto;
	@NotNull private Float precio_producto;
	@NotNull private Long cantidad;
	@NotNull private Long id_usuario;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_encargo() {
		return id_encargo;
	}
	public void setId_encargo(Long id_encargo) {
		this.id_encargo = id_encargo;
	}
	public Long getId_producto() {
		return id_producto;
	}
	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}
	public Float getPrecio_producto() {
		return this.precio_producto;
	}
	public void setPrecio_producto(Float precio_producto) {
		this.precio_producto = precio_producto;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}	
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}


	private static final long serialVersionUID = 1L;
	
}
