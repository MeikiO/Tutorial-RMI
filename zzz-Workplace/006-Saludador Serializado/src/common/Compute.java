package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;

public interface Compute extends Remote {
	String ejecutar(Tareas t) throws RemoteException;
}
