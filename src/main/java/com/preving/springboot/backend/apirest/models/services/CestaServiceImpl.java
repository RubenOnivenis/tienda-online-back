package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preving.springboot.backend.apirest.models.dao.ICestaDao;
import com.preving.springboot.backend.apirest.models.entity.Cesta;

@Service
public class CestaServiceImpl implements ICestaService {

	@Autowired private ICestaDao cestaDao;
	
	@Override
	public List<Cesta> findAll() {

		return cestaDao.getCesta();
	}

	@Override
	public int save(Cesta cesta) {

		return cestaDao.insert(cesta);
	}

	@Override
	public int delete(Long id) {

		return cestaDao.delete(id);
	}

	@Override
	public Cesta findById(Long id_cesta) {

		return cestaDao.getCestaById(id_cesta);
	}

	@Override
	public int insert(Cesta cesta) {

		return cestaDao.insert(cesta);
	}

	@Override
	public int update(Cesta cesta) {

		return cestaDao.update(cesta);
	}

	@Override
	public int deleteAll(Long id_usuario) {

		return cestaDao.deleteAll(id_usuario);
	}

}
