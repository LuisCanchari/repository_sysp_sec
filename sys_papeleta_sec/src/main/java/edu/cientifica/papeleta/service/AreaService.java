package edu.cientifica.papeleta.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.javassist.NotFoundException;

import edu.cientifica.papeleta.model.Area;

public interface AreaService {
	public List<Area> listarAreas(Integer pageNum, Integer pageSize) throws Exception;
	public List<Area> listarAreas() throws Exception;
	public Area areaById(int codigo) throws Exception;
	public int nuevoIdArea() throws Exception;;
	public int insertarArea(Area area) throws Exception;
	public int actualizarArea(Area area) throws Exception;
	public int eliminarArea(Area area) throws Exception;
	
}
