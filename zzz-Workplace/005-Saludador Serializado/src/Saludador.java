import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Saludador extends Remote{
    String getSaludo() throws RemoteException;
    String getAgradecimiento(String aQuienAgradecer) throws RemoteException;
}
