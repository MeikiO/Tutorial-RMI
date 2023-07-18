package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RuedaDelantera extends Remote { 
	String girar(int direccion) throws RemoteException;
	String parar() throws RemoteException;
}
