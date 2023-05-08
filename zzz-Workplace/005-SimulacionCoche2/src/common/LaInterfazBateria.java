package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LaInterfazBateria extends Remote { //para hacer remoto un objeto siempre tiene que implementar Remote
	boolean descargarBateria() throws RemoteException;
	String porcentajeBateria() throws RemoteException;
}
