package com.preving.springboot.backend.apirest.models.dao;

import java.util.List;

import com.preving.springboot.backend.apirest.models.entity.Usuario;

public interface IUsuarioDao {
	
	public List<Usuario> getUsuarios();
	
	public Usuario getUsuarioById(Long id_usuario);
	
	public int insert(Usuario usuario);
	
	public int delete(Long id);
	
	public int update(Usuario usuario);
	
	public int updatePass(Usuario usuario);
	
	public int upload(Usuario usuario, Long id_usuario);
	
}
