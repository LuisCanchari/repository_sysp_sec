package edu.cientifica.papeleta.model;

import java.sql.Date;

public class Empleado extends Persona {
	private Area area;
	private Date fechaIngreso;
	private int tipoEmpleado;

	public Empleado() {
		super();
	}
	
	public Empleado(Persona persona) {
		super(persona);
	}
	
	public Empleado(Empleado empleado) {
		super((Persona) empleado);
		this.area = empleado.area;
		this.fechaIngreso =empleado.fechaIngreso;
		this.tipoEmpleado = empleado.tipoEmpleado;
	}
	
		
	public Empleado(Persona persona, Area area) {
		super(persona);
		this.area =area;
	}
	
	public Empleado(Persona persona, Area area, Date fechaIngreso,int tipoEmpleado) {
		super(persona);
		this.area =area;
		this.fechaIngreso = fechaIngreso;
		this.tipoEmpleado=tipoEmpleado;
	}
	
	/*Crea empleado con padre persona*/
	public Empleado(int idPersona, int numeroDocumento, String nombres, String primerApellido, String segundoApellido,
			String genero, int tipoEmpleado) {
		super(idPersona, numeroDocumento, nombres, primerApellido, segundoApellido,genero);
		this.tipoEmpleado = tipoEmpleado;
		
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public int getTipoEmpleado() {
		return tipoEmpleado;
	}

	public void setTipoEmpleado(int tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	@Override
	public String toString() {
		return "Empleado ["+ super.toString() +"area=" + area + ", fechaIngreso=" + fechaIngreso + ", tipoEmpleado=" + tipoEmpleado + "]";
	}

	
	
}
