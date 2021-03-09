package com.preving.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preving.springboot.backend.apirest.models.entity.DetallesProducto;
import com.preving.springboot.backend.apirest.models.services.IDetallesProductoService;

@RestController @RequestMapping("/api") @CrossOrigin(origins = {"http://localhost:4200"})
public class DetallesProductoControllers {

	@Autowired IDetallesProductoService detallesProductoService;
	
	@GetMapping("/detallesProducto/{id_encargo}")
	public List<DetallesProducto> show(@PathVariable Long id_encargo){
		return detallesProductoService.findById(id_encargo);
	}
}
