package com.preving.springboot.backend.apirest.models.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.preving.springboot.backend.apirest.models.dao.IProductoDao;
import com.preving.springboot.backend.apirest.models.entity.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired private IProductoDao productoDao;

	@Override
	public List<Producto> findAll() {
		
		return productoDao.getProducto();
	}

	@Override
	public int save(Producto producto) {
		
		return productoDao.insert(producto);
	}

	@Override
	public int delete(Long id) {
		
		return productoDao.delete(id);
	}

	@Override
	public Producto findById(Long id) {
		
		return productoDao.getProductoById(id);
	}

	@Override
	public List<Producto> findByNombre(String nombre) {
		
		return productoDao.getProductoByNombre(nombre);
	}

	@Override
	public int insert(Producto producto) {
		
		return productoDao.insert(producto);
	}

	@Override
	public int update(Producto producto) {
		
		return productoDao.update(producto);
	}
	
}
