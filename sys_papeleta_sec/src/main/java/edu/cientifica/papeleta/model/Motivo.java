package edu.cientifica.papeleta.model;

public class Motivo {
	private int idMotivo;
	private String descripcion;
	private int tipoMotivo;
	
	public Motivo() {
		super();
	}

	public Motivo(int idMotivo, String descripcion, int tipoMotivo) {
		super();
		this.idMotivo = idMotivo;
		this.descripcion = descripcion;
		this.tipoMotivo = tipoMotivo;
	}

	public int getIdMotivo() {
		return idMotivo;
	}

	public void setIdMotivo(int idMotivo) {
		this.idMotivo = idMotivo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTipoMotivo() {
		return tipoMotivo;
	}

	public void setTipoMotivo(int tipoMotivo) {
		this.tipoMotivo = tipoMotivo;
	}

	@Override
	public String toString() {
		return "Motivo [idMotivo=" + idMotivo + ", descripcion=" + descripcion + ", tipoMotivo=" + tipoMotivo + "]";
	}
	

}
