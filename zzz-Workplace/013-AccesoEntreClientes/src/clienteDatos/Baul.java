package clienteDatos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.RemoteException;

import compute.Data;
import compute.Task;

public class Baul implements Data<Integer>, Serializable {

    private static final long serialVersionUID = 227L;
	private Persona persona;

	public Baul(Persona personaExpuesta) {
		this.persona=personaExpuesta;
	}


	@Override
	public Persona giveData() throws RemoteException{
		// TODO Auto-generated method stub
		return persona;
	}

}
