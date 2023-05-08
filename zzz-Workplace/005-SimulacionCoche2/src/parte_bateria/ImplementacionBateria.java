package parte_bateria;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.LaInterfazBateria;
import common.RuedaDelantera;



public class ImplementacionBateria extends UnicastRemoteObject implements LaInterfazBateria{

	private String id;
	private int porcentajeBateria;

	protected ImplementacionBateria() throws RemoteException {
		this.porcentajeBateria=100;
	}

	@Override
	public boolean descargarBateria() throws RemoteException{
		this.porcentajeBateria=this.porcentajeBateria-5;
		return true;
	}

	@Override
	public String porcentajeBateria() throws RemoteException{
		return ""+this.porcentajeBateria;
	}	
}
