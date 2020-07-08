package edu.cientifica.papeleta.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cientifica.papeleta.mappers.PapeletaMapper;
import edu.cientifica.papeleta.model.Papeleta;
import edu.cientifica.papeleta.service.PapeletaService;

@Service
public class PapeletaServiceImpl implements PapeletaService{
	protected final Log LOG = LogFactory.getLog(this.getClass());
	
	private List<Papeleta> listaPapeleta;
	
	@Autowired 
	private PapeletaMapper papeletaMapper;
	
	/*Constructor*/
	public PapeletaServiceImpl() {
		super();
		listaPapeleta =  new ArrayList<Papeleta>();
		
	}
	
	@Override
	public int nuevoIdPapeleta() {
		
		int nuevoId;
		nuevoId=  papeletaMapper.nuevoIdPapeleta();
		LOG.info("Nuevo Id: " +nuevoId);
		return nuevoId;
	}
	
	@Override
	public List<Papeleta> listaPapeletas() {
		List<Papeleta> listaPapeleta = new ArrayList<Papeleta>();
		listaPapeleta = papeletaMapper.listaPapeleta();
		for (Papeleta papeleta : listaPapeleta) {
			LOG.info(papeleta.toString());
		}
		return papeletaMapper.listaPapeleta();

	}
	
	@Override
	public int insertarPapeleta(Papeleta papeleta) {
		LOG.info("Datos de papeleta: " +papeleta.toString());
		papeletaMapper.insertarPapeleta(papeleta);
		return 0;
	}
	
	@Override
	public Papeleta papeletaById(int id) {
			return papeletaMapper.papeletaById(id);
	}

	@Override
	public int actualizarPapeleta(Papeleta papeleta) {
		return papeletaMapper.actualizarPapeleta(papeleta);
	}
	

}
