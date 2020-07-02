package edu.cientifica.papeleta.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.cientifica.papeleta.model.Usuario;

public class UserPrincipal implements UserDetails {
	
	private Usuario user;
	

	public UserPrincipal(Usuario usuario) {
		super();
		this.user = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
       
        // Extract list of roles (ROLE_name)
        this.user.getRoles().forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r.getRolname());
            authorities.add(authority);
        });

        return authorities;
		
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String toString() {
		return "UserPrincipal [user=" + user.toString() + "]";
	}

	
}
