package pe.com.datatech.asistencia.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import pe.com.datatech.asistencia.dto.Menu;
import pe.com.datatech.asistencia.dto.MenuItem;

@Component
public class Util {

	public List<MenuItem> agruparMenus(List<Menu> menues) {
		// String grupoMenus = getGrupoMenusDeUsuario();
		List<MenuItem> menuItems = new ArrayList<>();
		Integer parentId = 0;
		MenuItem menuItemPadre = new MenuItem();
		List<MenuItem> hijos = new ArrayList<>();

		for (Menu menu : menues) {
			if (menu.getIdMenuPadre() > 0) {
				if (parentId != menu.getIdMenuPadre()) {
					hijos = new ArrayList<>();
					menuItemPadre = new MenuItem(menu.getDescripcion(), hijos);
					parentId = menu.getIdMenu();
					menuItems.add(menuItemPadre);
				} else {
					MenuItem menuItemHijo = new MenuItem();
					menuItemHijo.setName(menu.getDescripcion());
					menuItemHijo.setUrl(menu.getUrl());
					menuItemHijo.setParent(menuItemPadre);
					menuItemPadre.getChildren().add(menuItemHijo);
				}
			}
		}
		return menuItems;
	}

	public Date fechaActual() {
		Date fecha = new Date();
		return fecha;
	}
}
