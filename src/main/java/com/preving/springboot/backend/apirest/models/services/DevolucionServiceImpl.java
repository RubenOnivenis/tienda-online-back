package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preving.springboot.backend.apirest.models.dao.IDevolucionDao;
import com.preving.springboot.backend.apirest.models.entity.Devolucion;

@Service
public class DevolucionServiceImpl implements IDevolucionService{

	@Autowired private IDevolucionDao devolucionDao;
	
	@Override
	public List<Devolucion> findAll() {
		
		return devolucionDao.getDevolucion();
	}

	@Override
	public int save(Devolucion devolucion) {
		
		return devolucionDao.insert(devolucion);
	}

	@Override
	public int delete(Long id_devolucion) {
		
		return devolucionDao.delete(id_devolucion);
	}

	@Override
	public Devolucion findById(Long id_producto) {
		
		return devolucionDao.getDevolucionById(id_producto);
	}

	@Override
	public int insert(Devolucion devolucion) {
		
		return devolucionDao.insert(devolucion);
	}

	@Override
	public int update(Devolucion devolucion) {
		
		return devolucionDao.update(devolucion);
	}

}
