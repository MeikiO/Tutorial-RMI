package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import common.Tareas;
import common.Compute;




public class Server extends UnicastRemoteObject implements Compute{

    private final String nombre="UNAI";
    


	public Server() throws RemoteException {} {
    }


    public static void main(String[] args) {
        
        try {
        	String name = "Saludador";

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
	public String ejecutar(Tareas t) throws RemoteException {
		return t.saludar(this.nombre);
	}


}