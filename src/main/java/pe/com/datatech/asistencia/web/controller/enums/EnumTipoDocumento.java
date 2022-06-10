package pe.com.datatech.asistencia.web.controller.enums;

public enum EnumTipoDocumento {
		DNI("DNI"),
		CE("CARNET EXTRANJERIA"),
		PAS("PASAPORTE"),
		RUC("RUC");
	
		private final String value;

		private EnumTipoDocumento(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
}
