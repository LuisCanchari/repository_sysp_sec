package edu.cientifica.papeleta.service;

import java.util.List;

import edu.cientifica.papeleta.model.Motivo;

public interface MotivoService {
	public List<Motivo> listarMotivos();
	public List<Motivo> listarMotivos(Integer pageNum, Integer pageSize);
	public Motivo buscarMotivos(int id);
	public Motivo motivoById(int id);

}
