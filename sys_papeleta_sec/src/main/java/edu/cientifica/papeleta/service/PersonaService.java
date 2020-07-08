package edu.cientifica.papeleta.service;

import java.util.List;

import edu.cientifica.papeleta.model.Persona;



public interface PersonaService {
	public List<Persona> listarPersonas();
	public Persona buscarPersoa(int codigo);
	 

}
