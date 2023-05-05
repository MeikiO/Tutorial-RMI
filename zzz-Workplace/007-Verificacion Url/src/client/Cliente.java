package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Compute;


public class Cliente {
    public static void main(String args[]) {
        
        try {
            String name = "UrlServer";
            String urlSample="https://docs.oracle.com/javase/tutorial/security/userperm/index.html";
            Registry registry = LocateRegistry.getRegistry(1099);
            
            Compute comp = (Compute) registry.lookup(name); 
            
            
            String resultado=comp.ejecutar(urlSample);
            
            System.out.println(resultado);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
