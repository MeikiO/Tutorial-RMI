package server;

import java.io.FileReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import common.Tarea;
import common.Compute;





public class Server extends UnicastRemoteObject implements Compute{


    protected Server() throws RemoteException {
		super();
	}

	public static void main(String[] args) {
        
        try {
        	String name = "TransferenciaArchivos";
            
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
	public boolean ejecutar(ImplementacionTareas tarea) throws RemoteException {
		boolean condicion=tarea.TransferirArchivo();
		return condicion ;
	}



}