package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Compute;
import common.Tarea;
import server.ImplementacionTareas;


public class Cliente {
    public static void main(String args[]) {
        
        try {
            String name = "UrlServer";
            String urlSample="h";
            Registry registry = LocateRegistry.getRegistry(1099);
            
            Compute comp = (Compute) registry.lookup(name); 
            
            ImplementacionTareas tarea=new ImplementacionTareas(urlSample);
            
            String resultado=comp.ejecutar(tarea);
            
            System.out.println(resultado);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
