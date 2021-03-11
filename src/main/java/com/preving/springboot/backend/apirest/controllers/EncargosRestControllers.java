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
	
	@GetMapping("/encargo/{id_usuario}")
	public List<Encargos> show(@PathVariable Long id_usuario) {
		
		return encargosService.findById(id_usuario);
	}
	
	@GetMapping("/encargoId/{id_encargo}")
	public List<Encargos> showEncargo(@PathVariable Long id_encargo){
		
		return encargosService.findByIdEncargo(id_encargo);
	}
	
	@GetMapping("/encargosId/{id_usuario}")
	public Long verUltimoId(@PathVariable Long id_usuario) {
		
		List<Encargos> lista = encargosService.ultimoId(id_usuario);
		
		return lista.get(0).getId_encargo();
	}
	
	@PostMapping("/encargos") @ResponseStatus(HttpStatus.CREATED)
	public Number create(@RequestBody Encargos encargos) {
		
		return encargosService.save(encargos);
	}
	
	@DeleteMapping("/encargos/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
	public int delete(@PathVariable Long id) {
		
		return encargosService.delete(id);
	}
	
	@PutMapping("/encargosEstado/{id_encargo}") @ResponseStatus(HttpStatus.CREATED)
	public int modificarEstado(@RequestBody Encargos encargos, @PathVariable Long id_encargo) {
		
		encargos.setId_encargo(id_encargo);
		
		return encargosService.modificarEstado(encargos, id_encargo);
	}
}
