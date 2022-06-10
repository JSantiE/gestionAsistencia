package pe.com.datatech.asistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Entity
@Table(name = "Rol")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Integer Id;

	@Column(name = "Rol")
	private String nombreRole;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombreRole() {
		return nombreRole;
	}

	public void setNombreRole(String nombreRole) {
		this.nombreRole = nombreRole;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
