package parte_bateria;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Bateria{

	public Bateria() {
	}
	
	public static void main(String[] args) {

		try {
        	
        	ImplementacionBateria obj = new ImplementacionBateria(); 

        	Registry registry = LocateRegistry.createRegistry(1095); 

        	registry.bind("bateria", obj); 

            System.err.println("Server ready");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
	}
}