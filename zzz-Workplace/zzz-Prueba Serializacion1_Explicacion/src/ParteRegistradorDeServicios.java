

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ParteRegistradorDeServicios {
    private static Registry registroDeServicios;
    
    public ParteRegistradorDeServicios() {
    }

    public void arrancar(int puertoDeEscucha) {
        try {
            registroDeServicios = LocateRegistry.createRegistry(puertoDeEscucha);
        } catch (RemoteException e) {
            System.err.println("Fallo al iniciar el REGISTRO DE SERVICIOS: " + e.toString());
            e.printStackTrace();
        }
    }

}
