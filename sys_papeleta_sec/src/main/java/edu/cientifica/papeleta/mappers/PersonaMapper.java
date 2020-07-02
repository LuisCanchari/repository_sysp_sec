package edu.cientifica.papeleta.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.cientifica.papeleta.model.Persona;

@Mapper
public interface PersonaMapper {
	
	public List<Persona> listarPersonas();

}
