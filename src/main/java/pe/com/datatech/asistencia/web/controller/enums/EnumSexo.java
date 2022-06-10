package pe.com.datatech.asistencia.web.controller.enums;

public enum EnumSexo {
	M("MASCULINO"),
	F("FEMENINO");

	private final String value;

	private EnumSexo(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
