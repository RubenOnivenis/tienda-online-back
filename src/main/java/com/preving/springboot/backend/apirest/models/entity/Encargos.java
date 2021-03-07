package com.preving.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity @Table(name="encargos") 
public class Encargos implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id_encargo;
	@NotNull private Long id_usuario;
	@NotNull private Float precio_encargo;
	@NotNull private Date fch_pedido;
	//@NotNull private String codigo_descuento;
	@NotNull private Date fch_encargo_enviado;
	private Date fch_encargo_recibido;
	
	public Long getId_encargo() {
		return id_encargo;
	}
	public void setId_encargo(Long id_encargo) {
		this.id_encargo = id_encargo;
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
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
	/*public String getCodigo_descuento() {
		return codigo_descuento;
	}
	public void setCodigo_descuento(String codigo_descuento) {
		this.codigo_descuento = codigo_descuento;
	}*/
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
