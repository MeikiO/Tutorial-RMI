package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote {
	String ejecutar(Tareas t) throws RemoteException;
}
