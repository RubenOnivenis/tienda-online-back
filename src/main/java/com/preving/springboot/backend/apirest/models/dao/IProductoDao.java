package com.preving.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.preving.springboot.backend.apirest.models.entity.Producto;

public interface IProductoDao{
	
	
	public List<Producto> getProducto();
	
	public Producto getProductoById(Long id_producto);
	
	public List<Producto> getProductoByNombre(String nombre);
	
	public int insert(Producto roducto);
	
	public int delete(Long id_producto);
	
	public int update(Producto producto);
}
