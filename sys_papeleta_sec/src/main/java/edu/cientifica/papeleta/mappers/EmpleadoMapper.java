package edu.cientifica.papeleta.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import edu.cientifica.papeleta.model.Empleado;

@Mapper
public interface EmpleadoMapper {

	public List<Empleado> listaEmpleado();
	public List<Empleado> listaEmpleadosByArea( @Param ( "idArea" ) int idArea);
	
	public Empleado empleadoById(int Id);
	public int insertarEmpleado(Empleado empleado);
	public int actualizarEmpleado(Empleado empleado);

}
