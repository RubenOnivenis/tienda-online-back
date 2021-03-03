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
//import org.springframework.web.bind.annotation.RestController;

import com.preving.springboot.backend.apirest.models.entity.Devolucion;
import com.preving.springboot.backend.apirest.models.services.IDevolucionService;

 @RequestMapping("/api") @CrossOrigin(origins = {"http://localhost:4200"})
public class DevolucionRestController {

	@Autowired private IDevolucionService devolucionService;
	
	@GetMapping("/devoluciones")
	public List<Devolucion> devolucionesIndex(){
		
		return devolucionService.findAll();
	}
	
	@GetMapping("/devolucion/{id_devolucion}")
	public Devolucion show (@PathVariable Long id_devolucion) {
		
		return devolucionService.findById(id_devolucion);
	}
	
	@PostMapping("/devoluciones") @ResponseStatus(HttpStatus.CREATED)
	public int create(@RequestBody Devolucion devolucion) {
		
		return devolucionService.save(devolucion);
	}
	
	@PutMapping("/devoluciones") @ResponseStatus(HttpStatus.CREATED)
	public int update(@RequestBody Devolucion devolucion, @PathVariable Long id) {
		
		devolucion.setId_devolucion(id);
		
		return devolucionService.update(devolucion);
	}
	
	@DeleteMapping("/devoluciones/{id_devolucion}") @ResponseStatus(HttpStatus.NO_CONTENT)
	public int delete(@PathVariable Long id) {
		
		return devolucionService.delete(id);
	}
}
