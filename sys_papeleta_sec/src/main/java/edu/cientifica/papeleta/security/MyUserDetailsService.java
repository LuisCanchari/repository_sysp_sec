package edu.cientifica.papeleta.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.cientifica.papeleta.mappers.UsuarioMapper;
import edu.cientifica.papeleta.model.Usuario;

@Service
public class MyUserDetailsService implements UserDetailsService {
	protected final Log LOG = LogFactory.getLog(this.getClass());
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = usuarioMapper.findUsername(username);
		
		
		//LOG.info("usuario db " + user.toString());
				 
		if (user == null) {
			throw new UsernameNotFoundException("No se encontro en la BD");
		}
			
		// TODO Auto-generated method stub
		return new UserPrincipal(user);
	}

}
