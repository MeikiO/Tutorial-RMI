package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Compute;


public class Cliente {
    public static void main(String args[]) {
        
        try {
            String name = "Saludador";
            Registry registry = LocateRegistry.getRegistry(1099);
            
            Compute comp = (Compute) registry.lookup(name); 
            Saludador tarea =new Saludador();
            String s = (String) comp.ejecutar(tarea);
            System.out.println(s);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
