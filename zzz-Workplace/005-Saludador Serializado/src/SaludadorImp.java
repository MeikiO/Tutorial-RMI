import java.rmi.RemoteException;

public class SaludadorImp implements Saludador{

	@Override
	public String getSaludo() throws RemoteException {
		return "Saludos Humano";
	}

	@Override
	public String getAgradecimiento(String aQuienAgradecer) throws RemoteException {
		return "Gracias por haberme ayudado "+ aQuienAgradecer;
	}

}
