package edu.cientifica.papeleta.controller;

import java.sql.Date;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;

import edu.cientifica.papeleta.model.Area;
import edu.cientifica.papeleta.model.Empleado;
import edu.cientifica.papeleta.service.AreaService;
import edu.cientifica.papeleta.service.EmpleadoService;

@RequestMapping("/empleado")
@Controller
public class EmpleadoController {
	protected final Log LOG = LogFactory.getLog(this.getClass());
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private AreaService areaService;

	@RequestMapping(value = { "/form" }, method = RequestMethod.GET)
	public String formularioEmpleado(Model model) {
		model.addAttribute("listadoAreas", areaService.listarAreas());
		model.addAttribute("empleado", new Empleado());
		return "empleado_form";
	}
	
	@RequestMapping("/lista")
	public String listaEmpleado(Model model, 
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, 
			@RequestParam(value = "pageSize", defaultValue = "8") Integer pageSize) {
		
		PageInfo<Empleado> pageInfo =  new PageInfo<Empleado>(empleadoService.listarEmpleados(pageNum, pageSize));
		model.addAttribute("empleados", empleadoService.listarEmpleados(pageNum, pageSize));
		model.addAttribute("pageInfo", pageInfo);
		
		return "empleado_lista";
		
	}
	
	@GetMapping("/editar/{id}")
	public String editarEmpleado(Model model, @PathVariable(name = "id") int id) {
		
		model.addAttribute("empleado", empleadoService.empleadoById(id));
		model.addAttribute("areas", areaService.listarAreas());
		
		return "empleado_edit";
	}
	
	@RequestMapping(value = { "/crear" }, method = RequestMethod.POST)
	public String crearEmpleado(@ModelAttribute("empleado") Empleado empleado, BindingResult errors, Model model,
			@RequestParam(name = "fechaNacimiento") Date fechaNacimiento, 
			@RequestParam(name = "fechaIngreso") Date fechaIngreso) {
		
		empleado.setFechaNacimiento(fechaNacimiento);
		empleado.setFechaIngreso(fechaIngreso);
		
		empleadoService.insertarEmpleado(empleado);

		return "redirect:/empleado/lista";
	}
	
	@RequestMapping(value = { "/actualizar" }, method = RequestMethod.POST)
	public String actualizarEmpleado(@ModelAttribute("empleado") Empleado empleado, 
			BindingResult errors, Model model) {
			
		empleadoService.actualizarEmpleado(empleado);

		return "redirect:/empleado/lista";
	}


}
