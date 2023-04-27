import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	public static void main( String[] args )
    {
	     try {
	            Registry registroDeServicios = LocateRegistry.createRegistry(1099);
	     
	            SaludadorImp saludador = new SaludadorImp();
                Saludador stubSaludador = (Saludador) UnicastRemoteObject.exportObject(saludador, 8888);
                ////Si este servidor va a utilizar un registro de servicios que ya este activo en nuestro sistema, usar LocateRegistry.getRegistry
                registroDeServicios = LocateRegistry.getRegistry();
                ////Si este servidor va a crear su propio registro de servicios, usar LocateRegistry.createRegistry
                //registroDeServicios = LocateRegistry.createRegistry(1099);
                registroDeServicios.bind("SaludosYAgradecimientosVarios", stubSaludador);
             
                System.out.println("Server en marcha");
                
	     } catch (RemoteException e) {
	            System.err.println("Fallo al iniciar el REGISTRO DE SERVICIOS: " + e.toString());
	            e.printStackTrace();
	        } catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
