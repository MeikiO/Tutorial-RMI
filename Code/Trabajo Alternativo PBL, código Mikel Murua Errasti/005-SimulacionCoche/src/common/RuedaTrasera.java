package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RuedaTrasera extends Remote { 
	String adelante() throws RemoteException;
	String atras() throws RemoteException;
	String parar() throws RemoteException;
}
