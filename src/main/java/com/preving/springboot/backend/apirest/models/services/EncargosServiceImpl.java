package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preving.springboot.backend.apirest.models.dao.IEncargosDao;
import com.preving.springboot.backend.apirest.models.entity.Encargos;

@Service
public class EncargosServiceImpl implements IEncargosService  {

	@Autowired private IEncargosDao encargosDao;

	@Override
	public List<Encargos> findAll() {

		return encargosDao.getEncargos();
	}

	@Override
	public Number save(Encargos encargos) {

		return encargosDao.insert(encargos);
	}

	@Override
	public int delete(Long id_encargo) {

		return encargosDao.delete(id_encargo);
	}

	@Override
	public List<Encargos> findById(Long id_usuario) {

		return encargosDao.getEncargoById(id_usuario);
	}

	@Override
	public List<Encargos> findByIdEncargo(Long id_encargo) {

		return encargosDao.getEncargoByIdEncargo(id_encargo);
	}
	
	@Override
	public int update(Encargos encargos) {

		return encargosDao.update(encargos);
	}

	@Override
	public List<Encargos> ultimoId(Long id_usuario) {

		return encargosDao.ultimoEncargo(id_usuario);
	}

	@Override
	public int modificarEstado(Encargos encargos, Long id_encargo) {

		return encargosDao.modificarEstado(encargos, id_encargo);
	}
	

}
