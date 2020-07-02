package edu.cientifica.papeleta.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.cientifica.papeleta.model.Motivo;

@Mapper
public interface MotivoMapper {
	public List<Motivo> listarMotivos();
	public Motivo buscarMotivos(int id);
	public Motivo motivoById(int id);

}
