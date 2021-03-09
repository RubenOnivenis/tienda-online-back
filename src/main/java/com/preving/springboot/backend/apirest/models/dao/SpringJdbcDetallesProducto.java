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

import com.preving.springboot.backend.apirest.models.entity.DetallesProducto;

@Repository
public class SpringJdbcDetallesProducto extends JdbcDaoSupport implements IDetallesProductoDao{

	@Autowired
	public void setDs(DataSource dataSource) {
	     setDataSource(dataSource);
	}
	
	@Autowired private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public List<DetallesProducto> getDetallesProductoById(Long id_encargo) {

		String sql = "SELECT producto_x_encargo.id,"
				+ " productos.id_producto,"
				+ " productos.nombre,"
				+ " productos.imagen,"
				+ " producto_x_encargo.precio_producto,"
				+ " producto_x_encargo.cantidad,"
				+ " encargos.id_encargo," 
				+ " encargos.precio_encargo,"
				+ " encargos.fch_pedido,"
				+ " encargos.fch_encargo_enviado,"
				+ " encargos.fch_encargo_recibido"
				+ " FROM producto_x_encargo INNER JOIN productos"
				+ " ON producto_x_encargo.id_producto = productos.id_producto"
				+ "	INNER JOIN encargos ON producto_x_encargo.id_encargo = encargos.id_encargo"
				+ "	WHERE producto_x_encargo.id_encargo = :id_encargo;";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id_encargo", id_encargo);
		
		return getNamedJdbcTemplate().query(sql, params, new DetallesProductoRowMapper());
	}
	
	private NamedParameterJdbcTemplate getNamedJdbcTemplate(){
		
	    if (this.namedParameterJdbcTemplate == null){
	    	
	        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
	    }
	    	return this.namedParameterJdbcTemplate;
		}
		
		private class DetallesProductoRowMapper implements RowMapper{
			
			public Object mapRow(ResultSet rs, int i) throws SQLException{
				
				DetallesProducto detallesProducto = new DetallesProducto();
				
				detallesProducto.setId(rs.getLong("id"));
				detallesProducto.setId_encargo(rs.getLong("id_encargo"));
				detallesProducto.setId_producto(rs.getLong("id_producto"));
				detallesProducto.setNombre(rs.getString("nombre"));
				detallesProducto.setImagen(rs.getString("imagen"));
				detallesProducto.setPrecio_producto(rs.getFloat("precio_producto"));
				detallesProducto.setCantidad(rs.getInt("cantidad"));
				detallesProducto.setPrecio_encargo(rs.getFloat("precio_encargo"));
				detallesProducto.setFch_pedido(rs.getDate("fch_pedido"));
				detallesProducto.setFch_encargo_enviado(rs.getDate("fch_encargo_enviado"));
				detallesProducto.setFch_encargo_recibido(rs.getDate("fch_encargo_recibido"));
				
				return detallesProducto;
				
			}
			
		}

}
