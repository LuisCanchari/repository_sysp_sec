package edu.cientifica.papeleta.service;

import java.util.List;

import edu.cientifica.papeleta.model.Motivo;

public interface MotivoService {
	public List<Motivo> listarMotivos();
	public Motivo buscarMotivos(int id);
	public Motivo motivoById(int id);

}
