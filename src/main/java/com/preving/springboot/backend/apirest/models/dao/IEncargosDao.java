package com.preving.springboot.backend.apirest.models.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.preving.springboot.backend.apirest.models.entity.Encargos;

public interface IEncargosDao{
	
	
	public List<Encargos> getEncargos();
	
	public List<Encargos> getEncargoById(Long id_usuario);
	
	public List<Encargos> ultimoEncargo(Long id_usuario);
	
	public Number insert(Encargos encargos);
	
	public int delete(Long id_encargo);
	
	public int update(Encargos encargos);
	
	public int modificarEstado(Encargos encargos);
}
