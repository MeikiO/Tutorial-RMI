package parte_frontal;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class R2{

	public R2() {
	}
	
	public static void main(String[] args) {

		try {
        	
        	ImplementacionRuedaDelantera obj = new ImplementacionRuedaDelantera("R2"); 

        	Registry registry = LocateRegistry.createRegistry(1092); 

        	registry.bind("direccion2", obj); 

            System.err.println("Server ready");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
	}
}