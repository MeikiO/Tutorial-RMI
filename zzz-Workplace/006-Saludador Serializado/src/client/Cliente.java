package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Compute;


public class Cliente {
    public static void main(String args[]) {
        
        try {
            String name = "Saludador";
            Registry registry = LocateRegistry.getRegistry(1099);
            
            Compute comp = (Compute) registry.lookup(name); //usamos la interfaz para tomar el objeto del servidor
            								//como la interfaz en Serializable, todos los objetos que son creados
            								// con clases que llevan implemetado Saludo , son serializables.
            
            ImplementacionTareas tarea =new ImplementacionTareas();
            String s = (String) comp.ejecutar(tarea);
            System.out.println(s);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
}
