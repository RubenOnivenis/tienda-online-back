package com.preving.springboot.backend.apirest.security.entity;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.preving.springboot.backend.apirest.models.entity.Usuario;

public class SUsuarioPrincipal implements UserDetails{
	
	private String nombre_usuario;
	private String nombre;
	private String apellidos;
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
	private Collection<? extends GrantedAuthority> authorities;
	
	public SUsuarioPrincipal(String nombre_usuario, String nombre, String apellidos, String correo, String pass,
			String cod_postal, String domicilio, String localidad, String provincia, String cod_postal_2,
			String domicilio_2, String localidad_2, String provincia_2, String tarjeta_credito, String telefono,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.nombre_usuario = nombre_usuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.pass = pass;
		this.cod_postal = cod_postal;
		this.domicilio = domicilio;
		this.localidad = localidad;
		this.provincia = provincia;
		this.cod_postal_2 = cod_postal_2;
		this.domicilio_2 = domicilio_2;
		this.localidad_2 = localidad_2;
		this.provincia_2 = provincia_2;
		this.tarjeta_credito = tarjeta_credito;
		this.telefono = telefono;
		this.authorities = authorities;
	}

	/*public static SUsuarioPrincipal build(Usuario usuario) {
		List<GrantedAuthority> authorities = usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
				.getRolNombe().name())).collect(Collectors.toList());
				
		return new UsuarioPrincipal(LE PASAMOS TODOS LOS GET);
	}*/
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}
	
	@Override
	public String getPassword() {
		
		return pass;
	}
	
	@Override
	public String getUsername() {
		
		return nombre_usuario;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public String getCod_postal() {
		return cod_postal;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getLocalidad() {
		return localidad;
	}

	public String getProvincia() {
		return provincia;
	}


	public String getCod_postal_2() {
		return cod_postal_2;
	}

	public String getDomicilio_2() {
		return domicilio_2;
	}

	public String getLocalidad_2() {
		return localidad_2;
	}

	public String getProvincia_2() {
		return provincia_2;
	}

	public String getTarjeta_credito() {
		return tarjeta_credito;
	}

	public String getTelefono() {
		return telefono;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		
		return true;
	}
	
	
}
