package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculadora extends Remote {
	int sumar(int n1,int n2) throws RemoteException;
	int restar(int n1,int n2) throws RemoteException;
	int multiplicar(int n1,int n2) throws RemoteException;
	double dividir(int n1,int n2) throws RemoteException;
}
