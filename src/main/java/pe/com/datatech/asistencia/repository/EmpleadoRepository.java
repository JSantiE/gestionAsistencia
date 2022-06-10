package pe.com.datatech.asistencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.datatech.asistencia.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

}
