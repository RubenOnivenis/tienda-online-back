package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preving.springboot.backend.apirest.models.dao.ICestaDatosDao;
import com.preving.springboot.backend.apirest.models.entity.CestaDatos;

@Service
public class CestaDatosService implements ICestaDatosService {

	@Autowired ICestaDatosDao cestaDatosDao;
	
	@Override
	public List<CestaDatos> findAll() {

		return cestaDatosDao.getCestaDatos();
	}

	@Override
	public List<CestaDatos> findById(Long id_cesta) {

		return cestaDatosDao.getCestaDatosById(id_cesta);
	}

}
