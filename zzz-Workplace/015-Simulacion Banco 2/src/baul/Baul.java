package baul;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import compute.Compute;
import compute.Task;

public class Baul extends UnicastRemoteObject implements Compute {

    private final static int NUMPUERTO=1092;
    private final static String NOMBRESERVER="Baul";
	private GestorBaul gestorBaul;
	
    public Baul() throws RemoteException {} {
    	this.gestorBaul=new GestorBaul();
    }

    public <T> T executeTask(Task<T> t) {
        return (T) this.gestorBaul.procesarPeticion(t.recibirOrden().toString());
    }

    public static void main(String[] args) {
        
        try {
        	
        	if(System.getSecurityManager()==null) {
        		System.setProperty("java.rmi.server.useCodebaseOnly", "False"); //habilitamos la descarga remota
        		System.setProperty("java.security.policy", "file:C:\\Users\\Lenovo\\Documents\\GitHub\\PBL\\zzz-Workplace\\011-Compute Engine Carga Dinamica (base)\\src\\MySecurityPolicy.policy");
        		System.setSecurityManager(new RMISecurityManager());
        	}

            Compute obj = new Baul();

            Registry registry = LocateRegistry.createRegistry(NUMPUERTO);
            registry.rebind(NOMBRESERVER, obj);
            System.out.println("Baul de datos operativo");
           
        } catch (Exception e) {
            System.err.println("se cierra por motivos de seguridad");
            e.printStackTrace();
        }
    }
}