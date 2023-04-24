package server;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
        
public class Server { 
    public Server() {}

    public static void main(String args[]) {
        
        try {
        	HelloImpl obj = new HelloImpl();
            // Bind the remote object's obj in the registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("Hello", obj);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
