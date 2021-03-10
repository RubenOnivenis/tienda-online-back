package com.preving.springboot.backend.apirest.models.dao;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.ComentariosDatos;

public interface IComentariosDatosDao {

	public List<ComentariosDatos> getComentariosDatos();
	
	public List<ComentariosDatos> getComentariosDatosById(Long id_producto);
	
}
