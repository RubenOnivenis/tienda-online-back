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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
