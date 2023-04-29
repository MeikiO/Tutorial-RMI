package common;

public enum Condicion {
	Ok("Url valido"),
	No("Url no valido");
	
	private String mensaje;

	Condicion(String string) {
		this.mensaje=string;
	}

	public String getMensaje() {
		return mensaje;
	}
}
