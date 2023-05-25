package _002_banco;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import compute.Compute;
import compute.Task;

public class Banco extends UnicastRemoteObject implements Compute {

    private final static int NUMPUERTO=1091;
    private final static String NOMBRESERVER="Banco";
    
    private final static int NUMPUERTO_BAUL=1092;
    private final static String NOMBRESERVER_BAUL="Baul";
	private static Compute baul;
	
    public Banco() throws RemoteException {} {

    }

    public <T> T executeTask(Task<T> t) throws RemoteException {
    	System.out.println(t.recibirOrden().toString()); //hacemos el log printeando los comandos
        return baul.executeTask(t);
    }

    
    
    public static void main(String[] args) {
        
        try {
        	
        	if(System.getSecurityManager()==null) {
        		System.setProperty("java.rmi.server.useCodebaseOnly", "False"); //habilitamos la descarga remota
        		System.setProperty("java.security.policy", "file:C:\\Users\\Lenovo\\Documents\\GitHub\\PBL\\zzz-Workplace\\011-Compute Engine Carga Dinamica (base)\\src\\MySecurityPolicy.policy");
        		System.setSecurityManager(new RMISecurityManager());
        	}

            Compute obj = new Banco();

            Registry registry = LocateRegistry.createRegistry(NUMPUERTO);
            registry.rebind(NOMBRESERVER, obj);
            System.out.println("Banco abierto Log de movimientos realizados: \n\n");
            
           
            //aqui abrimos conexion con el Baul como cliente
            Registry registry_cliente = LocateRegistry.getRegistry(NUMPUERTO_BAUL);
            baul = (Compute) registry_cliente.lookup(NOMBRESERVER_BAUL);
            
            
        } catch (Exception e) {
            System.err.println("Banco exception, se cierra por motivos de seguridad");
            e.printStackTrace();
        }
    }
}