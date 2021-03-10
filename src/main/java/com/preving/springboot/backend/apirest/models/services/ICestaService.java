package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.Cesta;

public interface ICestaService {

	public List<Cesta> findAll();
	
	public int save(Cesta cesta);
	
	public int delete(Long id);
	
	public int deleteAll(Long id_usuario);
	
	public Cesta findById(Long id_cesta);
	
	public int insert (Cesta cesta);
	
	public int update (Cesta cesta);
	
}
