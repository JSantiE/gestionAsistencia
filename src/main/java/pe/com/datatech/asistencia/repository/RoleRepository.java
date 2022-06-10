package pe.com.datatech.asistencia.repository;


import pe.com.datatech.asistencia.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
