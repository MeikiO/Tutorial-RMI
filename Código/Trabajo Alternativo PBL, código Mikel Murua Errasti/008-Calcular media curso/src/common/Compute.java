package common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Compute extends Remote {
	public Double  ejecutar(List<Double> listaNotas) throws RemoteException;
}
