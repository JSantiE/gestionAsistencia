package pe.com.datatech.asistencia.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import pe.com.datatech.asistencia.dto.MenuItem;
import pe.com.datatech.asistencia.entity.Area;
import pe.com.datatech.asistencia.entity.Empleado;
import pe.com.datatech.asistencia.entity.Usuario;
import pe.com.datatech.asistencia.repository.AreaRepository;
import pe.com.datatech.asistencia.repository.EmpleadoRepository;
import pe.com.datatech.asistencia.repository.MenuRepository;
import pe.com.datatech.asistencia.util.Util;

@Controller
public class EmpleadoController {
	@Autowired
	private EmpleadoRepository empleadoRepository;
		
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private AreaRepository areaRepository;
	
	@Autowired
	private Util util;

	@GetMapping("/empleado/list")
	public ModelMap getAll(@PageableDefault(size = 10) Pageable pageable,
			@RequestParam(name = "value", required = false) String value, Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username", ((Usuario) principal).getUsuario());
		return new ModelMap().addAttribute("empleado", empleadoRepository.findAll(pageable));
	}

	@GetMapping("/empleado/form")
	public ModelMap getById(@RequestParam(value = "id", required = false) Empleado empleado, Model model) {
		if (empleado == null) {
			empleado = new Empleado();
		}
		return new ModelMap("empleado", empleado);
	}

	@Transactional
	@PostMapping("/empleado/form")
	public String saveSocio(@Valid Empleado empleado, BindingResult result, SessionStatus status) {
		// new ClienteValidator().validate(empleado, result);
		if (result.hasErrors()) {
			return "empleado/form";
		}
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		empleado.setIdEmpresa(1);
		int idUsuario=Integer.parseInt(String.valueOf(((Usuario) principal).getId()));
		if(empleado.getIdUsuarioCreacion()==null) {
			empleado.setIdUsuarioCreacion(idUsuario);
			empleado.setFechaCreacion(util.fechaActual());
		}else{
			empleado.setIdUsuarioModificacion(idUsuario);
			empleado.setFechaModificacion(util.fechaActual());
		}
		
		if(empleado.getEstado().equals("A")){
			empleado.setEstado("1");
		}else if(empleado.getEstado().equals("I")) {
			empleado.setEstado("0");
		}
		empleadoRepository.save(empleado);
		status.setComplete();
		return "redirect:/empleado/list";
	}
	
	@GetMapping("/empleado/delete")
	public ModelMap deleteConfirm(@RequestParam(value = "id", required = true) Empleado empleado, Model model) {
		return new ModelMap("empleado", empleado);
	}
	
	@PostMapping("/empleado/delete")
	public Object delete(@ModelAttribute Empleado empleado, SessionStatus status) {
		try {
			empleadoRepository.delete(empleado);
		} catch (DataIntegrityViolationException exception) {
			status.setComplete();
			return new ModelAndView("error/errorHapus").addObject("entityId", empleado.getIdEmpleado())
					.addObject("entityName", "Empleado").addObject("errorCause", exception.getRootCause().getMessage())
					.addObject("backLink", "/empleado/list");
		}
		status.setComplete();
		return "redirect:/empleado/list";
	}

	@ModelAttribute("menuItemsList")
	public List<MenuItem> menues(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username", ((Usuario) principal).getUsuario());
		int idUsuario=Integer.parseInt(String.valueOf(((Usuario) principal).getId()));
		return util.agruparMenus(menuRepository.getMenues(1, idUsuario));
	}
	
	@ModelAttribute("allArea")
	public List<Area> populateTiposDocumento() {
		return areaRepository.findAll();
	}
}