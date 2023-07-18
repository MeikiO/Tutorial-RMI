package cliente_peticion;

import java.io.Serializable;
import java.math.BigDecimal;
import java.rmi.RemoteException;

import cliente_datos.Persona;
import compute.Data;
import compute.Task;

public class DataExtractor implements Task<BigDecimal>, Serializable {

	@Override
	public Persona execute(Data d) throws RemoteException{
		System.out.println("Usind personas data: "+d);
		return  d.giveData();
	}
}
