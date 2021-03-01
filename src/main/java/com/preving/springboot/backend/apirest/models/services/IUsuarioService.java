package com.preving.springboot.backend.apirest.models.services;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	
	public int save(Usuario usuario);
	
	public int delete(Long id);
	
	public Usuario findById(Long id);
	
	public int insert(Usuario usuario);
	
	public int update(Usuario usuario);
	
	public int updatePass(Usuario usuario);
}
