package edu.cientifica.papeleta.model;

import java.util.List;

public class Usuario extends Empleado{
	private int idUsuario;
	private String username;
	private String password;
	private List<Role> roles; 
	public Usuario() {
		super();
	}
	
	public Usuario(Empleado empleado) {
		super(empleado);
	}

	
	public Usuario(Empleado empleado, String username, String password) {
		super(empleado);
		this.username = username;
		this.password = password;
	}


	public Usuario(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.roles = null;
	}


	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Usuario ["+super.toString() + "username=" + username + ", password=" + password +"]";
	}
	
}
