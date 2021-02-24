package com.preving.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.preving.springboot.backend.apirest.models.entity.Producto;

public interface IProductoDao{
	
	
	public List<Producto> getProducto();
	
	public Producto getClienteById(Long id);
	
	public List<Producto> getProductoByNombre(String Nombre);
	
	public int insert(Producto roducto);
	
	public int delete(Long id);
	
	public int update(Producto producto);
}
