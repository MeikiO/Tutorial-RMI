package servidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.Calculadora;

public class CalculadoraImp extends UnicastRemoteObject implements Calculadora{

	protected CalculadoraImp() throws RemoteException {}

	@Override
	public int sumar(int n1, int n2) throws RemoteException {
		return n1+n2;
	}

	@Override
	public int restar(int n1, int n2) throws RemoteException {
		return n1-n2;
	}

	@Override
	public int multiplicar(int n1, int n2) throws RemoteException {
		return n1*n2;
	}

	@Override
	public double dividir(int n1, int n2) throws RemoteException {
		return n1/n2;
	}
	
}
