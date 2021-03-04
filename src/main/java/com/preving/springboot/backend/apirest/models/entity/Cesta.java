package com.preving.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity @Table(name="cesta")
public class Cesta implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id_cesta;
	@NotNull private Long id_usuario;
	@NotNull private Long id_producto;

	public Long getId_cesta() {
		return id_cesta;
	}

	public void setId_cesta(Long id_cesta) {
		this.id_cesta = id_cesta;
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}
	
	private static final long serialVersionUID = 1L;
	
}
