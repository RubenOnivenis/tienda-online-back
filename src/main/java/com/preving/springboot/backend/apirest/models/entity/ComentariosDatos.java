package com.preving.springboot.backend.apirest.models.entity;

import java.io.Serializable;

public class ComentariosDatos implements Serializable {

	private String comentario;
	private String nombre;
	private String nombre_usuario;

	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private static final long serialVersionUID = 1L;
	
}
