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
	public int save(Encargos encargos) {

		return encargosDao.insert(encargos);
	}

	@Override
	public int delete(Long id_encargo) {

		return encargosDao.delete(id_encargo);
	}

	@Override
	public Encargos findById(Long id_encargo) {

		return encargosDao.getEncargoById(id_encargo);
	}

	@Override
	public int update(Encargos encargos) {

		return encargosDao.update(encargos);
	}
	
	

}
