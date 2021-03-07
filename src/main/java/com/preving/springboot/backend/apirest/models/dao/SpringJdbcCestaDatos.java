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
import com.preving.springboot.backend.apirest.models.entity.CestaDatos;

@Repository
public class SpringJdbcCestaDatos extends JdbcDaoSupport implements ICestaDatosDao{

	@Autowired
	public void setDs(DataSource dataSource) {
	     setDataSource(dataSource);
	}
	
	@Autowired private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<CestaDatos> getCestaDatos() {
		String sql="SELECT * FROM cesta;";
		return jdbcTemplate.query(sql, new CestaDatosRowMapper());
	}

	@Override
	public List<CestaDatos> getCestaDatosById(Long id_usuario) {
		String sql="SELECT cesta.id_cesta, productos.id_producto, productos.nombre, productos.precio, productos.precio_oferta, productos.imagen "
				+ "FROM productos INNER JOIN cesta "
				+ "ON cesta.id_producto = productos.id_producto "
				+ "WHERE cesta.id_usuario = :id_usuario;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_usuario", id_usuario);
		
		return getNamedJdbcTemplate().query(sql, params, new CestaDatosRowMapper());
	}

	
	private NamedParameterJdbcTemplate getNamedJdbcTemplate(){
		
	    if (this.namedParameterJdbcTemplate == null){
	    	
	        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
	    }
	    	return this.namedParameterJdbcTemplate;
		}
		
		private class CestaDatosRowMapper implements RowMapper{
			
			public Object mapRow(ResultSet rs, int i) throws SQLException{
				
				CestaDatos cestaDatos = new CestaDatos();
				
				cestaDatos.setId(rs.getLong("id_cesta"));
				cestaDatos.setId_producto(rs.getLong("id_producto"));
				cestaDatos.setNombre(rs.getString("nombre"));
				cestaDatos.setImagen(rs.getString("imagen"));
				cestaDatos.setPrecio(rs.getFloat("precio"));
				cestaDatos.setPrecio_oferta(rs.getFloat("precio_oferta"));
				
				return cestaDatos;
				
			}
			
		}


}
