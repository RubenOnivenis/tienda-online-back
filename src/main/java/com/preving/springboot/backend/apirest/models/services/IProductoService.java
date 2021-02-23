package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	
	public Producto save(Producto producto);
	
	public void delete(Long id);
	
	public Producto findById(Long id);
	
}
