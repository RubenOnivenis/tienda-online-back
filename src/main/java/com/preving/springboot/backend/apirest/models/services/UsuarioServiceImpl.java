package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.preving.springboot.backend.apirest.models.dao.IUsuarioDao;
import com.preving.springboot.backend.apirest.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired private IUsuarioDao usuarioDao;

	@Override
	public List<Usuario> findAll() {
		
		return usuarioDao.getUsuarios();
	}

	@Override
	public int save(Usuario usuario) {
		
		return usuarioDao.insert(usuario);
	}

	@Override
	public int delete(Long id) {
		
		return usuarioDao.delete(id);
	}

	@Override
	public Usuario findById(Long id) {
		
		return usuarioDao.getUsuarioById(id);
	}
	
	public int insert(Usuario usuario) {
		
		return usuarioDao.insert(usuario);
	}

	@Override
	public int update(Usuario usuario) {
		
		return usuarioDao.update(usuario);
	}
	
	
}
