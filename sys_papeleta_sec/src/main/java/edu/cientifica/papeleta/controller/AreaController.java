package edu.cientifica.papeleta.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cientifica.papeleta.model.Area;
import edu.cientifica.papeleta.service.AreaService;

@Controller
@RequestMapping("/area")
public class AreaController {
	protected final Log LOG = LogFactory.getLog(this.getClass());

	@Autowired
	private AreaService areaService;

	@RequestMapping(value = { "/form" })
	public String formularioArea(Model model) {
		List<Area> listadoAreas;
		listadoAreas = areaService.listarAreas();

		model.addAttribute("listadoAreas", listadoAreas);

		model.addAttribute("area", new Area());
		return "area_form";
	}

	@RequestMapping(value = { "/crear" }, method = RequestMethod.POST)
	public String crearArea(@ModelAttribute Area area, BindingResult errors, Model model) {
		// areaService.agregarArea(area);
		areaService.insertarArea(area);

		model.addAttribute("areas", areaService.listarAreas());

		return "redirect:/area/lista";
	}

	@RequestMapping(value = { "/editar/{id}" }, method = RequestMethod.GET)
	public String editarArea(Model model, @PathVariable(name = "id") int id) {
		List<Area> listadoAreas;
		listadoAreas = areaService.listarAreas();
		Area area = areaService.areaById(id);
		
		LOG.info("Area Superior"+area.getAreaSuperior().toString());
		model.addAttribute("listadoAreas", listadoAreas);
		model.addAttribute("area", area);

		return "area_edit";

	}

	@RequestMapping(value = { "/actualizar" }, method = RequestMethod.POST)
	public String actualizarArea(@ModelAttribute Area area, BindingResult errors, Model model) {
		
		
		LOG.info("Datos de area");
		LOG.info(area.toString());
		LOG.info(area.getAreaSuperior().toString());
		
		areaService.actualizarArea(area);
		
		model.addAttribute("areas", areaService.listarAreas());

		

		return "redirect:/area/lista";
	}

	@RequestMapping(value = { "/lista" }, method = RequestMethod.GET)
	public String listarArea(Model model) {
		model.addAttribute("areas", areaService.listarAreas());
		return "area_lista";
	}
}
