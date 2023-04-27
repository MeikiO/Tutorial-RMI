

import java.rmi.RemoteException;

public class SaludosYAgradecimientos_impl  implements SaludosYAgradecimientos {

    @Override
    public String getSaludo() throws RemoteException {
        return "Hola, prosperos y felices dias...";
    }

    @Override
    public String getAgradecimiento(String aQuienAgradecer) throws RemoteException {
        return "Muchas gracias, " + aQuienAgradecer + ", por todo el trabajo realizado.";
    }
    
}
