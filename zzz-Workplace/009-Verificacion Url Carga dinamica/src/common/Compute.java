package common;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Compute extends Remote {
	Tarea ejecutarTarea(String urlSample) throws RemoteException;
}
