package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import server.ImplementacionTareas;


public interface Compute extends Remote {
	Double ejecutar(ImplementacionTareas tarea) throws RemoteException;
}
