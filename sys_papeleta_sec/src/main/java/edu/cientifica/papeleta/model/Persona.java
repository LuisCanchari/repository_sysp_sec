package edu.cientifica.papeleta.model;

import java.sql.Date;

public class Persona{
	private int idPersona;
	private int numeroDocumento;
	private String nombres;
	private String primerApellido;
	private String segundoApellido;
	private Date fechaNacimiento;
	private String genero;
	
		
	public Persona() {
		super(); 
	}
		
	
	public Persona(String nombres) {
		super();
		this.nombres = nombres;
	}
	
	public Persona(Persona persona) {
		super();
		this.idPersona = persona.idPersona;
		this.numeroDocumento = persona.numeroDocumento;
		this.nombres = persona.nombres;
		this.primerApellido = persona.primerApellido;
		this.segundoApellido = persona.segundoApellido;
		this.fechaNacimiento = persona.fechaNacimiento;
		this.genero = persona.genero;
		
	}
	
	
	public Persona(int idPersona, int numeroDocumento, String nombres, String primerApellido, String segundoApellido,
			String genero) {
		super();
		this.idPersona = idPersona;
		this.numeroDocumento = numeroDocumento;
		this.nombres = nombres;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.genero = genero;
	}

	
	public Persona(int idPersona, int numeroDocumento, String nombres, String primerApellido, String segundoApellido,
			Date fechaNacimiento, String genero) {
		super();
		this.idPersona = idPersona;
		this.numeroDocumento = numeroDocumento;
		this.nombres = nombres;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.fechaNacimiento = fechaNacimiento;
		this.genero = genero;
	}


	

	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public int getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}


	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", numeroDocumento=" + numeroDocumento + ", nombres=" + nombres
				+ ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", fechaNacimiento="
				+ fechaNacimiento + ", genero=" + genero + "]";
	}
	
	
}
