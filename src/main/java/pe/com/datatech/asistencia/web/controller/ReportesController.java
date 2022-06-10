package pe.com.datatech.asistencia.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.com.datatech.asistencia.dto.MenuItem;
import pe.com.datatech.asistencia.repository.MenuRepository;
import pe.com.datatech.asistencia.util.Util;


@Controller
public class ReportesController {

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private Util util;

	@RequestMapping("/reportes/error")
	public String returnViewName() throws Exception {
		throw new Exception();
	}

	@ModelAttribute("menuItemsList")
	public List<MenuItem> menues() {
		return util.agruparMenus(menuRepository.getMenues(1,1));
	}


}
