package pe.com.datatech.asistencia.authentication;

import java.util.Collection;


import pe.com.datatech.asistencia.core.authority.CustomUserAuthorityUtils;
import pe.com.datatech.asistencia.entity.Usuario;
import pe.com.datatech.asistencia.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


public class CustomUserAuthenticationProvider implements AuthenticationProvider {


	private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public CustomUserAuthenticationProvider(UsuarioRepository usuarioRepository,
			final PasswordEncoder passwordEncoder) {
		if (usuarioRepository == null) {
			throw new IllegalArgumentException("usuarioRepository cannot be null");
		}
		if (passwordEncoder == null) {
			throw new IllegalArgumentException("passwordEncoder cannot be null");
		}
		this.usuarioRepository=usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		String username = token.getName();
		Usuario user = username == null ? null : usuarioRepository.findByUsuario(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid username/password");
		}
		// Database Password already encrypted:
		String password = user.getClave();
		boolean passwordsMatch = false;
		//passwordEncoder.matches(token.getCredentials().toString(), password);
		if(password.equals(token.getCredentials().toString())) {
			passwordsMatch = true;
		}		

		if(!passwordsMatch) {
			throw new BadCredentialsException("Invalid username/password");
		}
		Collection<? extends GrantedAuthority> authorities = CustomUserAuthorityUtils.createAuthorities(user);

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, password, authorities);
		return usernamePasswordAuthenticationToken;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}
}