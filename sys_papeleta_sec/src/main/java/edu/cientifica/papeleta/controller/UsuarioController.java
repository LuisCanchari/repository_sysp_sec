package edu.cientifica.papeleta.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.cientifica.papeleta.dto.PasswordForm;
import edu.cientifica.papeleta.model.Area;
import edu.cientifica.papeleta.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	protected final Log LOG = LogFactory.getLog(this.getClass());
	
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
		@ModelAttribute PasswordForm passwordForm, BindingResult errors, Model model,
		RedirectAttributes attribute)
		{		
		int result =0;
			try {
				result=usuarioService.changePassword(passwordForm);
			} catch (Exception e) {
				LOG.info("Exception message" + e.getMessage());
			}
			if (result != 0) {
				attribute.addFlashAttribute("success", "Se modificicó el password");
			} else {
				attribute.addFlashAttribute("error", "No se modificó el password");
			}
			return "usuario_cambiar_password";
	}
}
