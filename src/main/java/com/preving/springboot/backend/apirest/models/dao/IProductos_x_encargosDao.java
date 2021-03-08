package com.preving.springboot.backend.apirest.models.dao;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.Productos_x_encargos;

public interface IProductos_x_encargosDao {

	public List<Productos_x_encargos> getProductos_x_encargos();
	
	public Productos_x_encargos getProducto_x_encargosById(Long id);
	
	public int insert(Productos_x_encargos Producto_x_encargo);
	
	public int delete(Long id);
	
	public int update(Productos_x_encargos Producto_x_encargo);
	
}
