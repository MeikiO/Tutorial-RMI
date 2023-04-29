package common;

import java.io.FileReader;
import java.rmi.Remote;
import java.rmi.RemoteException;

import server.ImplementacionTareas;

public interface Compute extends Remote {
	public boolean ejecutar(ImplementacionTareas tarea) throws RemoteException;
}
