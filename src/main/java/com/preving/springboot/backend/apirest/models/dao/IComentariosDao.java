package com.preving.springboot.backend.apirest.models.dao;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.Comentarios;

public interface IComentariosDao {
	
	public List<Comentarios> getComentarios();
	
	public List<Comentarios> getComentariosById(Long id_comentarios);
	
	public int insertComentario(Comentarios comentarios);
	
	public int deleteComentario(Long id_comentarios);
	
	public int update(Comentarios comentarios);
	
}
