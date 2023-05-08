package parte_trasera;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class R4{

	public R4() {
	}
	
	public static void main(String[] args) {

		try {
        	
        	ImplementacionRuedaTrasera obj = new ImplementacionRuedaTrasera("R4"); 

        	Registry registry = LocateRegistry.createRegistry(1094); 

        	registry.bind("motor4", obj); 

            System.err.println("Server ready");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
	}
}