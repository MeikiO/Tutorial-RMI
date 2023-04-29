package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Compute;
import common.Tarea;
import engine.ImplementacionTareas;


public class Cliente {
    public static void main(String args[]) {
        
        try {
            String name = "UrlServer";
            String urlSample="https://locallhost.com";
            Registry registry = LocateRegistry.getRegistry(1099);
            
            Compute comp = (Compute) registry.lookup(name); 
            
            Tarea tarea=comp.ejecutarTarea(urlSample);
            
            System.out.println(tarea.urlValido());
            System.out.println("HTML del url de arriba : \n "+tarea.darTodalaInformacionDelUrl());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
