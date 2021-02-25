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
	
	@GetMapping("/usuario/{id_usuario}")
	public Usuario show(@PathVariable Long id_usuario) {
		
		return usuarioService.findById(id_usuario);
	}
	
	@PostMapping("/usuarios") @ResponseStatus(HttpStatus.CREATED)
	public int create(@RequestBody Usuario usuario) {
		
		return usuarioService.save(usuario);
	}
	
	@PostMapping("/usuarios/{id}") @ResponseStatus(HttpStatus.CREATED)
	public int update(@RequestBody Usuario usuario, @PathVariable Long id) {
		
		usuario.setId_usuario(id);
		
		return usuarioService.update(usuario);
	}
	
	@DeleteMapping("/usuarios/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
	public int delete(@PathVariable Long id) {
		
		return usuarioService.delete(id);
	}
}
