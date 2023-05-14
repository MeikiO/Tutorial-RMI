package server;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.Hello;
        
public class Server { 
    public Server() {}

    public static void main(String args[]) {
        
        try {
        	
           	if(System.getSecurityManager()==null) {
           		System.setProperty("java.rmi.server.useCodebaseOnly", "False"); //habilitamos la descarga remota
        		//decimos que security policy implementamos
           		System.setProperty("java.security.policy", "file:C:\\Users\\Lenovo\\Documents\\GitHub\\PBL\\zzz-Workplace\\010-Security hello world Example\\example_SecurityPolicy.policy");
        		System.setSecurityManager(new RMISecurityManager());
        	}
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
