package com.preving.springboot.backend.apirest.models.dao;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.Cesta;

public interface ICestaDao {

	public List<Cesta> getCesta();
	
	public Cesta getCestaById(Long id_cesta);
	
	public int insert(Cesta cesta);
	
	public int delete(Long id_cesta);
	
	public int update(Cesta cesta);
	
	public int deleteAll(Long id_usuario);
	
}
