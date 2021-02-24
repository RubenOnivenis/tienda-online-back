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

import com.preving.springboot.backend.apirest.models.entity.Producto;
import com.preving.springboot.backend.apirest.models.services.IProductoService;

@RestController @RequestMapping("/api") @CrossOrigin(origins = {"http://localhost:4200"})
public class ProuctoRestControllers {

	@Autowired private IProductoService productoService;
	
	@GetMapping("/productos") //Ver todos los productos
	public List<Producto> productosIndex(){
		
		return productoService.findAll();
	}
	
	@GetMapping("/producto/{id}")	//Ver un solo producto id
	public Producto show(@PathVariable Long id) {
		
		return productoService.findById(id);
	}
	
	@GetMapping("/producto/nombre/{nombre}")	//Ver un producto por nombre (Buscador)
	public List<Producto> show(@PathVariable String nombre){
		
		return productoService.findByNombre(nombre);
	}
	
	@PostMapping("/productos") @ResponseStatus(HttpStatus.CREATED)	//Añadir producto
	public int create(@RequestBody Producto producto) {
		
		return productoService.save(producto);
	}
	
	@PutMapping("/productos") @ResponseStatus(HttpStatus.CREATED)	//Modificar producto
	public int update(@RequestBody Producto producto, @PathVariable Long id) {
		
		producto.setId(id);
		
		return productoService.update(producto);
	}
	
	@DeleteMapping("/producto/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)	//Borrar producto
	public int delete(@PathVariable Long id) {
		
		return productoService.delete(id);
	}
	
	
}
