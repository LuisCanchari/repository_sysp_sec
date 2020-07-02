package edu.cientifica.papeleta.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.cientifica.papeleta.model.Papeleta;

@Mapper
public interface PapeletaMapper {
	public int nuevoIdPapeleta();
	public List<Papeleta> listaPapeleta();
	public int insertarPapeleta(Papeleta papeleta);
	public int actualizarPapeleta(Papeleta papeleta);
	public Papeleta papeletaById(int id);
	

}
