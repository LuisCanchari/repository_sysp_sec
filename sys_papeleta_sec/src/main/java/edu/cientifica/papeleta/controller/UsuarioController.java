package edu.cientifica.papeleta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.cientifica.papeleta.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	public String formularioUsuario() {
		return "";
	}
	
	public String crearUsuario() {
		return "";
	}
	
	public String editarUsuario() {
		return "";
	}
	
	public String actualizarUsuario() {
		return "";
	}
	
	@GetMapping("/lista")
	public String listarUsuario(Model model) {
		model.addAttribute("usuarios", usuarioService.listarUsuarios());
		return "usuario_lista";
	}
	
	public String cambiarContrasena() {
		return "";
	}
	
	
	

}
