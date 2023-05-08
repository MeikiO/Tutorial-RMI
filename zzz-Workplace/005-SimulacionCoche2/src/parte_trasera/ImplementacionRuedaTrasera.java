package parte_trasera;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.LaInterfazBateria;
import common.RuedaDelantera;
import common.RuedaTrasera;



public class ImplementacionRuedaTrasera extends UnicastRemoteObject implements RuedaTrasera{


	private String id;

	protected ImplementacionRuedaTrasera(String id) throws RemoteException {
		this.id=id;
	}


	@Override
	public String adelante() throws RemoteException {
		System.out.println(id+" va hacia delante");
		return id+" va hacia delante";
	}

	@Override
	public String atras() throws RemoteException {
		System.out.println(id+" va hacia atras");
		return id+" va hacia atras";
	}
	

	@Override
	public String parar() {
		System.out.println(id+" se ha parado");
		return id+" se ha parado";
	}


	
	
}
