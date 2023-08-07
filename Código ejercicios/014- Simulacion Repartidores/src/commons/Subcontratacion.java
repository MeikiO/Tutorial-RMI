package commons;

import java.rmi.Remote;
import java.rmi.RemoteException;

public  interface Subcontratacion extends Remote {
   boolean subcontratarReparto(Pedido pedido) throws RemoteException;
}
