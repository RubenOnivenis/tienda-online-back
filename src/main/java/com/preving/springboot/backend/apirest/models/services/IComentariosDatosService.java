package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.ComentariosDatos;

public interface IComentariosDatosService {

	public List<ComentariosDatos> findAll();
	
	public List<ComentariosDatos> findById(Long id_producto);
	
}
