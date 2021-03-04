package com.preving.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.preving.springboot.backend.apirest.models.entity.Cesta;
import com.preving.springboot.backend.apirest.models.services.ICestaService;

@RestController @RequestMapping("/api") @CrossOrigin
public class CestaRestControllers {

	@Autowired private ICestaService cestaService;
	
	@GetMapping("/cesta")
	public List<Cesta> cestaIndex(){
		return cestaService.findAll();
	}
	
	@GetMapping("/cesta/{id_cesta}")
	public Cesta show (@PathVariable Long id_cesta) {
		return cestaService.findById(id_cesta);
	}
	
	@PostMapping("/cesta") @ResponseStatus(HttpStatus.CREATED)
	public int create(@RequestBody Cesta cesta) {
		return cestaService.save(cesta);
	}
	
	@PutMapping("/cesta/{id_cesta}") @ResponseStatus(HttpStatus.CREATED)
	public int update(@RequestBody Cesta cesta, @PathVariable Long id_cesta) {
		
		cesta.setId_cesta(id_cesta);
		
		return cestaService.update(cesta);
	}
	
	@DeleteMapping("/cesta/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
	public int delete(@PathVariable Long id_cesta) {
		
		return cestaService.delete(id_cesta);
	}
	
}
