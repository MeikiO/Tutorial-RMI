package parte_bateria;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import common.LaInterfazBateria;

public class ImplementacionBateria extends UnicastRemoteObject implements LaInterfazBateria{

	private int porcentajeBateria;

	protected ImplementacionBateria() throws RemoteException {
		this.porcentajeBateria=100;
	}

	@Override
	public boolean descargarBateria() throws RemoteException{
		this.porcentajeBateria=this.porcentajeBateria-5;
		System.out.println("bateria consumida, porcentajeActual: "+this.porcentajeBateria);
		return true;
	}

	@Override
	public String porcentajeBateria() throws RemoteException{
		return ""+this.porcentajeBateria;
	}	
}
