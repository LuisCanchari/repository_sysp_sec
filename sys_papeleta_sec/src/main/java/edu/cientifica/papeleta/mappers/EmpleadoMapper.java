package edu.cientifica.papeleta.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.cientifica.papeleta.model.Empleado;

@Mapper
public interface EmpleadoMapper {

	public List<Empleado> listaEmpleado();
	public Empleado empleadoById(int Id);

}
