package server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.Hello;

public class HelloImpl extends UnicastRemoteObject implements Hello {
    
	//extiende UnicastRemoteObject para ser transferible
	
	public HelloImpl() throws RemoteException {}

    public String sayHello() throws RemoteException {
        return "Hello World!";
    }
}