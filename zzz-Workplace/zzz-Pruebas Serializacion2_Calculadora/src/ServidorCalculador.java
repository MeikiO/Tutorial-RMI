
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorCalculador {
    private Boolean esteServidorEstaParado;

    public ServidorCalculador() {
        esteServidorEstaParado = true;
    }

    public void arrancar() {
        if (esteServidorEstaParado) {
            try {
                CalculadorImpl calculador = new CalculadorImpl();
                Calculador stubCalculador = (Calculador) UnicastRemoteObject.exportObject(calculador, 8882);
                Registry registroDeServicios = LocateRegistry.getRegistry();
                registroDeServicios.bind("CalculadorMatematico", stubCalculador);
                esteServidorEstaParado = false;
            } catch (Exception e) {
                System.err.println("Fallo al iniciar el SERVIDOR de calculos: " + e.toString());
                e.printStackTrace();
            }
        }
    }
    
}