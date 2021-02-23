package com.preving.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.preving.springboot.backend.apirest.models.entity.Producto;
import com.preving.springboot.backend.apirest.models.services.IProductoService;

@RestController @RequestMapping("/api") @CrossOrigin(origins = {"http://localhost:4200"})
public class ProuctoRestControllers {

	@Autowired private IProductoService productoService;
	
	@GetMapping("/productos") //Todos los productos
	public List<Producto> productosIndex(){
		
		return productoService.findAll();
	}
	
	@GetMapping("/producto/{id}")
	public Producto show(@PathVariable Long id) {
		
		return productoService.findById(id);
	}
	
	/*@PutMapping("/productos/{id}") @ResponseStatus(HttpStatus.CREATED)
	public Producto update(@RequestBody Producto producto, @PathVariable Long id) {
		
		Producto productoActual = productoService.findById(id);
		productoActual.setNombre(producto.getNombre());
		
		return productoService.save(productoActual);
		
	}*/
	
}
