package com.preving.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.preving.springboot.backend.apirest.models.entity.Encargos;

public interface IEncargosDao extends CrudRepository<Encargos, Long>{}
