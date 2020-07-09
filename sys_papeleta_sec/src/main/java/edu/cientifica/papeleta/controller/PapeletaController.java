package edu.cientifica.papeleta.controller;

import java.sql.Date;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.print.attribute.standard.DateTimeAtCompleted;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cientifica.papeleta.model.Area;
import edu.cientifica.papeleta.model.Empleado;
import edu.cientifica.papeleta.model.Motivo;
import edu.cientifica.papeleta.model.Papeleta;
import edu.cientifica.papeleta.service.AreaService;
import edu.cientifica.papeleta.service.EmpleadoService;
import edu.cientifica.papeleta.service.MotivoService;
import edu.cientifica.papeleta.service.PapeletaService;

@RequestMapping("/papeleta")
@Controller
public class PapeletaController {
	protected final Log LOG = LogFactory.getLog(this.getClass());
	
	@Autowired
	private AreaService areaService;

	@Autowired
	private EmpleadoService empleadoService;

	@Autowired
	private PapeletaService papeletaService;
	
	@Autowired
	private MotivoService motivoService;

	/* Presenta el formulario de papeleta*/
	@RequestMapping(value = { "/form" }, method = RequestMethod.GET)
	public String formularioPapleta(Model model) {

		model.addAttribute("listadoAreas", areaService.listarAreas());
		model.addAttribute("listadoEmpleados", empleadoService.listaEmpleadosByArea(1));
		
		return "papeleta_form";
	}

	/* Crear Papeleta con los datos recibidos del formulario*/
	@RequestMapping(value = { "/crear" }, method = RequestMethod.POST)
	public String crearPapeleta(@RequestParam(name = "area") int idArea,
		@RequestParam(name = "empleado") int idEmpleado, @RequestParam(name = "fechaInicio") Date fechaInicio,
		@RequestParam(name = "horaInicio") String horaInicio, @RequestParam(name = "fechaFin") Date fechaFin,
		@RequestParam(name = "horaFin") String horaFin, @RequestParam(name = "motivo") int  idMotivo,
		@RequestParam(name = "observacion") String  observacion) 	{
		
		Papeleta papeleta = new Papeleta();
		
		Empleado empleado = empleadoService.empleadoById(idEmpleado);
		Area area = areaService.areaById(idArea);
		Motivo motivo  =  motivoService.motivoById(idMotivo);

		papeleta.setIdPapeleta(papeletaService.nuevoIdPapeleta());
		papeleta.setEmpleado(empleado);
		papeleta.setMotivo(motivo);
		papeleta.setFechaInicio(fechaInicio);
		papeleta.setHoraInicio(horaInicio);
		papeleta.setFechaFin(fechaFin);
		papeleta.setHoraFin(horaFin);
		papeleta.setObservacion(observacion);
		
		
		//SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		//String dateInString = "7-Jun-2013";
		//papeleta.setFechafin(d.of(year, month, dayOfMonth));
		
		papeletaService.insertarPapeleta(papeleta);
		
		return "redirect:/papeleta/listar";
	}
	
	@RequestMapping(value = { "/listar" }, method = RequestMethod.GET)
	public String listarPapeleta(Model model) {
		model.addAttribute("papeletas", papeletaService.listaPapeletas());
		return "papeleta_lista";
	
	}
	@RequestMapping(value = {"/editar/{id}"}, method = RequestMethod.GET)
	public String editarPapeleta(Model model, @PathVariable(name = "id") int id) {
		Papeleta papeleta = papeletaService.papeletaById(id);
		
		model.addAttribute("listadoAreas", areaService.listarAreas());
		model.addAttribute("listadoEmpleados", empleadoService.listaEmpleadosByArea(papeleta.getEmpleado().getArea().getIdArea()));
		model.addAttribute("papeleta", papeletaService.papeletaById(id));
		
		return "papeleta_edit"; 
	}
	
	@RequestMapping(value = { "/actualizar" }, method = RequestMethod.POST)
	public String actualizarPapeleta(@ModelAttribute Papeleta papeleta){
		
		
		LOG.info("Datos de Papeleta" + papeleta.toString());
		papeletaService.actualizarPapeleta(papeleta);
		
		return "redirect:/papeleta/listar";
	}
	
	/*
	@RequestMapping(value = "/refrecarEmpleados", method = RequestMethod.GET)
	public String refreshEmpleados(@RequestParam("idArea") int idArea, Model model) {
		
	    List<Empleado> empleados = empleadoService.listaEmpleadosByArea(idArea);
	    model.addAttribute("listadoEmpleados", empleados);

	    return "papeleta_form :: #empleado";
	}*/
	
}
