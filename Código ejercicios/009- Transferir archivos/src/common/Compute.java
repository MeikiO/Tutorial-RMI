package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Compute extends Remote {
	public boolean ejecutar(byte[] bs) throws RemoteException;
}
