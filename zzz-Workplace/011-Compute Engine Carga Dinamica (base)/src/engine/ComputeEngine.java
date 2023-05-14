package engine;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import compute.Compute;
import compute.Task;

public class ComputeEngine extends UnicastRemoteObject implements Compute {

    public ComputeEngine() throws RemoteException {} {
        //super();
    }

    public <T> T executeTask(Task<T> t) {
        return t.execute();
    }

    public static void main(String[] args) {
        
        try {
        	
        	if(System.getSecurityManager()==null) {
        		System.setProperty("java.rmi.server.useCodebaseOnly", "False"); //habilitamos la descarga remota
        		System.setProperty("java.security.policy", "file:C:\\Users\\Lenovo\\Documents\\GitHub\\PBL\\zzz-Workplace\\011-Compute Engine Carga Dinamica (base)\\src\\MySecurityPolicy.policy");
        		System.setSecurityManager(new RMISecurityManager());
        	}
        	
            String name = "Compute";
            Compute obj = new ComputeEngine();
            //Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
            //Registry registry = LocateRegistry.getRegistry();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind(name, obj);
            System.out.println("ComputeEngine bound");
            
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}