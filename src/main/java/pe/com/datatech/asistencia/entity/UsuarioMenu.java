package pe.com.datatech.asistencia.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "UsuarioMenu")
@NamedQueries({ @NamedQuery(name = "UsuarioMenu.findAll", query = "SELECT t FROM UsuarioMenu t") })
public class UsuarioMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Basic(optional = false)
	@Column(name = "IdEmpresa")
	private Integer idEmpresa;

	@Column(name = "IdUsuario")
	private Integer idUsuario;

	@Column(name = "IdMenu")
	private Integer idMenu;

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

}
