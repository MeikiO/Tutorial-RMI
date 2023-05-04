package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.ImplementacionTareas;


public interface Compute extends Remote {
	String ejecutar(ImplementacionTareas tarea) throws RemoteException;
}
