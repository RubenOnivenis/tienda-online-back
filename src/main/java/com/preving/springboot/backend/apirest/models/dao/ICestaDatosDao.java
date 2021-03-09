package com.preving.springboot.backend.apirest.models.dao;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.CestaDatos;

public interface ICestaDatosDao {

	public List<CestaDatos> getCestaDatos(); 
	
	public List<CestaDatos> getCestaDatosById(Long id_usuario);
	
}
