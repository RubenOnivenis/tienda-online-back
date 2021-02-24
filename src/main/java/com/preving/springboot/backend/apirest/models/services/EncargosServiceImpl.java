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
		// TODO Auto-generated method stub
		return (List<Encargos>) encargosDao.findAll();
	}

	@Override
	public Encargos save(Encargos encargos) {
		// TODO Auto-generated method stub
		return encargosDao.save(encargos);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		encargosDao.deleteById(id);
	}

	@Override
	public Encargos findById(Long id) {
		// TODO Auto-generated method stub
		return encargosDao.findById(id).orElse(null);
	}

}
