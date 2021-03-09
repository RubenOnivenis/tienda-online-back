package com.preving.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

public class DetallesProducto implements Serializable{

	private Long id;
	private Long id_producto;
	private Long id_encargo;
	private String nombre;
	private String imagen;
	private Float precio_producto;
	private Integer cantidad;
	private Float precio_encargo;
	private Date fch_pedido;
	private Date fch_encargo_enviado;
	private Date fch_encargo_recibido;
	
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
	
	public Long getId_encargo() {
		return id_encargo;
	}
	public void setId_encargo(Long id_encargo) {
		this.id_encargo = id_encargo;
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

	public Float getPrecio_producto() {
		return precio_producto;
	}
	public void setPrecio_producto(Float precio_producto) {
		this.precio_producto = precio_producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Float getPrecio_encargo() {
		return precio_encargo;
	}
	public void setPrecio_encargo(Float precio_encargo) {
		this.precio_encargo = precio_encargo;
	}

	public Date getFch_pedido() {
		return fch_pedido;
	}
	public void setFch_pedido(Date fch_pedido) {
		this.fch_pedido = fch_pedido;
	}

	public Date getFch_encargo_enviado() {
		return fch_encargo_enviado;
	}
	public void setFch_encargo_enviado(Date fch_encargo_enviado) {
		this.fch_encargo_enviado = fch_encargo_enviado;
	}

	public Date getFch_encargo_recibido() {
		return fch_encargo_recibido;
	}
	public void setFch_encargo_recibido(Date fch_encargo_recibido) {
		this.fch_encargo_recibido = fch_encargo_recibido;
	}

	private static final long serialVersionUID = 1L;

}
