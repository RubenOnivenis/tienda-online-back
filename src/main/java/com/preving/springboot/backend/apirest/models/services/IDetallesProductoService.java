package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.DetallesProducto;

public interface IDetallesProductoService {

	public List<DetallesProducto> findById(Long id_encargo);
	
}
