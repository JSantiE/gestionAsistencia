package pe.com.datatech.asistencia.entity;

import java.io.Serializable;

import javax.persistence.*;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Entity
@Table(name = "Menu")
@NamedQueries({ @NamedQuery(name = "Menu.findAll", query = "SELECT t FROM Menu t") })
public class Menu implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "CodMenu")
	private String codMenu;
	@Column(name = "Menu")
	private String descripcion;
	@Column(name = "Controller")
	private String controller;
	@Column(name = "FlagActivo")
	private Integer estado;

	public Menu() {
	}

	public Menu(String codMenu) {
		this.codMenu = codMenu;
	}

	public String getCodMenu() {
		return codMenu;
	}

	public void setCodMenu(String codMenu) {
		this.codMenu = codMenu;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (codMenu != null ? codMenu.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {

		if (!(object instanceof Menu)) {
			return false;
		}
		Menu other = (Menu) object;
		if ((this.codMenu == null && other.codMenu != null)
				|| (this.codMenu != null && !this.codMenu.equals(other.codMenu))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}

}
