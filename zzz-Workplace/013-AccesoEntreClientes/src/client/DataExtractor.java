package client;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.RemoteException;

import clienteDatos.Persona;
import compute.Data;
import compute.Task;

public class DataExtractor implements Task<BigDecimal>, Serializable {

    private static final long serialVersionUID = 227L;


	@Override
	public Persona execute(Data d) throws RemoteException{
		System.out.println("Usind personas data: "+d);
		return  d.giveData();
	}
}
