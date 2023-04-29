package servidor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Calculadora;


public class Servidor{

	public Servidor() {
	}
	
	public static void main(String[] args) {

		try {
        	
        	CalculadoraImp obj = new CalculadoraImp(); 

        	Registry registry = LocateRegistry.createRegistry(1099); 

        	registry.bind("Operaciones", obj); 

            System.err.println("Server ready");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
	}
}