package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.ImplementacionTareas;


public interface Compute extends Remote {
	String ejecutar(ImplementacionTareas tarea) throws RemoteException;
}