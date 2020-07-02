package edu.cientifica.papeleta.model;

public class Role {
	private int idRol;
	private String rolname;
	
	public Role() {
		super();
	}
	public Role(int idRol, String rolname) {
		super();
		this.idRol = idRol;
		this.rolname = rolname;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getRolname() {
		return rolname;
	}
	public void setRolname(String rolname) {
		this.rolname = rolname;
	}
	@Override
	public String toString() {
		return "Role [idRol=" + idRol + ", rolname=" + rolname + "]";
	}
	

}
