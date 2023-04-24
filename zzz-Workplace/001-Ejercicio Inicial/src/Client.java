

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.Scanner;


public class Client {
	Scanner teclado;
	Registry registry;
	Adder stub;
	
	public Client(Adder stub2) {
		//TODO
		this.stub=stub2;
		teclado = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		try {
	    	//accedemos al servidor de nombres a traves del puerto
        	
			Registry registry = LocateRegistry.getRegistry(1099);
        	
            Adder stub = (Adder) registry.lookup("Operaciones"); 
            //tomamos el objeto con la identificacion que se ha puesto
            
            Client programa=new Client(stub);
            programa.hacerOperaciones();
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

	}
	
	private void hacerOperaciones() throws RemoteException {
		System.out.println("introduce n1: ");
		int n1=teclado.nextInt();
		System.out.println("introduce n2: ");
		int n2=teclado.nextInt();				

		double respuesta=this.stub.add(n1, n2);
		
		System.out.println("Respuesta: " + respuesta);
	}
	
	
}
