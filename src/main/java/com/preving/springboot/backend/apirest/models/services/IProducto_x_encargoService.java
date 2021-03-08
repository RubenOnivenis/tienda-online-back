package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.Productos_x_encargos;

public interface IProducto_x_encargoService {

	
	public List<Productos_x_encargos> findAll();
	
	public int save(Productos_x_encargos producto_x_encargo);
	
	public int delete(Long id);
	
	public Productos_x_encargos findById(Long id);
	
	public int update(Productos_x_encargos Producto_x_encargo);
	
}
