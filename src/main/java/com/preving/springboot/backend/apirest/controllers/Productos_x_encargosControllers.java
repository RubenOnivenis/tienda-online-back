package com.preving.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.preving.springboot.backend.apirest.models.entity.Productos_x_encargos;
import com.preving.springboot.backend.apirest.models.services.IProducto_x_encargoService;

@RestController @RequestMapping("/api") @CrossOrigin(origins = {"http://localhost:4200"})
public class Productos_x_encargosControllers {

	@Autowired private IProducto_x_encargoService productos_x_encargosService;
	
	@GetMapping("/productos_x_encargos")
	public List<Productos_x_encargos> productos_x_encargosIndex(){
		
		return productos_x_encargosService.findAll();
	}
	
	@GetMapping("/productos_x_encargos/{id}")
	public Productos_x_encargos show(@PathVariable Long id) {
		
		return productos_x_encargosService.findById(id);
	}
	
	@PostMapping("/productos_x_encargos") @ResponseStatus(HttpStatus.CREATED)
	public Number create(@RequestBody Productos_x_encargos Producto_x_encargo) {
		return productos_x_encargosService.save(Producto_x_encargo);
	}
	
	@DeleteMapping("/productos_x_encargos/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
	public int delete(@PathVariable Long id) {
		
		return productos_x_encargosService.delete(id);
		
	}
}
