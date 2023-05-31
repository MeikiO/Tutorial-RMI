package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

import cliente_datos.Baul;
import cliente_datos.Persona;

public interface Compute extends Remote {
    Persona executeTask(Task task) throws RemoteException;

	void extractData(Baul task) throws RemoteException;
}
