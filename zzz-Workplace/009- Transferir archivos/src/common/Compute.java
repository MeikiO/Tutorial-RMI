package common;

import java.io.FileInputStream;
import java.io.FileReader;
import java.rmi.Remote;
import java.rmi.RemoteException;

import server.GestorArchivos;

public interface Compute extends Remote {
	public boolean ejecutar(byte[] bs) throws RemoteException;
}
