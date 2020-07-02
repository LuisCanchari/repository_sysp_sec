package edu.cientifica.papeleta.service;

import java.util.List;

import edu.cientifica.papeleta.model.Area;

public interface AreaService {
	public List<Area> listarAreas();
	public Area areaById(int codigo);
	public int nuevoIdArea();
	public int insertarArea(Area area);
	public int actualizarArea(Area area);
	public int agregarArea(Area area); //solo para memoria
}
