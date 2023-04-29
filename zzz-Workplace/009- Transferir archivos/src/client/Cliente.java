package client;

import java.io.File;
import java.io.FileReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Compute;
import common.Tarea;
import server.ImplementacionTareas;


public class Cliente {
    public static void main(String args[]) {
        
        try {
        	String name = "TransferenciaArchivos";
   
    		File file=new File(".\\src\\client\\origen.txt");
    		FileReader reader=new FileReader(file);
    		
    		StringBuilder contenido=new StringBuilder();
	        int valor=reader.read();
            while(valor!=-1){
            	contenido.append((char)valor);
                valor=reader.read();
            }
    		
            System.out.println("Leido:  "+contenido);
            
            Registry registry = LocateRegistry.getRegistry(1099);
            
            Compute comp = (Compute) registry.lookup(name); 
            
            ImplementacionTareas tarea=new ImplementacionTareas(contenido.toString());
            
            boolean resultado=comp.ejecutar(tarea);
            
            if(resultado) {
            	System.out.println("Transferencia realizada correctamente");
            }
            else {
            	System.out.println("Error, la transferencia no se ha realizado");
            }
   
            
        } catch (Exception e) {
            System.out.println("Error no se ha podido leer el archivo");
        }
    }    
}
