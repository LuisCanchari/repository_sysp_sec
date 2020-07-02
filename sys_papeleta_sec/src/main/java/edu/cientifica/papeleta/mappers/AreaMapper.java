package edu.cientifica.papeleta.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;


import edu.cientifica.papeleta.model.Area;

@Mapper
public interface AreaMapper {
//	@Select("select id_area idArea, nombre_corto nombreCorto, nombre_largo nombreLargo, area_superior areaSuperior from area")
	public List<Area> listaArea();
	public Area areaById(int id);
	public int nuevoIdArea();
	public int insertarArea(Area area);
	public int actualizarArea(Area area);
}
