package com.preving.springboot.backend.apirest.models.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.preving.springboot.backend.apirest.models.entity.Encargos;

@Repository
public class SpringJdbcEncargos extends JdbcDaoSupport implements IEncargosDao{

	@Autowired
	public void setDs(DataSource dataSource) {
	     setDataSource(dataSource);
	}
	
	@Autowired private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Encargos> getEncargos() {
		
		String sql = "SELECT * FROM encargos;";
			
		return getJdbcTemplate().query(sql, new EncargosRowMapper());
	}

	@Override
	public List<Encargos> getEncargoById(Long id_usuario) {
		
		String sql = "SELECT * FROM encargos WHERE id_usuario = :id_usuario;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_usuario", id_usuario);
		
		return getNamedJdbcTemplate().query(sql, params, new EncargosRowMapper());
	}

	@Override
	public Encargos ultimoEncargo(Long id_usuario) {
		
		String sql = "SELECT MAX(id_encargo) AS id FROM encargos WHERE id_usuario=:id_usuario;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_usuario", id_usuario);
		
		return (Encargos) getNamedJdbcTemplate().queryForObject(sql, params, new EncargosRowMapper());
	}
	
	@Override
	public int insert(Encargos encargos) {
		
		String sql = "INSERT INTO encargos(id_usuario, precio_encargo, fch_pedido, fch_encargo_enviado, fch_encargo_recibido) "
				+ "VALUES (:id_usuario, :precio_encargo, :fch_pedido, :fch_encargo_enviado, :fch_encargo_recibido);";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_usuario", encargos.getId_usuario());
		params.addValue("precio_encargo", encargos.getPrecio_encargo());
		params.addValue("fch_pedido", encargos.getFch_pedido());
		params.addValue("fch_encargo_enviado", encargos.getFch_encargo_enviado());
		params.addValue("fch_encargo_recibido", encargos.getFch_encargo_recibido());
		
		return getNamedJdbcTemplate().update(sql, params);
	}

	@Override
	public int delete(Long id_encargo) {
		
		String sql = "DELETE FROM encargos WHERE id_encargo=:id_encargo;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_encargo", id_encargo);
		
		return getNamedJdbcTemplate().update(sql, params);
	}
	
	@Override
	public int update(Encargos encargos) {
		
		//String sql = "UPDATE encargos SET id_usuario=:id_usuario precio_encargo=:precio_encargo;";
		//MIRAR BIEN ESTO
		return 0;
	}
	
	private NamedParameterJdbcTemplate getNamedJdbcTemplate(){
		
	    if (this.namedParameterJdbcTemplate == null){
	    	
	        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
	    }
	    	return this.namedParameterJdbcTemplate;
		}
		
		private class EncargosRowMapper implements RowMapper{
			
			public Object mapRow(ResultSet rs, int i) throws SQLException{
				
				Encargos encargos = new Encargos();
				
				encargos.setId_encargo(rs.getLong("id_encargo"));
				encargos.setId_usuario(rs.getLong("id_usuario"));
				encargos.setPrecio_encargo(rs.getFloat("precio_encargo"));
				encargos.setFch_pedido(rs.getDate("fch_pedido"));
				encargos.setFch_encargo_enviado(rs.getDate("fch_encargo_enviado"));
				encargos.setFch_encargo_recibido(rs.getDate("fch_encargo_recibido"));
				
				return encargos;
				
			}
			
		}

}
