package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import common.Verificador;
import common.Condicion;

public class Server extends UnicastRemoteObject implements Verificador{
    protected Server() throws RemoteException {
		super();
	}

	public static void main(String[] args) {
        try {
        	String name = "UrlServer";

        	Registry registry = LocateRegistry.createRegistry(1099);
        	
        	Server obj=new Server();
        	
        	registry.rebind(name, obj); 
        	
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