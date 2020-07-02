package edu.cientifica.papeleta.service;

import java.util.List;

import edu.cientifica.papeleta.model.Papeleta;


public interface PapeletaService {
	public int nuevoIdPapeleta();
	public List<Papeleta> listaPapeletas();
	public Papeleta papeletaById(int id);
	public int insertarPapeleta(Papeleta papeleta);
	public int actualizarPapeleta(Papeleta papeleta);
	

}
