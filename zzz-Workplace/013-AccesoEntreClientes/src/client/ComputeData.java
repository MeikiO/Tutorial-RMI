package client;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import clienteDatos.Persona;
import compute.Compute;

import java.math.BigDecimal;

public class ComputeData {
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
            DataExtractor task = new DataExtractor();
           
            Persona pi = comp.executeTask(task);
            
            System.out.println(pi.toString());
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }    
}
