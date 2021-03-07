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

import com.preving.springboot.backend.apirest.models.entity.ComentariosDatos;

@Repository
public class SpringJdbcComentariosDatos  extends JdbcDaoSupport implements IComentariosDatosDao {

	@Autowired
	public void setDs(DataSource dataSource) {
	     setDataSource(dataSource);
	}
	
	@Autowired private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<ComentariosDatos> getComentariosDatos() {

		String sql = "SELECT * FROM comentarios;";
		
		return jdbcTemplate.query(sql, new ComentariosDatosRowMapper());
	}

	@Override
	public List<ComentariosDatos> getComentariosDatosById(Long id_producto) {

		String sql = "SELECT comentarios.id_usuario, usuarios.nombre, usuarios.nombre_usuario"
					+ " FROM comentarios INNER JOIN usuarios"
					+ " ON comentarios.id_usuario = usuarios.id_usuario"
					+ " WHERE id_producto =:id_producto;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_producto", id_producto);
		
		return getNamedJdbcTemplate().query(sql, params, new ComentariosDatosRowMapper());
	}
	
	private NamedParameterJdbcTemplate getNamedJdbcTemplate(){
		
	    if (this.namedParameterJdbcTemplate == null){
	    	
	        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
	    }
	    	return this.namedParameterJdbcTemplate;
		}
		
		private class ComentariosDatosRowMapper implements RowMapper{
			
			public Object mapRow(ResultSet rs, int i) throws SQLException{
				
				ComentariosDatos comentariosDatos = new ComentariosDatos();
				
				comentariosDatos.setComentario(rs.getString("comentario"));
				comentariosDatos.setNombre(rs.getString("nombre"));
				comentariosDatos.setNombre_usuario(rs.getString("nombre_usuario"));
				
				return comentariosDatos;
				
			}
			
		}

}
