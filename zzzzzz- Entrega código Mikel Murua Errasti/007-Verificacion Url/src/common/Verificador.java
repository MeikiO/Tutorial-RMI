package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Verificador extends Remote {
	public String ejecutar(String urlSample) throws RemoteException;
}
