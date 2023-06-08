package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Verificador;

public class Cliente {
	
    public static void main(String args[]) {     
        try {
            String name = "UrlServer";
            String urlSample="https://docs.oracle.com/javase/tutorial/security/userperm/index.html";
            Registry registry = LocateRegistry.getRegistry(1099);
            
            Verificador comp = (Verificador) registry.lookup(name); 
            
            String resultado=comp.ejecutar(urlSample);
            
            System.out.println(resultado);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
