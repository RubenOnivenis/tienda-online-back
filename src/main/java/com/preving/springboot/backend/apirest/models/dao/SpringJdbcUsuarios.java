package com.preving.springboot.backend.apirest.models.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.preving.springboot.backend.apirest.models.entity.Usuario;

@Repository
public class SpringJdbcUsuarios extends JdbcDaoSupport implements IUsuarioDao{

	@Autowired
	public void setDs(DataSource dataSource) {
	     setDataSource(dataSource);
	}
	
	@Autowired private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Usuario> getUsuarios() {
		
		String sql = "SELECT * FROM usuarios;";
		return getJdbcTemplate().query(sql, new UsuarioRowMapper());
	}
	
	@Override
	public Usuario getUsuarioById(Long id_usuario) {
		
		String sql = "SELECT * FROM usuarios WHERE id_usuario=:id_usuario;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_usuario", id_usuario);	//Cuando se encuentren :id lo cambiara por la variable id que nos llega del método
		
		return (Usuario) getNamedJdbcTemplate().queryForObject(sql, params, new UsuarioRowMapper());
	}
	
	@Override
	public int insert(Usuario usuario) {
		
		String sql = "INSERT INTO usuarios(nombre_usuario, nombre, apellidos, correo, pass, cod_postal, domicilio, localidad, provincia, "
				+ "cod_postal_2, domicilio_2, localidad_2, provincia_2, tarjeta_credito, telefono) "
				+ "VALUES (:nombre_usuario, :nombre, :apellidos, :correo, :pass, :cod_postal, :domicilio, :localidad,"
				+ ":provincia, :cod_postal_2, :domicilio_2, :localidad_2, :provincia_2, :tarjeta_credito, :telefono);";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("nombre_usuario", usuario.getNombre_usuario());
		params.addValue("nombre", usuario.getNombre());
		params.addValue("apellidos", usuario.getApellidos());
		params.addValue("correo", usuario.getCorreo());
		params.addValue("pass", usuario.getPass());
		params.addValue("cod_postal", usuario.getCod_postal());
		params.addValue("domicilio", usuario.getDomicilio());
		params.addValue("localidad", usuario.getLocalidad());
		params.addValue("provincia", usuario.getProvincia());
		params.addValue("cod_postal_2", usuario.getCod_postal_2());
		params.addValue("domicilio_2", usuario.getDomicilio_2());
		params.addValue("localidad_2", usuario.getLocalidad_2());
		params.addValue("provincia_2", usuario.getProvincia_2());
		params.addValue("tarjeta_credito", usuario.getTarjeta_credito());
		params.addValue("telefono", usuario.getTelefono());
		
		
		return getNamedJdbcTemplate().update(sql, params);
	}
	
	@Override
	public int delete(Long id_usuario) {
		
		String sql = "DELETE FORM usuarios WHERE id_usuario = :id_usuario;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_usuario", id_usuario);
		
		return getNamedJdbcTemplate().update(sql, params);
	}
	
	@Override
	public int update(Usuario usuario) {
		
		String sql = "UPDATE usuarios SET "
				+ "nombre_usuario=:nombre_usuario, nombre=:nombre, apellidos=:apellidos, correo=:correo, pass=:pass, cod_postal=:cod_postal, "
				+ "domicilio=:domicilio, localidad=:localidad, provincia=:provincia, cod_postal_2=:cod_postal_2, domicilio_2=:domicilio_2, "
				+ "localidad_2=:localidad_2, provincia_2=:provincia_2, tarjeta_credito=:tarjeta_credito, telefono=:telefono "
				+ "WHERE id_usuario=:id_usuario;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_usuario", usuario.getId_usuario());
		params.addValue("nombre_usuario", usuario.getNombre_usuario());
		params.addValue("nombre", usuario.getNombre());
		params.addValue("apellidos", usuario.getApellidos());
		params.addValue("correo", usuario.getCorreo());
		params.addValue("pass", usuario.getPass());
		params.addValue("cod_postal", usuario.getCod_postal());
		params.addValue("domicilio", usuario.getDomicilio());
		params.addValue("localidad", usuario.getLocalidad());
		params.addValue("provincia", usuario.getProvincia());
		params.addValue("cod_postal_2", usuario.getCod_postal_2());
		params.addValue("domicilio_2", usuario.getDomicilio_2());
		params.addValue("localidad_2", usuario.getLocalidad_2());
		params.addValue("provincia_2", usuario.getProvincia_2());
		params.addValue("tarjeta_credito", usuario.getTarjeta_credito());
		params.addValue("telefono", usuario.getTelefono());
		
		return getNamedJdbcTemplate().update(sql, params);
	}
	
	private NamedParameterJdbcTemplate getNamedJdbcTemplate(){
		
	    if (this.namedParameterJdbcTemplate == null){
	    	
	        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
	    }
	    	return this.namedParameterJdbcTemplate;
		}
		
		private class UsuarioRowMapper implements RowMapper{
			
			public Object mapRow(ResultSet rs, int i) throws SQLException{
				
				Usuario usuario = new Usuario();
				
				usuario.setId_usuario(rs.getLong("id_usuario"));
				usuario.setNombre_usuario(rs.getString("nombre_usuario"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellidos(rs.getString("apellidos"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setPass(rs.getString("pass"));
				usuario.setCod_postal(rs.getString("cod_postal"));
				usuario.setDomicilio(rs.getString("domicilio"));
				usuario.setLocalidad(rs.getString("localidad"));
				usuario.setProvincia(rs.getString("provincia"));
				usuario.setCod_postal_2(rs.getString("cod_postal_2"));
				usuario.setDomicilio_2(rs.getString("domicilio_2"));
				usuario.setLocalidad_2(rs.getString("localidad_2"));
				usuario.setProvincia_2(rs.getString("provincia_2"));
				usuario.setTarjeta_credito(rs.getString("tarjeta_credito"));
				usuario.setTelefono(rs.getString("telefono"));
				
				return usuario;
				
			}
			
		}
	
}
