package com.preving.springboot.backend.apirest.models.services;

import java.util.*;

import com.preving.springboot.backend.apirest.models.entity.Encargos;

public interface IEncargosService {
	
	public List<Encargos> findAll();
	
	public Encargos save(Encargos encargos);
	
	public void delete(Long id);
	
	public Encargos findById(Long id);

}
