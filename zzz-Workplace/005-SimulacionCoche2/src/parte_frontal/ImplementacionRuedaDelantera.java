package parte_frontal;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.LaInterfazBateria;
import common.RuedaDelantera;



public class ImplementacionRuedaDelantera extends UnicastRemoteObject implements RuedaDelantera{

	private String id;

	protected ImplementacionRuedaDelantera(String id) throws RemoteException {
		this.id=id;
	}

	@Override
	public String girar(int direccion) throws RemoteException { 
		String mensaje="";
		
		if(direccion==1) {
			mensaje=id+" va hacia la derecha";
		}
		if(direccion==2) {
			mensaje=id+" va hacia la izquierda";
		}
		
		System.out.println(mensaje);
		return mensaje;
	}

	@Override
	public String parar() throws RemoteException {
		System.out.println(id+" se ha parado");
		return id+" se ha parado";
	}


	
	
}
