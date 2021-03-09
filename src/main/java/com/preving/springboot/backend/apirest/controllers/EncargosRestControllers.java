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
	
	@GetMapping("/encargo/{id_encargos}")
	public List<Encargos> show(@PathVariable Long id_encargos) {
		
		return encargosService.findById(id_encargos);
	}
	
	@GetMapping("/encargosId/{id_usuario}")
	public Encargos verUltimoId(@PathVariable Long id_usuario) {
		
		return encargosService.ultimoId(id_usuario);
	}
	
	@PostMapping("/encargos") @ResponseStatus(HttpStatus.CREATED)
	public int create(@RequestBody Encargos encargos) {
		
		return encargosService.save(encargos);
	}
	
	/*@PutMapping("/encargos/{id_encargo}") @ResponseStatus(HttpStatus.CREATED)
	public Encargos update(@RequestBody Encargos encargos, @PathVariable Long id_encargo) {
		
		encargos.setId_encargo(id_encargo);
		
		return encargosService.update(encargos);
	}*/
	
	@DeleteMapping("/encargos/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
	public int delete(@PathVariable Long id) {
		
		return encargosService.delete(id);
		
	}
}
