package edu.cientifica.papeleta.model;

import java.sql.Date;

public class Papeleta {
	private int idPapeleta;
	private Empleado empleado;
	private Motivo motivo;
	private Date fechaInicio;
	private String horaInicio;
	private Date fechaFin;
	private String horaFin;
	private String observacion;
	
	public Papeleta() {
		super();
	}

	

	public int getIdPapeleta() {
		return idPapeleta;
	}



	public void setIdPapeleta(int idPapeleta) {
		this.idPapeleta = idPapeleta;
	}



	public Empleado getEmpleado() {
		return empleado;
	}



	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}



	public Motivo getMotivo() {
		return motivo;
	}



	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}



	public Date getFechaInicio() {
		return fechaInicio;
	}



	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}



	public String getHoraInicio() {
		return horaInicio;
	}



	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}



	public Date getFechaFin() {
		return fechaFin;
	}



	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}



	public String getHoraFin() {
		return horaFin;
	}



	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}


	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	@Override
	public String toString() {
		return "Papeleta [idPapeleta=" + idPapeleta + ", empleado=" + empleado + ", motivo=" + motivo + ", fechaInicio="
				+ fechaInicio + ", horaInicio=" + horaInicio + ", fechaFin=" + fechaFin + ", horaFin=" + horaFin
				+ ", observacion=" + observacion + "]";
	}



	
	
	

}
