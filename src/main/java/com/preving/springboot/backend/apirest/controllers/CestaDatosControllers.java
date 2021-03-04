package com.preving.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preving.springboot.backend.apirest.models.entity.CestaDatos;
import com.preving.springboot.backend.apirest.models.services.ICestaDatosService;

@RestController @RequestMapping("/api") @CrossOrigin(origins = {"http://localhost:4200"})
public class CestaDatosControllers {

	@Autowired ICestaDatosService cestaDatosService;
	
	@GetMapping("/cestaDatos")
	public List<CestaDatos> findAll(){
		return cestaDatosService.findAll();
	}
	
	@GetMapping("/cestaDatos/{id_cesta}")
	public List<CestaDatos> show(@PathVariable Long id_cesta){
		return cestaDatosService.findById(id_cesta);
	}
	
}
