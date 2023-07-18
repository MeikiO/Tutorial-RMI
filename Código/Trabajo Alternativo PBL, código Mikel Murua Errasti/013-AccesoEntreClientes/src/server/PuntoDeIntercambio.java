package server;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import cliente_datos.Baul;
import cliente_datos.Persona;
import compute.Compute;
import compute.Task;

public class PuntoDeIntercambio extends UnicastRemoteObject implements Compute {

    private Baul data;

	public PuntoDeIntercambio() throws RemoteException {} {
    }

	@Override
	public void extractData(Baul task) throws RemoteException{
		this.data=task;
	}
    
    public Persona executeTask(Task t)throws RemoteException {

    	return t.execute(this.data);
    }

    public static void main(String[] args) {
        try {
        	if(System.getSecurityManager()==null) {
        		System.setProperty("java.rmi.server.useCodebaseOnly", "False");
        		System.setProperty("java.security.policy", "file:C:\\Users\\Lenovo\\Documents\\GitHub\\PBL\\zzz-Workplace\\013-AccesoEntreClientes\\src\\MySecurityPolicy.policy");
        		System.setSecurityManager(new RMISecurityManager());
        	}
        	
            String name = "Compute";
            Compute obj = new PuntoDeIntercambio();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind(name, obj);
            
            System.out.println("ComputeEngine bound");
            
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}