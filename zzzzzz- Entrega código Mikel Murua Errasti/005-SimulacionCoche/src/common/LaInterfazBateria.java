package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LaInterfazBateria extends Remote { 
	boolean descargarBateria() throws RemoteException;
	String porcentajeBateria() throws RemoteException;
}
