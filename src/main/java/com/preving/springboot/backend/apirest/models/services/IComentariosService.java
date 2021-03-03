package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.Comentarios;

public interface IComentariosService {

	public List<Comentarios> findAll();
	
	public int save (Comentarios comentarios);
	
	public int delete (Long id_comentario);
	
	public Comentarios findById(Long id_comentario);
	
	public int insert(Comentarios comentarios);
	
	public int update(Comentarios comentarios);
	
}
