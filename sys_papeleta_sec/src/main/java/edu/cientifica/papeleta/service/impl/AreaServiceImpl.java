package edu.cientifica.papeleta.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import edu.cientifica.papeleta.mappers.AreaMapper;
import edu.cientifica.papeleta.model.Area;
import edu.cientifica.papeleta.service.AreaService;
import net.sf.jsqlparser.expression.operators.relational.IsNullExpression;

@Service
public class AreaServiceImpl implements AreaService {
	protected final Log LOG = LogFactory.getLog(this.getClass());

	@Autowired AreaMapper areaMapper;
	public AreaServiceImpl() {
		super();
	}
	@Override
	public List<Area> listarAreas(Integer pageNum, Integer pageSize) throws Exception {
		PageHelper.startPage(pageNum, pageSize);
		List<Area> listado;
		listado = areaMapper.listaArea();
		if (listado == null) {
			throw new Exception ("No retornó datos de la base de datos");
		}
		return listado;
	}
	@Override
	public List<Area> listarAreas() throws Exception {
		List<Area> listado;
		listado = areaMapper.listaArea();
		if (listado == null) {
			throw new Exception ("No retornó datos de la base de datos");
		}
		return listado;	
	}
	@Override
	public Area areaById(int codigo) throws Exception {
		Area area;
		area = areaMapper.areaById(codigo);
		if (area == null) {
			throw new Exception ("No retornó datos de la base de datos");
		}
		return area;
	}

	@Override
	public int nuevoIdArea() throws Exception {
		int nuevoId;
		nuevoId = areaMapper.nuevoIdArea();
		if (nuevoId == 0) {
			throw new Exception ("No retornó datos de la base de datos");
		}
		return nuevoId;
	}

	@Override
	public int insertarArea(Area area) throws Exception {
		int result = 0;
		if (area.getAreaSuperior().getIdArea()==0){
			area.setAreaSuperior(null);
		}
		area.setIdArea(nuevoIdArea());
		result = areaMapper.insertarArea(area);
		if (result==0) {
			throw new Exception ("No se insertó el area");
		}
		return result;
	}

	@Override
	public int actualizarArea(Area area) throws Exception {
		int result = 0; 
		if (area.getAreaSuperior().getIdArea()==0){
			area.setAreaSuperior(null);
		}
		result = areaMapper.actualizarArea(area);
		if (result==0) {
			throw new Exception ("No se actualizó el area");
		}
		return result;
	}
	
	@Override
	public int eliminarArea(Area area) throws Exception {
		
		
		return 0;
	}
	
	
	
}
