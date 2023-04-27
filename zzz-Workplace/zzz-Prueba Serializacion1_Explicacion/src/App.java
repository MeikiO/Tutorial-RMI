

import java.rmi.RemoteException;

public class App 
{
    public static void main( String[] args )
    {
        ParteRegistradorDeServicios registrador = new ParteRegistradorDeServicios();
        registrador.arrancar(1099);

        ParteServidor servidor = new ParteServidor();
        servidor.arrancar();
        
        ParteCliente cliente = new ParteCliente();
        try {
            cliente.saludar();
            cliente.agradecerA("Benzirpi");
        } catch (RemoteException e) {
            System.err.println("Fallo intentar saludar: " + e.toString());
            e.printStackTrace();
        }
    }
}
