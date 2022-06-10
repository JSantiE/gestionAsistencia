package pe.com.datatech.asistencia.dto;

public class Menu {

	private Integer idMenu;
	private String codMenu;
	private Integer idMenuPadre;
	private String Descripcion;
	private String url;

	public Integer getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	public String getCodMenu() {
		return codMenu;
	}

	public void setCodMenu(String codMenu) {
		this.codMenu = codMenu;
	}

	public Integer getIdMenuPadre() {
		return idMenuPadre;
	}

	public void setIdMenuPadre(Integer idMenuPadre) {
		this.idMenuPadre = idMenuPadre;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
