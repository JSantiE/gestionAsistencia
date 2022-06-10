package pe.com.datatech.asistencia.web.controller;

import java.util.List;

import pe.com.datatech.asistencia.dto.MenuItem;
import pe.com.datatech.asistencia.entity.Usuario;
import pe.com.datatech.asistencia.repository.MenuRepository;
import pe.com.datatech.asistencia.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {


	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private Util util;

    @GetMapping("/")
    public String homePage(ModelMap model){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("username", ((Usuario)principal).getUsuario());
		return "home";
    }

	@ModelAttribute("menuItemsList")
	public List<MenuItem> menues() {
		return util.agruparMenus(menuRepository.getMenues(1,1));
	}


}
