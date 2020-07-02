package edu.cientifica.papeleta.service;

import java.util.List;

import edu.cientifica.papeleta.model.Empleado;

public interface EmpleadoService {
	public List<Empleado> listarEmpleados();
	public Empleado empleadoById(int id);

}
