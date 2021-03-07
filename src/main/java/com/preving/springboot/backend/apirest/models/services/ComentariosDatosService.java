package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preving.springboot.backend.apirest.models.dao.IComentariosDatosDao;
import com.preving.springboot.backend.apirest.models.entity.ComentariosDatos;

@Service
public class ComentariosDatosService implements IComentariosDatosService{

	@Autowired IComentariosDatosDao comentariosDatosDao;

	@Override
	public List<ComentariosDatos> findAll() {
		
		return comentariosDatosDao.getComentariosDatos();
	}

	@Override
	public List<ComentariosDatos> findById(Long id_comentario) {

		return comentariosDatosDao.getComentariosDatosById(id_comentario);
	}
	
	
	
}
