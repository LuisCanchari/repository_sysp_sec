package edu.cientifica.papeleta.model;

public class Area {
	private int idArea;
	private String nombreCorto;
	private String nombreLargo;
	private Area areaSuperior;
	
	public Area() {
		super();
	}
	
	public Area(int idArea, String nombreCorto, String nombreLargo) {
		super();
		this.idArea = idArea;
		this.nombreCorto = nombreCorto;
		this.nombreLargo = nombreLargo;
	}
	
	public Area(int idArea, String nombreCorto, String nombreLargo, Area areaSuperior) {
		super();
		this.idArea = idArea;
		this.nombreCorto = nombreCorto;
		this.nombreLargo = nombreLargo;
		this.areaSuperior = areaSuperior;
	}
	
	

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getNombreCorto() {
		return nombreCorto;
	}

	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}

	public String getNombreLargo() {
		return nombreLargo;
	}

	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}

	public Area getAreaSuperior() {
		return areaSuperior;
	}

	public void setAreaSuperior(Area areaSuperior) {
		this.areaSuperior = areaSuperior;
	}

	@Override
	public String toString() {
		return "Area [idArea=" + idArea + ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo + "]";
	}
	
}
