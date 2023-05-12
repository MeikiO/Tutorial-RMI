package compute;

import java.rmi.RemoteException;

import clienteDatos.Persona;

public interface Task<T> {
    Persona execute(Data d) throws RemoteException;
}
