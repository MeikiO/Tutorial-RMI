package common;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote { //para hacer remoto un objeto siempre tiene que implementar Remote
    String sayHello() throws RemoteException;
}
