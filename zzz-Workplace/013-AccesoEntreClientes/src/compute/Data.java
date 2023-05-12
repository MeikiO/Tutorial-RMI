package compute;

import java.rmi.RemoteException;

import clienteDatos.Persona;

public interface Data<T> {
    Persona giveData() throws RemoteException;
}
