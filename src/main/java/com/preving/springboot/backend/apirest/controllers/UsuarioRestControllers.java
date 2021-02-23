package com.preving.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.preving.springboot.backend.apirest.models.entity.Usuario;
import com.preving.springboot.backend.apirest.models.services.IUsuarioService;

@RestController @RequestMapping("/api") @CrossOrigin(origins = {"http://localhost:4200"})
public class UsuarioRestControllers {

	@Autowired private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")	//Todos los usuarios
	public List<Usuario> usuariosIndex(){
		
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario show(@PathVariable Long id) {
		
		return usuarioService.findById(id);
	}
	
	@PostMapping("/usuarios/{id}") @ResponseStatus(HttpStatus.CREATED)
	public Usuario update(@RequestBody Usuario usuario, @PathVariable Long id) {
		
		Usuario usuarioActual = usuarioService.findById(id);
		usuarioActual.setNombre_usuario(usuario.getNombre_usuario());
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setApellido(usuario.getApellido());
		usuarioActual.setCorreo(usuario.getCorreo());
		usuarioActual.setPass(usuario.getPass());
		usuarioActual.setCod_postal(usuario.getCod_postal());
		usuarioActual.setDomicilio(usuario.getDomicilio());
		usuarioActual.setLocalidad(usuario.getLocalidad());
		usuarioActual.setProvincia(usuario.getProvincia());
		usuarioActual.setCod_postal_2(usuario.getCod_postal_2());
		usuarioActual.setDomicilio_2(usuario.getDomicilio_2());
		usuarioActual.setLocalidad_2(usuario.getLocalidad_2());
		usuarioActual.setProvincia_2(usuario.getProvincia_2());
		usuarioActual.setTarjeta_credito(usuario.getTarjeta_credito());
		usuarioActual.setTelefono(usuario.getTelefono());
		
		return usuarioService.save(usuarioActual);
	}
	
	@DeleteMapping("/usuarios/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		
		usuarioService.delete(id);
		
	}
}
