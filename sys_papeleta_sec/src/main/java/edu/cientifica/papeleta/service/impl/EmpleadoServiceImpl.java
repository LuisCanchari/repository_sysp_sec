package edu.cientifica.papeleta.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.papeleta.mappers.EmpleadoMapper;
import edu.cientifica.papeleta.model.Area;
import edu.cientifica.papeleta.model.Empleado;
import edu.cientifica.papeleta.service.AreaService;
import edu.cientifica.papeleta.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	protected final Log LOG = LogFactory.getLog(this.getClass());
	private static final int EMPLEADO_728 = 1;
	private static final int EMPLEADO_CAS = 2;
	private List<Empleado> listadoEmpleados;
	
	@Autowired
	private AreaService areaService;
	
	@Autowired
	private EmpleadoMapper empleadoMapper;

	public EmpleadoServiceImpl() {
		super();
		listadoEmpleados = new ArrayList<Empleado>();

		Empleado e1 = new Empleado(1, 10008080, "Juan", "Rios", "Diaz", "M", EMPLEADO_728);
		//e1.setArea(areaService.buscarArea(1));
		//e1.setArea(new Area());

		Empleado e2 = new Empleado(2, 20008080, "Mario", "Teran", "Pascual", "M", EMPLEADO_CAS);
		//e2.setArea(areaService.buscarArea(2));

		Empleado e3 = new Empleado(3, 300080080, "Mia", "Soto", "Aliaga", "F", EMPLEADO_CAS);
		//e3.setArea(areaService.buscarArea(3));

		Empleado e4 = new Empleado(4, 40008080, "Katy", "Vszco", "Sullca", "F", EMPLEADO_728);
		//e4.setArea(areaService.buscarArea(3));

		listadoEmpleados.add(e1);
		listadoEmpleados.add(e2);
		listadoEmpleados.add(e3);
		listadoEmpleados.add(e4);
	}
	@Override
	public List<Empleado> listarEmpleados() {
		LOG.info("ingreso a lista de empleados");
		List<Empleado> listado = new ArrayList<Empleado>();
		listado =  empleadoMapper.listaEmpleado();
		
		for (Empleado empleado : listado) {
			LOG.info(empleado.toString());
			
		}

		//return listadoEmpleados;
		
		return  listado;
				
	}
	
	@Override
	public Empleado empleadoById(int id) {
		Empleado empleado; //= new Empleado();
		empleado = empleadoMapper.empleadoById(id);
		/*
		for (Empleado empleado : listadoEmpleados) {
			if (empleado.getIdPersona() == id) {
				return empleado;
			}
		}*/
		return empleado;
	}
}
