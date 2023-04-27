

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ParteCliente {
    private SaludosYAgradecimientos stubSaludador;

    public ParteCliente() {
        try {
            Registry registroDeServicios = LocateRegistry.getRegistry();
            stubSaludador = (SaludosYAgradecimientos) registroDeServicios.lookup("SaludosYAgradecimientosVarios");
        } catch (Exception e) {
            System.err.println("Fallo al iniciar el CLIENTE: " + e.toString());
            e.printStackTrace();
        }
    }

    public void saludar() throws RemoteException {
        System.out.println(stubSaludador.getSaludo());
    }

    public void agradecerA(String aQuien) throws RemoteException {
        System.out.println(stubSaludador.getAgradecimiento(aQuien));
    }
}
