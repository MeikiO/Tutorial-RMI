package commons;

import java.rmi.Remote;
import java.rmi.RemoteException;

public  interface HacerPedidos extends Remote {
  boolean hacerPedido(Pedido pedido) throws RemoteException;
}
