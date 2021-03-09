package com.preving.springboot.backend.apirest.models.dao;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.DetallesProducto;

public interface IDetallesProductoDao {

	public List<DetallesProducto> getDetallesProductoById(Long id_encargo);
	
}
