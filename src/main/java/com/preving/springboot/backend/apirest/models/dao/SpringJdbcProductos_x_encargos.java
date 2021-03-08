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

import com.preving.springboot.backend.apirest.models.entity.Productos_x_encargos;

@Repository
public class SpringJdbcProductos_x_encargos extends JdbcDaoSupport implements IProductos_x_encargosDao {

	@Autowired
	public void setDs(DataSource dataSource) {
	     setDataSource(dataSource);
	}
	
	@Autowired private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Productos_x_encargos> getProductos_x_encargos() {

		String sql = "SELECT * FROM producto_x_encargo";
		
		return getJdbcTemplate().query(sql, new Productos_x_encargosRowMapper());
	}

	@Override
	public Productos_x_encargos getProducto_x_encargosById(Long id) {

		String sql = "SELECT * FROM producto_x_encargo WHERE id=:id;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		return (Productos_x_encargos) getNamedJdbcTemplate().queryForObject(sql, params, new Productos_x_encargosRowMapper());
	}

	@Override
	public int insert(Productos_x_encargos Producto_x_encargo) {

		String sql = "INSERT INTO producto_x_encargo(id_encargo, id_producto, precio_producto, cantidad) "
				+ "VALUES (:id_encargo, :id_producto, :precio_producto, :cantidad);";
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_encargo", Producto_x_encargo.getId_encargo());
		params.addValue("id_producto", Producto_x_encargo.getId_producto());
		params.addValue("precio_producto", Producto_x_encargo.getPrecio_producto());
		params.addValue("cantidad", Producto_x_encargo.getCantidad());
		
		return getNamedJdbcTemplate().update(sql, params);
	}

	@Override
	public int delete(Long id) {

		String sql = "DELETE FROM producto_x_encargo WHERE id=:id;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		return getNamedJdbcTemplate().update(sql, params);
	}

	@Override
	public int update(Productos_x_encargos Producto_x_encargo) {

		return 0;
	}
	
	private NamedParameterJdbcTemplate getNamedJdbcTemplate(){
		
	    if (this.namedParameterJdbcTemplate == null){
	    	
	        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
	    }
	    	return this.namedParameterJdbcTemplate;
		}
		
		private class Productos_x_encargosRowMapper implements RowMapper{
			
			public Object mapRow(ResultSet rs, int i) throws SQLException{
				
				Productos_x_encargos producto_x_encargo = new Productos_x_encargos();
				
				producto_x_encargo.setId(rs.getLong("id"));
				producto_x_encargo.setId_encargo(rs.getLong("id_encargo"));
				producto_x_encargo.setId_producto(rs.getLong("id_producto"));
				producto_x_encargo.setPrecio_producto(rs.getFloat("precio_producto"));
				producto_x_encargo.setCantidad(rs.getLong("cantidad"));
				
				
				return producto_x_encargo;
				
			}
			
		}

}
