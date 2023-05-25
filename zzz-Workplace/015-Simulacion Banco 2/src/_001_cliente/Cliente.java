package _001_cliente;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;


import compute.Compute;

import java.math.BigDecimal;

public class Cliente {
	
    private final static int NUMPUERTO=1091;
    private final static String NOMBRESERVER="Banco";
    private final static String ID_CLIENTE="1";
    
    public static void main(String args[]) {
        
        try {
        	if(System.getSecurityManager()==null) {
          		System.setProperty("java.security.policy", "file:C:\\Users\\Lenovo\\Documents\\GitHub\\PBL\\zzz-Workplace\\011-Compute Engine Carga Dinamica (base)\\src\\MySecurityPolicy.policy");
        		System.setSecurityManager(new RMISecurityManager());
        	}
        	
        	String name = "Compute";

            
            Registry registry = LocateRegistry.getRegistry(NUMPUERTO);
            Compute comp = (Compute) registry.lookup(NOMBRESERVER);
            
            
            Cliente programa=new Cliente();
            int opcion=0;
            
            do {
            	opcion=programa.menu();
            	programa.accion(opcion,comp);
            }while(opcion!=0);
            
            
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }    
    

	private int menu() {
		System.out.println("Opciones: "
				+ "\n 1- ConsultarSaldo"
				+ "\n 2- Ingresar saldo"
				+ "\n 3- Extraer saldo"
				+ "\n 4- Transferencia"
				+ "\n 5- Pedir prestamo"
				+ "\n 6- Fondo a 10 años"
				+ "\n 7- Cambio de divisas"
				+ "\n 0- Salir");
		System.out.print("\n Opcion: ");
		Scanner teclado=new Scanner(System.in);
		return teclado.nextInt();
	}
	
	private void accion(int opcion, Compute comp) throws RemoteException {
		Ordenes task = null;
		
		
		
		switch (opcion) {
			case 1:{
				String ordenAMandar= ID_CLIENTE+"."+PosiblesOrdenes.CONSULTAR;
	            task = new Ordenes(ordenAMandar);
	            String resultado = comp.executeTask(task);
	            System.out.println(resultado);
				break;
			}
			case 2:{
	            int cantidad=1000;
	            String ordenAMandar=ID_CLIENTE+"."+PosiblesOrdenes.INGRESAR+"."+cantidad;
	            
	            task = new Ordenes(ordenAMandar);
	            String resultado = comp.executeTask(task);
				
	            System.out.println(resultado);
				break;
			}
			case 3:{
				break;
			}
			case 4:{
				break;
			}
			case 5:{
				break;
			}
			case 6:{
				break;
			}
			case 7:{
				break;
			}
		
		default:
			break;
		}
		
	}
    
}
