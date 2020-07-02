package edu.cientifica.papeleta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.cientifica.papeleta.model.Motivo;
import edu.cientifica.papeleta.service.MotivoService;

@Controller
@RequestMapping("/motivo")
public class MotivoController {
	//@Autowired private MotivoService motivoService;
	@Autowired
	private MotivoService motivoService;
	
	@RequestMapping(value="/lista")
	public String listarMotivos(Model model)
	{	
		model.addAttribute("motivos", motivoService.listarMotivos() );
		return "motivo_listado";
	}
	
//	@RequestMapping(value = { "/lista" }, method = RequestMethod.GET)
//	public String listarArea(Model model) {
//		model.addAttribute("motivos", motivoService.listarMotivos());
//		return "motivo_lista";
//	}
//	
	@RequestMapping(value = { "/form" }, method = RequestMethod.GET)
	public String formularioMotivo(Model model) {
		Motivo motivo = new Motivo(); 
		model.addAttribute("motivo", motivo);
		return "motivo_form";
	}
	

}
