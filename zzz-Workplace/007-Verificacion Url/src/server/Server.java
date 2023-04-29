package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import common.Tarea;
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
	public String ejecutar(ImplementacionTareas tarea) throws RemoteException {
		String mensaje="";
		
		mensaje=tarea.urlValido();
		
		if(mensaje.equals(Condicion.Ok.getMensaje())) {
			mensaje=mensaje+"\n HTML completo de URL: \n"+tarea.darTodalaInformacionDelUrl();			
		}
		
		
		return mensaje;
	}



    




}