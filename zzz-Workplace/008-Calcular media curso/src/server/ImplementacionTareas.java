package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import common.Tarea;

public class ImplementacionTareas implements Tarea, Serializable {

	
	private List<Double> listaNotas;

	public ImplementacionTareas(List<Double> listaNotas) {
		this.listaNotas=listaNotas;
	}
	
	@Override
	public Double  calculaLaMedia() {
		Double sumaTotal=this.listaNotas.stream().reduce(Double::sum).get();
		return (sumaTotal/this.listaNotas.size());
	}

}
