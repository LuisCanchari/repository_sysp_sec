package edu.cientifica.papeleta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.cientifica.papeleta.dto.PasswordForm;
import edu.cientifica.papeleta.model.Area;
import edu.cientifica.papeleta.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
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
	
	@GetMapping("/cambiar_password")
	public String cambiarContrasena(Model model) {
		model.addAttribute("passwordForm", new PasswordForm());
		return "usuario_cambiar_password";
	}
	
	@PostMapping("/actualizarPassword")
	public String actualizarPassword(
		@ModelAttribute PasswordForm passwordForm, BindingResult errors, Model model)
		{		
			try {
				usuarioService.changePassword(passwordForm);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "usuario_cambiar_password";
	}
}
