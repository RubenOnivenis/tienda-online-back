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
		
		/*Usuario usuario = this.usuarioService.findById(id_usuario);
		Path rutaImagen = Paths.get(usuario.getImagen_usuario());
		try {
			
			byte [] arrayByte = Files.readAllBytes(rutaImagen);
			Usuario usuarioAux = new Usuario(usuario.getNombre_usuario(), arrayByte, usuario.getNombre(), usuario.getApellidos(), usuario.getCorreo(), usuario.getPass(), usuario.getCod_postal(), usuario.getDomicilio(), usuario.getLocalidad(), usuario.getProvincia(), usuario.getCod_postal_2(), usuario.getDomicilio_2(), usuario.getLocalidad_2(), usuario.getProvincia_2(), usuario.getTarjeta_credito(), usuario.getTelefono());
			
			return usuarioAux;
		}catch(IOException e){
			
		}*/
		
		//return usuario;
		return usuarioService.findById(id_usuario);
	}
	
	@PostMapping("/usuarios") @ResponseStatus(HttpStatus.CREATED)	//Crear usuario
	public int create(@RequestBody Usuario usuario, @RequestParam("imagen_usuario") MultipartFile foto) {
		
		return usuarioService.save(usuario);
	}
	
	/*@PatchMapping(value="/usuarios/{id_usuario}/foto", consumes = {"multipart/form-data"}) 
	@ResponseStatus(HttpStatus.CREATED)
	public int upload(@ModelAttribute Usuario usuarios, @ModelAttribute("foto") MultipartFile foto, @PathVariable Long id_usuario) {
		
		if(!foto.isEmpty()) {
			Path directorioRecursos = Paths.get("src//main//resources//static/uploads");
			String rootPath = directorioRecursos.toFile().getAbsolutePath();
			try
			{
				byte[] bytes = foto.getBytes();
				Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
				Files.write(rutaCompleta, bytes);
				usuarios.setImagen_usuario(rutaCompleta.toString());
				
				return this.usuarioService.upload(usuarios, id_usuario);
				
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		return 0;
	}*/
	
	@PutMapping("/usuarios/{id}") @ResponseStatus(HttpStatus.CREATED)	//Modificar usuario, menos la contraseña
	public int update(@RequestBody Usuario usuario, @PathVariable Long id/*, @RequestParam("imagen_usuario") MultipartFile foto*/) {
		
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
