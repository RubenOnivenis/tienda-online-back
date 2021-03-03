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

import com.preving.springboot.backend.apirest.models.entity.Devolucion;

@Repository
public class SpringJdbcDevolucion extends JdbcDaoSupport implements IDevolucionDao {

	@Autowired
	public void setDs(DataSource dataSource) {
	     setDataSource(dataSource);
	}
	
	@Autowired private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Devolucion> getDevolucion() {
		
		String sql = "SELECT * FROM devolucion;";
		
		return getJdbcTemplate().query(sql, new DevolucionRowMapper());
	}

	@Override
	public Devolucion getDevolucionById(Long id_devolucion) {
		
		String sql = "SELECT * FROM devolucion WHERE id_devolucion = :id_devolucion;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_devolucion", id_devolucion);
		
		return (Devolucion) getNamedJdbcTemplate().queryForObject(sql, params, new DevolucionRowMapper());
	}

	@Override
	public int insert(Devolucion devolucion) {
		
		String sql = "INSERT INTO devolucion(id_encargo, fch_encargo_cancelado_devuelto, encargo_cncl_devuelto_descripcion, encargo_cncl_devuelto)"
				+ " VALUES (:id_encargo, :fch_encargo_cancelado_devuelto, :encargo_cncl_devuelto_descripcion, :encargo_cncl_devuelto);";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_encargo", devolucion.getId_encargo());
		params.addValue("fch_encargo_cancelado_devuelto", devolucion.getFch_encargo_cancelado_devuelto());
		params.addValue("encargo_cncl_devuelto_descripcion", devolucion.getEncargo_cncl_devuelto_descripcion());
		params.addValue("encargo_cncl_devuelto", devolucion.getEncargo_cncl_devuelto());
		
		return getNamedJdbcTemplate().update(sql, params);
	}

	@Override
	public int delete(Long id_devolucion) {
		
		String sql = "DELETE FROM devolucion WHERE id_devolucion=:id_devolucion;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_devolucion", id_devolucion);
		
		return getNamedJdbcTemplate().update(sql, params);
	}

	@Override
	public int update(Devolucion devolucion) {
		
		String sql = "UPDATE devolucion SET id_encargo=:id_encargo, "
				+ "fch_encargo_cancelado_devuelto=:fch_encargo_cancelado_devuelto, "
				+ "encargo_cncl_devuelto_descripcion=:encargo_cncl_devuelto_descripcion, "
				+ "encargo_cncl_devuelto=:encargo_cncl_devuelto "
				+ "WHERE id_devolucion=:id_devolucion;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_devolucion", devolucion.getId_devolucion());
		params.addValue("id_encargo", devolucion.getId_encargo());
		params.addValue("encargo_cncl_devuelto_descripcion", devolucion.getEncargo_cncl_devuelto_descripcion());
		params.addValue("fch_encargo_cancelado_devuelto", devolucion.getFch_encargo_cancelado_devuelto());
		params.addValue("encargo_cncl_devuelto", devolucion.getEncargo_cncl_devuelto());
		
		return getNamedJdbcTemplate().update(sql, params);
	}

	private NamedParameterJdbcTemplate getNamedJdbcTemplate(){
		
	    if (this.namedParameterJdbcTemplate == null){
	    	
	        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
	    }
	    	return this.namedParameterJdbcTemplate;
		}
		
		private class DevolucionRowMapper implements RowMapper{
			
			public Object mapRow(ResultSet rs, int i) throws SQLException{
				
				Devolucion devolucion = new Devolucion();
				
				devolucion.setId_devolucion(rs.getLong("id_devolucion"));
				devolucion.setId_encargo(rs.getLong("id_encargo"));
				devolucion.setFch_encargo_cancelado_devuelto(rs.getDate("fch_encargo_cancelado_devuelto"));
				devolucion.setEncargo_cncl_devuelto_descripcion(rs.getString("encargo_cncl_devuelto_descripcion"));
				devolucion.setEncargo_cncl_devuelto(rs.getBoolean("encargo_cncl_devuelto"));
				
				
				return devolucion;
				
			}
			
		}
}
