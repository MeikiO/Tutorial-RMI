package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.Compute;



public class Cliente {
    public static void main(String args[]) {
        
    	Cliente programa=new Cliente();
    	
        try {
        	String name = "CalculadorMedia";
        	
            Registry registry = LocateRegistry.getRegistry(1099);
            
            Compute comp = (Compute) registry.lookup(name); 
            
            List<Double> listaNotas=programa.introducirNotas();
            
            Double resultado=comp.ejecutar(listaNotas);
            
            System.out.println("La media de las asignaturas es: "+resultado);
              
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	private List<Double> introducirNotas() {
		
		Scanner teclado=new Scanner(System.in);
		List<Double> notas=new ArrayList<>();
		
		String[] asignaturas= {"WebII","Seguridad","S.Concurrentes y distribuidos","Inteligencia artificial","Informazio sistema"};
		
		for(int i=0;i<asignaturas.length;i++) {
			System.out.println(asignaturas[i]+" :");
			Double notaAsignatura=teclado.nextDouble();
			notas.add(notaAsignatura);
		}
		
		return notas;
	}    
}
