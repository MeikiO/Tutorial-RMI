package client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Compute;



public class Cliente {
    public static void main(String args[]) {
        
        try {
        	Cliente programa=new Cliente();
        	
        	String contenido=programa.leerContenidoArchivo(".\\src\\client\\origen.txt");
        	  
        	System.out.println("Leido:  "+contenido);
        	
        	
        	String name = "TransferenciaArchivos";
        	  
            Registry registry = LocateRegistry.getRegistry(1099);
            
            Compute comp = (Compute) registry.lookup(name); 
            
            boolean resultado=comp.ejecutar(contenido.getBytes());
            
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
    
    public String leerContenidoArchivo(String path) {
    	
		StringBuilder contenido=new StringBuilder();
		
    	try {
	    	File file=new File(".\\src\\client\\origen.txt");
			FileReader reader;
			
			reader = new FileReader(file);
			
	        int valor=reader.read();
	        while(valor!=-1){
	        	contenido.append((char)valor);
	            valor=reader.read();
	        }
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        return contenido.toString();
    }
    
}
