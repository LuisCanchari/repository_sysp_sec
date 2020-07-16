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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;

import edu.cientifica.papeleta.model.Area;
import edu.cientifica.papeleta.model.Empleado;
import edu.cientifica.papeleta.service.AreaService;

@Controller
@RequestMapping("/area")
public class AreaController {
	protected final Log LOG = LogFactory.getLog(this.getClass());

	@Autowired
	private AreaService areaService;

	@RequestMapping(value = { "/form" })
	public String formularioArea(Model model) {
		List<Area> listadoAreas = null;
		try {
			listadoAreas = areaService.listarAreas();
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}
		if (listadoAreas != null) {
			model.addAttribute("listadoAreas", listadoAreas);
			model.addAttribute("area", new Area());
			return "area_form";
		} else {
			return "error";
		}

	}

	@RequestMapping(value = { "/crear" }, method = RequestMethod.POST)
	public String crearArea(@ModelAttribute Area area, BindingResult errors, Model model,
			RedirectAttributes attribute) {
		int result = 0;

		try {
			result = areaService.insertarArea(area);
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}

		if (result != 0) {
			attribute.addFlashAttribute("success", "Se guardó correctamente");
		} else {
			attribute.addFlashAttribute("error", "Problemas al guardar area");
		}

		return "redirect:/area/lista";
	}

	@RequestMapping(value = { "/editar/{id}" }, method = RequestMethod.GET)
	public String editarArea(Model model, @PathVariable(name = "id") int id, 
			RedirectAttributes attribute) {
		List<Area> listadoAreas = null;
		Area area = null;
		
		try {
			listadoAreas = areaService.listarAreas();
			area = areaService.areaById(id);
			
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}
		
		if (area!=null) {
			model.addAttribute("listadoAreas", listadoAreas);
			model.addAttribute("area", area);
			return "area_edit";
		}else {
			attribute.addFlashAttribute("error", "El Área no existe");
			return "redirect:/area/lista";
		}

	}

	@RequestMapping(value = { "/actualizar" }, method = RequestMethod.POST)
	public String actualizarArea(@ModelAttribute Area area, BindingResult errors, Model model,
			RedirectAttributes attribute) {
		int result = 0;
		try {
			result = areaService.actualizarArea(area);
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}
		if (result != 0) {
			attribute.addFlashAttribute("success", "Se guardó correctamente");
		} else {
			attribute.addFlashAttribute("error", "Problemas al actualizar area");
		}
		return "redirect:/area/lista";
	}

	@RequestMapping(value = { "/lista" })
	public String listarArea(Model model,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, 
			@RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize) {
		
		List<Area> listadoAreas = null;
		PageInfo<Area> pageInfo =  null;

		try {
			listadoAreas = areaService.listarAreas(pageNum, pageSize);
			pageInfo =  new PageInfo<Area> (listadoAreas);
			
		} catch (Exception e) {
			LOG.info(e.getMessage());
		}
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("areas", listadoAreas);
		return "area_lista";
	}
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarArea(Model model, @PathVariable(name = "id") int id, 
			RedirectAttributes attribute) {
		Area area;
		int result = 0;
		try {
			area = areaService.areaById(id);
			result= areaService.eliminarArea(area);
		} catch (Exception e) {
			LOG.info("error:"+e.getMessage());
		}
		if(result!=0) {
			return "";
		} else {
			return null;
		}
	}
}
