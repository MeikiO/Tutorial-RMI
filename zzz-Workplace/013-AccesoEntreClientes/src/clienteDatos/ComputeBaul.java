package clienteDatos;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import compute.Compute;

import java.math.BigDecimal;

public class ComputeBaul {
    public static void main(String args[]) {
        
        try {
           	if(System.getSecurityManager()==null) {
          		System.setProperty("java.security.policy", "file:C:\\Users\\Lenovo\\Documents\\GitHub\\PBL\\zzz-Workplace\\013-AccesoEntreClientes\\src\\MySecurityPolicy.policy");
        		System.setSecurityManager(new RMISecurityManager());
        	}
        	
        	String name = "Compute";
            Integer pi_decimals = 10;
            
            Registry registry = LocateRegistry.getRegistry(1099);
            Compute comp = (Compute) registry.lookup(name);
            
            Persona personaExpuesta=new Persona(1,"Foo", 125);
            
            Baul task = new Baul(personaExpuesta);
            
            comp.extractData(task);
            

        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }    
}
