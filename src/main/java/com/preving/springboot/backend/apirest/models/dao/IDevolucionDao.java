package com.preving.springboot.backend.apirest.models.dao;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.Devolucion;

public interface IDevolucionDao {
	
	public List<Devolucion> getDevolucion();
	
	public Devolucion getDevolucionById(Long id_devolucion);
	
	public int insert(Devolucion devolucion);
	
	public int delete(Long id_devolucion);
	
	public int update(Devolucion devolucion);
	
}
