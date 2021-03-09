package com.preving.springboot.backend.apirest.models.services;

import java.util.*;

import com.preving.springboot.backend.apirest.models.entity.Encargos;

public interface IEncargosService {
	
	public List<Encargos> findAll();
	
	public int save(Encargos encargos);
	
	public int delete(Long id_encargo);
	
	public List<Encargos> findById(Long id_encargo);
	
	public Encargos ultimoId(Long id_usuario);
	
	public int update(Encargos encargos);

}
