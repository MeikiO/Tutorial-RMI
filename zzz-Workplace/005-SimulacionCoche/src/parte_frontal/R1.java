package parte_frontal;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class R1{

	public R1() {
	}
	
	public static void main(String[] args) {
		try {
        	ImplementacionRuedaDelantera obj = new ImplementacionRuedaDelantera("R1"); 

        	Registry registry = LocateRegistry.createRegistry(1091); 

        	registry.bind("direccion1", obj); 

            System.err.println("Server ready");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
	}
}