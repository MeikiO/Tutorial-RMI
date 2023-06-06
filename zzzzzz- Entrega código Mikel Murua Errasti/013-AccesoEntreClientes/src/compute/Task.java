package compute;

import java.rmi.RemoteException;

import cliente_datos.Persona;

public interface Task<T> {
    Persona execute(Data d) throws RemoteException;
}
