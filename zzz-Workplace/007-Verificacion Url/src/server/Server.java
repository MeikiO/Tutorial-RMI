package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;


import common.Compute;
import common.Condicion;




public class Server extends UnicastRemoteObject implements Compute{


    protected Server() throws RemoteException {
		super();
	}

	public static void main(String[] args) {
        
        try {
        	String name = "UrlServer";
            
          //creamos el servidor de nombre
        	Registry registry = LocateRegistry.createRegistry(1099); //establecemos el numero de puerto del servidor de nombre
        	
        	Server obj=new Server();
        	
        	registry.rebind(name, obj); //le ponemos un identificador al objeto, lo guardamos en el servidor de nombres.
        								//rebind es directamente para guardar el objeto
            System.err.println("Server ready");
            
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }

	@Override
	public String ejecutar(String urlSample) throws RemoteException{
		String mensaje="";
		
		GestorUrl gestor=new GestorUrl(urlSample);
		
		mensaje=gestor.urlValido();
		
		if(mensaje.equals(Condicion.Ok.getMensaje())) {
			mensaje=mensaje+"\n HTML completo de URL: \n"+gestor.darTodalaInformacionDelUrl();			
		}
		
		
		return mensaje;
	}







}