package pe.com.datatech.asistencia.repository;


import pe.com.datatech.asistencia.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

	Usuario findByUsuario(String usuario);
}