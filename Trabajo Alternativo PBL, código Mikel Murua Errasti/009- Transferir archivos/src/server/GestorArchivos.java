package server;

import java.io.FileWriter;
import java.io.IOException;

public class GestorArchivos{
	
	private String mensaje;

	public GestorArchivos(String mensaje) {
		this.mensaje=mensaje;
	}
	
	public boolean TransferirArchivo() {
		boolean condicion=true;
		int valor;
			
		try {
			FileWriter writter = new FileWriter(".\\src\\server\\destino.txt");  
			
			writter.write(this.mensaje);
          
			writter.close();

		} catch (IOException e) {
			condicion=false;
		}
	
		return condicion;
	}
}
