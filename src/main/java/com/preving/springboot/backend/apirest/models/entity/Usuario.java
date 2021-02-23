package com.preving.springboot.backend.apirest.models.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity @Table(name="usuarios")
public class Usuario implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id_usuario;
	private String nombre_usuario;
	private String nombre;
	private String apellido;
	private String correo;
	private String pass;
	private String cod_postal;
	private String domicilio;
	private String localidad;
	private String provincia;
	private String cod_postal_2;
	private String domicilio_2;
	private String localidad_2;
	private String provincia_2;
	private String tarjeta_credito;
	private String telefono;
	
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCod_postal() {
		return cod_postal;
	}
	public void setCod_postal(String cod_postal) {
		this.cod_postal = cod_postal;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getCod_postal_2() {
		return cod_postal_2;
	}
	public void setCod_postal_2(String cod_postal_2) {
		this.cod_postal_2 = cod_postal_2;
	}
	public String getDomicilio_2() {
		return domicilio_2;
	}
	public void setDomicilio_2(String domicilio_2) {
		this.domicilio_2 = domicilio_2;
	}
	public String getLocalidad_2() {
		return localidad_2;
	}
	public void setLocalidad_2(String localidad_2) {
		this.localidad_2 = localidad_2;
	}
	public String getProvincia_2() {
		return provincia_2;
	}
	public void setProvincia_2(String provincia_2) {
		this.provincia_2 = provincia_2;
	}
	public String getTarjeta_credito() {
		return tarjeta_credito;
	}
	public void setTarjeta_credito(String tarjeta_credito) {
		this.tarjeta_credito = tarjeta_credito;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	private static final long serialVersionUID = 1L;
	
}
