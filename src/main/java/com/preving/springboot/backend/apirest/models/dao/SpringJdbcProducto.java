package com.preving.springboot.backend.apirest.models.dao;

import java.sql.*;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.preving.springboot.backend.apirest.models.entity.Producto;

@Repository
public class SpringJdbcProducto extends JdbcDaoSupport implements IProductoDao{

	@Autowired
	public void setDs(DataSource dataSource) {
	     setDataSource(dataSource);
	}
	
	@Autowired private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<Producto> getProducto() {
		
		String sql = "SELECT * FROM productos;";
		return getJdbcTemplate().query(sql, new ProductoRowMapper());
	}
	
	@Override
	public Producto getProductoById(Long id_producto) {
		
		String sql = "SELECT * FROM productos WHERE id_producto = :id_producto;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_producto", id_producto);
		
		return (Producto) getNamedJdbcTemplate().queryForObject(sql, params, new ProductoRowMapper());
	}
	
	@Override
	public List<Producto> getProductoByNombre(String nombre) {
		
		String sql = "SELECT * FROM productos WHERE nombre LIKE CONCAT('%',:nombre,'%');";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("nombre", nombre);
		
		return getNamedJdbcTemplate().query(sql, params, new ProductoRowMapper());
	}
	
	@Override
	public int insert(Producto producto) {
		
		String sql = "INSERT INTO productos(nombre, precio, precio_oferta imagen, descr, diasConsumicion, ingredientes, imagen_oferta) VALUES (:nombre, :precio, :precio_oferta, :imagen, :descr, :diasConsumicion, :ingredientes, :imagen_oferta);";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("nombre", producto.getNombre());
		params.addValue("precio_oferta", producto.getPrecio_oferta());
		params.addValue("precio", producto.getPrecio());
		params.addValue("imagen", producto.getImagen());
		params.addValue("descr", producto.getDescr());
		params.addValue("diasConsumicion", producto.getDiasConsumicion());
		params.addValue("ingredientes", producto.getIngredientes());
		params.addValue("imagen_oferta", producto.getImagen_oferta());
		
		return getNamedJdbcTemplate().update(sql, params);
	}
	
	@Override
	public int delete(Long id_producto) {
		String sql = "DELETE FROM productos WHERE id_producto = :id_producto;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_producto", id_producto);
		
		return getNamedJdbcTemplate().update(sql, params);
	}
	@Override
	public int update(Producto producto) {
		String sql = "UPDATE productos SET nombre=:nombre, precio=:precio, precio_oferta=:precio_oferta imagen=:imagen, descr=:descr, diasConsumicion=:diasConsumicion, ingredientes=:ingredientes, imagen_oferta=:imagen_oferta WHERE id_producto=:id_producto;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_producto", producto.getId());
		params.addValue("nombre", producto.getNombre());
		params.addValue("precio", producto.getPrecio());
		params.addValue("precio_oferta", producto.getPrecio_oferta());
		params.addValue("imagen", producto.getImagen());
		params.addValue("descr", producto.getDescr());
		params.addValue("diasConsumicion", producto.getDiasConsumicion());
		params.addValue("ingrediente", producto.getIngredientes());
		params.addValue("imagen_oferta", producto.getImagen_oferta());
		
		return getNamedJdbcTemplate().update(sql, params);
	}
	
	private NamedParameterJdbcTemplate getNamedJdbcTemplate(){
		
	    if (this.namedParameterJdbcTemplate == null){
	    	
	        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
	    }
	    	return this.namedParameterJdbcTemplate;
		}
		
		private class ProductoRowMapper implements RowMapper{
			
			public Object mapRow(ResultSet rs, int i) throws SQLException{
				
				Producto producto = new Producto();
				
				producto.setId(rs.getLong("id_producto"));
				producto.setNombre(rs.getString("nombre"));
				producto.setPrecio(rs.getFloat("precio"));
				producto.setPrecio_oferta(rs.getFloat("precio_oferta"));
				producto.setImagen(rs.getString("imagen"));
				producto.setDescr(rs.getString("descr"));
				producto.setDiasConsumicion(rs.getInt("diasConsumicion"));
				producto.setIngredientes(rs.getString("ingredientes"));
				producto.setImagen_oferta(rs.getString("imagen_oferta"));
				
				return producto;
				
			}
			
		}
}
