package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.Devolucion;

public interface IDevolucionService {

	public List<Devolucion> findAll();
	
	public int save(Devolucion devolucion);
	
	public int delete(Long id_devolucion);
	
	public Devolucion findById(Long id_producto);
	
	public int insert(Devolucion devolucion);
	
	public int update(Devolucion devolucion);
	
}
