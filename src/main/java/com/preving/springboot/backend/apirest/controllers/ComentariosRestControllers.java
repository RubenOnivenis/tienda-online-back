package com.preving.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.preving.springboot.backend.apirest.models.entity.Comentarios;
import com.preving.springboot.backend.apirest.models.services.IComentariosService;

@RestController @RequestMapping ("/api") @CrossOrigin
public class ComentariosRestControllers {
	
	@Autowired private IComentariosService comentariosService; 
	
	@GetMapping("/comentarios")
	public List<Comentarios> comentariosIndex(){
		return comentariosService.findAll();
	}
	
	@GetMapping("/comentarios/{id_comentario}")
	public Comentarios show(@PathVariable Long id_comentario) {
		return comentariosService.findById(id_comentario);
	}
	
	@PostMapping("/comentarios") @ResponseStatus(HttpStatus.CREATED)	//Crear usuario
	public int create(@RequestBody Comentarios comentarios) {
		
		return comentariosService.save(comentarios);
	}
	
	@PutMapping("/comentarios/{id}") @ResponseStatus(HttpStatus.CREATED)	//Modificar usuario, menos la contraseña
	public int update(@RequestBody Comentarios comentarios, @PathVariable Long id_comentario) {
		
		comentarios.setId_comentario(id_comentario);
		
		return comentariosService.update(comentarios);
	}
	
	@DeleteMapping("/comentarios/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
	public int delete(@PathVariable Long id_comentario) {
		
		return comentariosService.delete(id_comentario);
	}
}
