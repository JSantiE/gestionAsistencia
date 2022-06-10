package pe.com.datatech.asistencia.web.controller.enums;

public enum EnumTipoEstado {
	A("ACTIVO"),
	I("INACTIVO");

	private final String value;

	private EnumTipoEstado(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
