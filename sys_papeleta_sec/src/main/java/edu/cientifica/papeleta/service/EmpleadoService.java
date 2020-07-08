package edu.cientifica.papeleta.service;

import java.util.List;

import edu.cientifica.papeleta.model.Empleado;

public interface EmpleadoService {
	public List<Empleado> listarEmpleados(Integer pageNum, Integer pageSize);
	public List<Empleado> listaEmpleadosByArea(int idArea);
	public Empleado empleadoById(int id);
	public int insertarEmpleado(Empleado empleado);
	public int actualizarEmpleado(Empleado empleado);

}
