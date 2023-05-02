package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import compute.Compute;

import java.math.BigDecimal;

public class ComputePi {
    public static void main(String args[]) {
        
        try {
            String name = "Compute";
            Integer pi_decimals = 10;
            
            Registry registry = LocateRegistry.getRegistry(1099);
            Compute comp = (Compute) registry.lookup(name);
            Pi task = new Pi(pi_decimals);
            BigDecimal pi = comp.executeTask(task);
            System.out.println(pi);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }    
}
