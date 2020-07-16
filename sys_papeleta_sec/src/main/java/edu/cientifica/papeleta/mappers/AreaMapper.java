package edu.cientifica.papeleta.mappers;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Select;


import edu.cientifica.papeleta.model.Area;
import net.sf.jsqlparser.expression.MySQLIndexHint;

@Mapper
public interface AreaMapper {
//	@Select("select id_area idArea, nombre_corto nombreCorto, nombre_largo nombreLargo, area_superior areaSuperior from area")
	public List<Area> listaArea() throws SQLException;
	public Area areaById(int id) throws SQLException;
	public int nuevoIdArea() throws SQLException;
	public int insertarArea(Area area)  throws SQLException;
	public int actualizarArea(Area area) throws SQLException;
	public int eliminarArea(Area area) throws SQLException;
}
