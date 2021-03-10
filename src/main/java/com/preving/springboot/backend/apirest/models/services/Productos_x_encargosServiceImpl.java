package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preving.springboot.backend.apirest.models.dao.IProductos_x_encargosDao;
import com.preving.springboot.backend.apirest.models.entity.Productos_x_encargos;

@Service
public class Productos_x_encargosServiceImpl implements IProducto_x_encargoService{

	@Autowired private IProductos_x_encargosDao productos_x_encargosDao;
	
	@Override
	public List<Productos_x_encargos> findAll() {

		return productos_x_encargosDao.getProductos_x_encargos();
	}

	@Override
	public Number save(Productos_x_encargos producto_x_encargo) {

		return productos_x_encargosDao.insert(producto_x_encargo);
	}

	@Override
	public int delete(Long id) {

		return productos_x_encargosDao.delete(id);
	}

	@Override
	public Productos_x_encargos findById(Long id) {

		return productos_x_encargosDao.getProducto_x_encargosById(id);
	}

	@Override
	public int update(Productos_x_encargos Producto_x_encargo) {

		return productos_x_encargosDao.update(Producto_x_encargo);
	}

}
