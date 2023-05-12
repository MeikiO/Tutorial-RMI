package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

import client.Pi;
import clienteDatos.Baul;
import clienteDatos.Persona;

public interface Compute extends Remote {
    Persona executeTask(Task task) throws RemoteException;

	void extractData(Baul task) throws RemoteException;
}
