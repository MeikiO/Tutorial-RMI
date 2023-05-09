package parte_trasera;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class R3{

	public R3() {
	}
	
	public static void main(String[] args) {

		try {
        	
        	ImplementacionRuedaTrasera obj = new ImplementacionRuedaTrasera("R3"); 

        	Registry registry = LocateRegistry.createRegistry(1093); 

        	registry.bind("motor3", obj); 

            System.err.println("Server ready");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
	}
}