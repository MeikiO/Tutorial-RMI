package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RemoteObject;

public interface Compute extends Remote {
	Object ejecutarTarea(Tareas t) throws RemoteException;
}
