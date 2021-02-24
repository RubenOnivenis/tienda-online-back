package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	
	public int save(Producto producto);
	
	public int delete(Long id);
	
	public Producto findById(Long id);
	
	public List<Producto> findByNombre(String nombre);
	
	public int insert(Producto producto);
	
	public int update(Producto producto);
	
}
