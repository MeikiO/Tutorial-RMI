package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import common.Compute;

public class Server extends UnicastRemoteObject implements Compute{


    protected Server() throws RemoteException {
		super();
	}

	public static void main(String[] args) {
        
        try {
        	String name = "CalculadorMedia";

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
	public Double  ejecutar(List<Double> listaNotas) throws RemoteException {
		Double sumaTotal=listaNotas.stream().reduce(Double::sum).get();
		return (sumaTotal/listaNotas.size());
	}





    




}