package edu.cientifica.papeleta.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.cientifica.papeleta.model.Area;
import edu.cientifica.papeleta.model.Persona;

@Mapper
public interface PersonaMapper {
	
	public List<Persona> listarPersonas();
	public int nuevoIdPersona();
	public int insertarPersona(Persona persona);
	public int actualizarPersona(Persona persona);


}
