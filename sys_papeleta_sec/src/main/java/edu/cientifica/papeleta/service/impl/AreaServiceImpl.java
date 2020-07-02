package edu.cientifica.papeleta.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.papeleta.mappers.AreaMapper;
import edu.cientifica.papeleta.model.Area;
import edu.cientifica.papeleta.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {
	
	protected final Log LOG = LogFactory.getLog(this.getClass());
	private List<Area> listadoAreas;
	@Autowired AreaMapper areaMapper;
	
	

	public AreaServiceImpl() {
		super();
		listadoAreas = new ArrayList<Area>();
		listadoAreas.add(new Area(1, "GG", "Gerencia General", null));
		listadoAreas.add(new Area(2, "ADM", "Administracion", null));
		listadoAreas.add(new Area(3, "UCONT", "Unidad de Contabilidad", null));
		listadoAreas.add(new Area(4, "ULOG", "Unidad de Logistica", null));
		listadoAreas.add(new Area(5, "UTES", "Unidad de Tesorería", null));
		listadoAreas.add(new Area(6, "ALM", "Unidad de Almacen", null));
	}

	@Override
	public List<Area> listarAreas() {
		LOG.info("Inicia la extraccion del listado de la bd");
		List<Area> listado = new ArrayList<Area>();
		listado = areaMapper.listaArea();
		
		for (Area area : listado) {
			LOG.info(area.toString());
		}
		/*conectar a bd*/
		return listado;
	}

	@Override
	public Area areaById(int codigo) {
		return areaMapper.areaById(codigo);
		/*
		for (Area area : listadoAreas) {
			if (area.getIdArea() == codigo) {
				return area;
			}
		}*/

		//return null;
	}

	@Override
	public int agregarArea(Area area) {
		listadoAreas.add(area);
		return 0;
	}

	@Override
	public int nuevoIdArea() {
		
		return areaMapper.nuevoIdArea();
	}

	@Override
	public int insertarArea(Area area) {
		area.setIdArea(areaMapper.nuevoIdArea());
		areaMapper.insertarArea(area);
		return 0;
	}

	@Override
	public int actualizarArea(Area area) {
		areaMapper.actualizarArea(area);
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
