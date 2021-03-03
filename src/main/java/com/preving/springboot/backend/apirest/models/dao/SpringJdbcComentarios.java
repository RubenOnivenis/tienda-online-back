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

import com.preving.springboot.backend.apirest.models.entity.Comentarios;

@Repository
public class SpringJdbcComentarios extends JdbcDaoSupport implements IComentariosDao{

	@Autowired
	public void setDs(DataSource dataSource) {
	     setDataSource(dataSource);
	}
	
	@Autowired private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Comentarios> getComentarios() {
		
		String sql="SELECT * FROM comentarios";
		return getNamedJdbcTemplate().query(sql, new ComentarioRowMapper());
	}

	@Override
	public List<Comentarios> getComentariosById(Long id_producto) {
		
		String sql = "SELECT * FROM comentarios INNER JOIN usuarios"
					+ " ON comentarios.id_usuario = usuarios.id_usuario"
					+ " WHERE id_producto=:id_producto;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_producto", id_producto);
		
		return getNamedJdbcTemplate().query(sql, params, new ComentarioRowMapper());
	}
	
	@Override
	public int insertComentario(Comentarios comentarios) {
		
		String sql="INSERT INTO comentarios(comentario, id_producto, id_usuario) VALUES (:comentario, :id_producto, :id_usuario);";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("comentario", comentarios.getComentario());
		params.addValue("id_producto", comentarios.getId_producto());
		params.addValue("id_usuario", comentarios.getId_usuario());
		
		return getNamedJdbcTemplate().update(sql, params);
	}

	@Override
	public int deleteComentario(Long id_comentario) {
		
		String sql = "DELETE FROM comentarios WHERE id_comentario=:id_comentario;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_usuario", id_comentario);
		
		return getNamedJdbcTemplate().update(sql, params);
	}

	@Override
	public int update(Comentarios comentarios) {
		
		String sql = "UPDATE comentarios SET comentario=:comentario, id_usuario=:id_usuario, id_producto=:id_producto WHERE id_comentario=:id_comentario;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_comentario", comentarios.getId_comentario());
		params.addValue("comentario", comentarios.getComentario());
		params.addValue("id_producto", comentarios.getId_producto());
		params.addValue("id_usuario", comentarios.getId_usuario());
		
		return getNamedJdbcTemplate().update(sql, params);
	}

	private NamedParameterJdbcTemplate getNamedJdbcTemplate(){
		
	    if (this.namedParameterJdbcTemplate == null){
	    	
	        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
	    }
	    	return this.namedParameterJdbcTemplate;
		}
		
		private class ComentarioRowMapper implements RowMapper{
			
			public Object mapRow(ResultSet rs, int i) throws SQLException{
				
				Comentarios comentarios = new Comentarios();
				
				comentarios.setId_comentario(rs.getLong("id_comentario"));
				comentarios.setComentario(rs.getString("comentario"));
				comentarios.setId_producto(rs.getLong("id_producto"));
				comentarios.setId_usuario(rs.getLong("id_usuario"));
				
				return comentarios;
				
			}
			
		}

		
	
}
