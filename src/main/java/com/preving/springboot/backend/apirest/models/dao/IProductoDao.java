package com.preving.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.preving.springboot.backend.apirest.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{}
