package com.preving.springboot.backend.apirest.models.entity;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity @Table(name="comentarios")
public class Comentarios {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)private Long id_comentario;
	@NotNull private String comentario;
	@NotNull private Long id_producto;
	@NotNull private Long id_usuario;
	
	public Long getId_comentario() {
		return id_comentario;
	}
	public void setId_comentario(Long id_comentario) {
		this.id_comentario = id_comentario;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Long getId_producto() {
		return id_producto;
	}
	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	
}
