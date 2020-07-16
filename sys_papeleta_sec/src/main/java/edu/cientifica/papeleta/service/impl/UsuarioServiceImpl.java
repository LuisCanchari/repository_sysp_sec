package edu.cientifica.papeleta.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



import edu.cientifica.papeleta.dto.PasswordForm;
import edu.cientifica.papeleta.mappers.UsuarioMapper;
import edu.cientifica.papeleta.model.Usuario;
import edu.cientifica.papeleta.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	protected final Log LOG = LogFactory.getLog(this.getClass());
	
	private List<Usuario> listaUsuarios;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	
	public UsuarioServiceImpl() {
		super();
		listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios.add(new Usuario("Juan", "clave"));
		listaUsuarios.add(new Usuario("Pedro", "clave"));
		listaUsuarios.add(new Usuario("Anita", "clave"));
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioMapper.listarUsuarios();

	}


	
	@Override
	public int actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		int result = 0;
		result  = usuarioMapper.actualizarUsuario(usuario);
		return result ;
	}

	@Override
	public int changePassword(PasswordForm form) throws Exception {
		int result=0;
		Usuario user = getLoggedUser();
				
		if (!(bCryptPasswordEncoder.matches(form.getCurrentPassword(),  user.getPassword()))) {
			throw new Exception ("Current Password invalido.");
			
		}
	
		
		if( !form.getNewPassword().equals(form.getConfirmPassword())) {
			throw new Exception ("Nuevo Password y Confirm Password no coinciden.");
		}
		
		String encodePassword = bCryptPasswordEncoder.encode(form.getNewPassword());
		user.setPassword(encodePassword);
		
		result = actualizarUsuario(user);
		return result;
		
		
	}
	
	/**Metodos Privados **/
	
	private boolean checkUsernameAvailable(Usuario user) throws Exception {
		Optional<Usuario> userFound = Optional.ofNullable(usuarioMapper.findUsername(user.getUsername()));
		if (userFound.isPresent()) {
			throw new Exception ("Username no disponible");
		}
		return true;
	}
	
	private boolean checkPasswordValid(Usuario user) throws Exception {
		/*
		 * if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty())
		 * { throw new Exception("Confirm Password es obligatorio"); }
		 * 
		 * if ( !user.getPassword().equals(user.getConfirmPassword())) { throw new
		 * Exception("Password y Confirm Password no son iguales"); }
		 */
		return true;
	}
	
	
	
	private boolean isLoggedUserADMIN() {
		//Obtener el usuario logeado
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UserDetails loggedUser = null;
		Object roles = null;

		//Verificar que ese objeto traido de sesion es el usuario
		if (principal instanceof UserDetails) {
			loggedUser = (UserDetails) principal;

			roles = loggedUser.getAuthorities().stream()
					.filter(x -> "ROLE_ADMIN".equals(x.getAuthority())).findFirst()
					.orElse(null); 
		}
		return roles != null ? true : false;
	}
	
	private Usuario getLoggedUser() throws Exception {
		//Obtener el usuario logeado
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		UserDetails loggedUser = null;

		//Verificar que ese objeto traido de sesion es el usuario
		if (principal instanceof UserDetails) {
			loggedUser = (UserDetails) principal;
		}
		
		Usuario myUser = usuarioMapper.findUsername(loggedUser.getUsername());
		
		return myUser;
	}
	
	
	/***Operacione con listas*/
	
	@Override
	public Usuario buscarUsuario(String username) {

		for (Usuario usuario : listaUsuarios) {
			if (usuario.getUsername().equals(username)) {
				return usuario;
			}
		}
		return null;
	}

	@Override
	public boolean validarUsuario(Usuario usuario) {
		for (Usuario user : listaUsuarios) {
			if (usuario.getUsername().equals(user.getUsername())) {
				if (usuario.getPassword().equals(user.getPassword())) {
					return true;
				} 
			}
		}		
		return false;
	}
	
	
}
