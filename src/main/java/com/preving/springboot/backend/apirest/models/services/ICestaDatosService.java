package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.CestaDatos;

public interface ICestaDatosService {

	public List<CestaDatos> findAll();
	
	public List<CestaDatos> findById(Long id_cesta);
	
}
