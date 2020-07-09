package edu.cientifica.papeleta.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import edu.cientifica.papeleta.mappers.EmpleadoMapper;
import edu.cientifica.papeleta.mappers.PersonaMapper;
import edu.cientifica.papeleta.model.Area;
import edu.cientifica.papeleta.model.Empleado;
import edu.cientifica.papeleta.model.Persona;
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
	
	@Autowired
	private PersonaMapper personaMapper;
	
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
	public List<Empleado> listarEmpleados(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Empleado> listado = new ArrayList<Empleado>();
		listado =  empleadoMapper.listaEmpleado();
		return  listado;
				
	}
	
	@Override
	public Empleado empleadoById(int id) {
		Empleado empleado; 
		empleado = empleadoMapper.empleadoById(id);
		return empleado;
	}
	
	@Override
	public List<Empleado> listaEmpleadosByArea(int idArea) {
		return empleadoMapper.listaEmpleadosByArea(idArea);
	}
	
	
	@Override
	@Transactional
	public int insertarEmpleado(Empleado empleado) {
		
		int idPersona = personaMapper.nuevoIdPersona();
		empleado.setIdPersona(idPersona);
		Persona persona =  (Persona) empleado;
		personaMapper.insertarPersona(persona);
		empleadoMapper.insertarEmpleado(empleado);
		
		return 0;
	}
	@Override
	@Transactional
	public int actualizarEmpleado(Empleado empleado) {
		if (empleado.getArea().getIdArea()==0){
			empleado.setArea(null);
		}
		personaMapper.actualizarPersona((Persona)empleado);
		empleadoMapper.actualizarEmpleado(empleado);
		return 0;
	}
	
	
	
}
