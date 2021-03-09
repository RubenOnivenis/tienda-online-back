package com.preving.springboot.backend.apirest.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.preving.springboot.backend.apirest.models.entity.Usuario;
import com.preving.springboot.backend.apirest.models.services.IUsuarioService;

@RestController @RequestMapping("/api") @CrossOrigin
public class UsuarioRestControllers {

	@Autowired private IUsuarioService usuarioService;
	
	@GetMapping("/usuarios")	//Todos los usuarios
	public List<Usuario> usuariosIndex(){
		
		return usuarioService.findAll();
	}
	
	@GetMapping("/usuario/{id_usuario}")	//Usuarios por id
	public Usuario show(@PathVariable Long id_usuario) {
		
		return usuarioService.findById(id_usuario);
	}
	
	@PostMapping("/usuarios") @ResponseStatus(HttpStatus.CREATED)	//Crear usuario
	public int create(@RequestBody Usuario usuario, @RequestParam("imagen_usuario") MultipartFile foto) {
		
		if(!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try
			{
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				
				usuario.setImagen_usuario(foto.getOriginalFilename());
			}catch(IOException e)
			{
				e.printStackTrace();
			}	
		}
		
		return usuarioService.save(usuario);
	}
	
	@PutMapping("/usuarios/{id}") @ResponseStatus(HttpStatus.CREATED)	//Modificar usuario, menos la contraseña
	public int update(@RequestBody Usuario usuario, @PathVariable Long id, @RequestParam("imagen_usuario") MultipartFile foto) {
		
		if(!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try
			{
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				
				usuario.setImagen_usuario(usuario.getImagen_usuario());
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		usuario.setId_usuario(id);
		
		return usuarioService.update(usuario);
	}
	
	@DeleteMapping("/usuarios/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
	public int delete(@PathVariable Long id) {
		
		return usuarioService.delete(id);
	}
	
	@PutMapping("/usuarios/pass/{id}") @ResponseStatus(HttpStatus.CREATED)	//Modificar contraseña del usuario
	public int updatePass(@RequestBody Usuario usuario, @PathVariable Long id) {
		
		usuario.setId_usuario(id);
		
		return usuarioService.updatePass(usuario);
	}
}
