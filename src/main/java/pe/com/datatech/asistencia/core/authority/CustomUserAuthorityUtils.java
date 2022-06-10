package pe.com.datatech.asistencia.core.authority;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import pe.com.datatech.asistencia.entity.Usuario;
import pe.com.datatech.asistencia.entity.UsuarioMenu;


public class CustomUserAuthorityUtils {

	public static Collection<? extends GrantedAuthority> createAuthorities(Usuario usuario) {
		UsuarioMenu menus = usuario.getMenus();
		return AuthorityUtils.createAuthorityList(menus.toString());
	}

	private CustomUserAuthorityUtils() {
	}
}
