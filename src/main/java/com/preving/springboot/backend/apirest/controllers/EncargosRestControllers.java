package com.preving.springboot.backend.apirest.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.preving.springboot.backend.apirest.models.entity.Encargos;
import com.preving.springboot.backend.apirest.models.services.IEncargosService;

@RestController @RequestMapping("/api") @CrossOrigin(origins = {"http://localhost:4200"})
public class EncargosRestControllers {
	
	@Autowired private IEncargosService encargosService;
	
	@GetMapping("/encargos")
	public List<Encargos> encargosIndex(){
		
		return encargosService.findAll();
	}
	
	@GetMapping("/encargo/{id}")
	public Encargos show(@PathVariable Long id) {
		
		return encargosService.findById(id);
	}
	
	@PostMapping("/encargos/{id}") @ResponseStatus(HttpStatus.CREATED)
	public Encargos update(@RequestBody Encargos encargos, @PathVariable Long id) {
		
		Encargos encargosActuales = encargosService.findById(id);
		encargosActuales.setCodigo_descuento(encargos.getCodigo_descuento());
		encargosActuales.setPrecio_encargo(encargos.getPrecio_encargo());
		
		return encargosService.save(encargosActuales);
	}
	
	@DeleteMapping("/encargos/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		
		encargosService.delete(id);
		
	}
}
