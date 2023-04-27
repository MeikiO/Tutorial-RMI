package client;

import java.io.Serializable;

import common.Tareas;

public class ImplementacionTareas implements Tareas, Serializable {

	@Override
	public String saludar(String nombre) {
		return "Saludos "+nombre;
	}

}
