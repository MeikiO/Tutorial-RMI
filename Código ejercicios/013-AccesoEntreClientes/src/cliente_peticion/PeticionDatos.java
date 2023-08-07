package cliente_peticion;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import cliente_datos.Persona;
import compute.Compute;

public class PeticionDatos {
    public static void main(String args[]) {  
        try {
           	if(System.getSecurityManager()==null) {
           		System.setProperty("java.rmi.server.useCodebaseOnly", "False");
          		System.setProperty("java.security.policy", "file:C:\\Users\\Lenovo\\Documents\\GitHub\\PBL\\zzz-Workplace\\013-AccesoEntreClientes\\src\\MySecurityPolicy.policy");
        		System.setSecurityManager(new RMISecurityManager());
        	}
        	
        	String name = "Compute";
            Integer pi_decimals = 10;
            
            Registry registry = LocateRegistry.getRegistry(1099);
            Compute comp = (Compute) registry.lookup(name);
            DataExtractor task = new DataExtractor();
           
            Persona pi = comp.executeTask(task);
            
            System.out.println(pi.toString());
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }    
}
