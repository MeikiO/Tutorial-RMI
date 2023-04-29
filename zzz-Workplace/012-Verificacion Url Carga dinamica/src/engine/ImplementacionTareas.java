package engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;

import common.Tarea;

public class ImplementacionTareas implements Tarea, Serializable {

	
	private String urlSample;

	public ImplementacionTareas(String UrlSample) {
		this.urlSample=UrlSample;
	}
	
	@Override
	public String urlValido() {
		
		String condicion="";
		
		try {
			URL url = new URL(this.urlSample);
			
			condicion="Url valido";

			
		} catch (MalformedURLException e) {
			condicion="El Url no es valido";
		}
		
		return condicion;
	}

	@Override
	public String darTodalaInformacionDelUrl() {
		String informacion="";
		
		try {
			URL url = new URL(this.urlSample);
			
			  // Volcamos lo recibido al buffer
			  BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			String inputLine="";
			while ((inputLine = in.readLine()) != null) {
				     informacion = informacion + inputLine;
			}
			
		} catch (MalformedURLException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return informacion;
	}


}
