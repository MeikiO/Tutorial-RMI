import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {

	private SaludadorImp implementacion;

	public Cliente() {
		// TODO Auto-generated constructor stub
		implementacion=new SaludadorImp();
	}
	
	public static void main(String[] args) {
		Cliente cliente=new Cliente();
		
		try {
        Registry registroDeServicios = LocateRegistry.getRegistry();
        Saludador stubSaludador = (Saludador) registroDeServicios.lookup("SaludosYAgradecimientosVarios");
			cliente.saludar();
			cliente.agradecerA("Benzirpi");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
    public void saludar() throws RemoteException {
        System.out.println(this.implementacion.getSaludo());
    }

    public void agradecerA(String aQuien) throws RemoteException {
        System.out.println(this.implementacion.getAgradecimiento(aQuien));
    }
}
