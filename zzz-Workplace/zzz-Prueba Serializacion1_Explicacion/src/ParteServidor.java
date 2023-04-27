

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ParteServidor extends SaludosYAgradecimientos_impl {
    private Boolean esteServidorEstaParado;

    public ParteServidor() {
        esteServidorEstaParado = true;
    }

    public void arrancar() {
        if (esteServidorEstaParado) {
            try {
                SaludosYAgradecimientos_impl saludador = new SaludosYAgradecimientos_impl();
                SaludosYAgradecimientos stubSaludador = (SaludosYAgradecimientos) UnicastRemoteObject.exportObject(saludador, 8888);
                ////Si este servidor va a utilizar un registro de servicios que ya este activo en nuestro sistema, usar LocateRegistry.getRegistry
                Registry registroDeServicios = LocateRegistry.getRegistry();
                ////Si este servidor va a crear su propio registro de servicios, usar LocateRegistry.createRegistry
                //registroDeServicios = LocateRegistry.createRegistry(1099);
                registroDeServicios.bind("SaludosYAgradecimientosVarios", stubSaludador);
                esteServidorEstaParado = false;
            } catch (Exception e) {
                System.err.println("Fallo al iniciar el SERVIDOR: " + e.toString());
                e.printStackTrace();
            }
        }
    }
    
}
