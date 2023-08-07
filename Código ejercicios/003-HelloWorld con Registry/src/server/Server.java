package server;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server { 
    public Server() {}

    public static void main(String args[]) {
        try {
        	HelloImpl obj = new HelloImpl(); // Inicializamos la clase que implementa el common y extends UnicastRemoteObject 
            
        	//creamos el servidor de nombre
        	Registry registry = LocateRegistry.createRegistry(1099); //establecemos el numero de puerto del servidor de nombre
            
        	registry.bind("Hello", obj); //le ponemos un identificador al objeto, lo guardamos en el servidor de nombres.

            System.err.println("Server ready");
            
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
