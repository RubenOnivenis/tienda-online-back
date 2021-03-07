package com.preving.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preving.springboot.backend.apirest.models.entity.ComentariosDatos;
import com.preving.springboot.backend.apirest.models.services.IComentariosDatosService;

@RestController @RequestMapping("/api") @CrossOrigin(origins = {"http://localhost:4200"})
public class ComentariosDatosControllers {

	@Autowired IComentariosDatosService comentariosDatosService;
	
	@GetMapping("/comentariosDatos")
	public List<ComentariosDatos> findAll(){
		return comentariosDatosService.findAll();
	}
	
	@GetMapping("/comentariosDatos/{id_comentario}")
	public List<ComentariosDatos> show(@PathVariable Long id_comentario){
		return comentariosDatosService.findById(id_comentario);
	}
}
