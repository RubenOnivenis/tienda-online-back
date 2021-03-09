package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preving.springboot.backend.apirest.models.dao.IDetallesProductoDao;
import com.preving.springboot.backend.apirest.models.entity.DetallesProducto;

@Service
public class DetallesProductoServiceImpl implements IDetallesProductoService {

	@Autowired IDetallesProductoDao detallesProductoDao;
	
	@Override
	public List<DetallesProducto> findById(Long id_encargo) {

		return detallesProductoDao.getDetallesProductoById(id_encargo);
	}

}
