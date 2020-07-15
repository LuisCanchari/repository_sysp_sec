package edu.cientifica.papeleta.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import edu.cientifica.papeleta.mappers.MotivoMapper;
import edu.cientifica.papeleta.model.Motivo;
import edu.cientifica.papeleta.service.MotivoService;

@Service
public class MotivoServiceImpl implements MotivoService {
	private List<Motivo> listaMotivos;
	
	@Autowired
	private MotivoMapper motivoMapper;

	public MotivoServiceImpl() {
		super();
		listaMotivos = new ArrayList<>();
		listaMotivos.add(new Motivo(1, "Descanso Médico", 1));
		listaMotivos.add(new Motivo(2, "Cita Médica", 1));
		listaMotivos.add(new Motivo(3, "Capacitación Oficializada", 1));
		listaMotivos.add(new Motivo(4, "Comisión de servicios", 1));
		listaMotivos.add(new Motivo(5, "Onomastico", 1));
		listaMotivos.add(new Motivo(6, "Vacaciones", 1));
		listaMotivos.add(new Motivo(7, "Otro", 1));
		listaMotivos.add(new Motivo(8, "Permiso Particular", 2));
		listaMotivos.add(new Motivo(9, "Capacitación no oficial", 2));
		listaMotivos.add(new Motivo(10, "Otro", 2));
		listaMotivos.add(new Motivo(11, "Omisión de marcado", 3));
		listaMotivos.add(new Motivo(12, "Matrimonio", 3));
		listaMotivos.add(new Motivo(13, "Fallecimiento familiar", 3));
		listaMotivos.add(new Motivo(14, "Enfermedad familiar", 3));
		listaMotivos.add(new Motivo(15, "Licencia paternidad", 3));
		
	}

	@Override
	public List<Motivo> listarMotivos() {
		return motivoMapper.listarMotivos();
	}
	

	@Override
	public List<Motivo> listarMotivos(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Motivo> listaMotivos = motivoMapper.listarMotivos();  
		return listaMotivos;
	}

	@Override
	public Motivo buscarMotivos(int id) {
		for (Motivo motivo : listaMotivos) {
			if (motivo.getIdMotivo() == id) {
				return motivo;
				}
			}
		return null;
	}

	@Override
	public Motivo motivoById(int id) {
		return motivoMapper.motivoById(id);
	}
	

}
