package client;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Hello;

public class Client {

    private Client() {}

    public static void main(String[] args) {
        try {
            
        	//accedemos al servidor de nombres a traves del puerto
        	Registry registry = LocateRegistry.getRegistry("192.168.47.109",1099);
        	
        	System.out.println("He encontrado el registry");
        	
            Hello stub = (Hello) registry.lookup("Hello"); //tomamos el objeto con la identificacion que se ha puesto
            
            System.out.println("he encontrado el servidor");
            
            String response = stub.sayHello(); //hacemos la invocacion remota, ejecutamos la funcion y esperamos la respuesta
            
            System.out.println("response: " + response);
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}