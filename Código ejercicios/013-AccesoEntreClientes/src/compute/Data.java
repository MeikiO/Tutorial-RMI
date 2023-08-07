package compute;

import java.rmi.RemoteException;

import cliente_datos.Persona;

public interface Data<T> {
    Persona giveData() throws RemoteException;
}
