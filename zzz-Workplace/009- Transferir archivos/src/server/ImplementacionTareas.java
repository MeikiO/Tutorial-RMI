package server;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import common.Tarea;

public class ImplementacionTareas implements Tarea, Serializable {

	private String contenidoAtransferir;

	public ImplementacionTareas(String string) {
		this.contenidoAtransferir=string;
	}
	

	@Override
	public boolean TransferirArchivo() {
		boolean condicion=true;
		int valor;
	
		try {
			FileWriter writter = new FileWriter(".\\src\\server\\destino.txt");  
			
			writter.write(contenidoAtransferir);
          
			writter.close();

		} catch (IOException e) {
			condicion=false;
		}
		
		return condicion;
	
	}
	
}
