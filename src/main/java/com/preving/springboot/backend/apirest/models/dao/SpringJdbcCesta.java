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

import com.preving.springboot.backend.apirest.models.entity.Cesta;

@Repository
public class SpringJdbcCesta extends JdbcDaoSupport implements ICestaDao{
	
	@Autowired
	public void setDs(DataSource dataSource) {
	     setDataSource(dataSource);
	}
	
	@Autowired private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Cesta> getCesta() {
		String sql="SELECT * FROM cesta;";
		return getJdbcTemplate().query(sql, new CestaRowMapper());
	}
	
	@Override
	public Cesta getCestaById(Long id_cesta) {
		
		String sql="SELECT * FROM cesta WHERE id_cesta=:id_cesta";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_cesta", id_cesta);
		
		return (Cesta) getNamedJdbcTemplate().queryForObject(sql, params, new CestaRowMapper());
	}
	@Override
	public int insert(Cesta cesta) {
		
		String sql="INSERT INTO cesta(id_usuario, id_producto) VALUES (:id_usuario, :id_producto);";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_usuario", cesta.getId_usuario());
		params.addValue("id_producto", cesta.getId_producto());		
		
		return getNamedJdbcTemplate().update(sql, params);
	}
	
	@Override
	public int delete(Long id_cesta) {
		
		String sql="DELETE FROM cesta WHERE id_cesta = :id_cesta;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_cesta", id_cesta);
		
		return getNamedJdbcTemplate().update(sql, params);
	}
	
	@Override
	public int deleteAll(Long id_usuario) {

		String sql="DELETE FROM cesta WHERE id_usuario = :id_usuario;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_usuario", id_usuario);
		
		return getNamedJdbcTemplate().update(sql, params);

	}
	
	@Override
	public int update(Cesta cesta) {
		
		String sql="UPDATE cesta SET id_usuario=:id_usuario, id_producto=:id_producto WHERE id_cesta=:id_cesta;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_cesta", cesta.getId_cesta());
		params.addValue("id_usuario", cesta.getId_usuario());
		params.addValue("id_producto", cesta.getId_producto());		
		
		return getNamedJdbcTemplate().update(sql, params);
	}
	
	private NamedParameterJdbcTemplate getNamedJdbcTemplate(){
		
	    if (this.namedParameterJdbcTemplate == null){
	    	
	        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
	    }
	    	return this.namedParameterJdbcTemplate;
		}
		
		private class CestaRowMapper implements RowMapper{
			
			public Object mapRow(ResultSet rs, int i) throws SQLException{
				
				Cesta cesta = new Cesta();
				
				cesta.setId_cesta(rs.getLong("id_cesta"));
				cesta.setId_usuario(rs.getLong("id_usuario"));
				cesta.setId_producto(rs.getLong("id_producto"));
				
				return cesta;
				
			}
			
		}

}
