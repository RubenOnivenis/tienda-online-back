package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preving.springboot.backend.apirest.models.dao.IComentariosDao;
import com.preving.springboot.backend.apirest.models.entity.Comentarios;

@Service
public class ComentariosServiceImpl implements IComentariosService{

	@Autowired private IComentariosDao comentariosDao;
	
	@Override
	public List<Comentarios> findAll() {
		return comentariosDao.getComentarios();
	}

	@Override
	public int save(Comentarios comentarios) {
		return comentariosDao.insertComentario(comentarios);
	}

	@Override
	public int delete(Long id_comentario) {
		return comentariosDao.deleteComentario(id_comentario);
	}

	@Override
	public Comentarios findById(Long id_comentario) {
		return (Comentarios) comentariosDao.getComentariosById(id_comentario);
	}

	@Override
	public int insert(Comentarios comentarios) {
		return comentariosDao.insertComentario(comentarios);
	}

	@Override
	public int update(Comentarios comentarios) {
		return comentariosDao.update(comentarios);
	}

}
