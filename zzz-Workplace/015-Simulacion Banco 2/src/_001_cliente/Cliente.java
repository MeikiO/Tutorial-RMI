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
    
    private final double tasaIntereses=5.1;
    private final int plazoPrestamo=6;
    
    private final static String DIVISOR="_";
    
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
            	try {
            		 opcion=programa.menu();
            		 programa.accion(opcion,comp);
            	}
            	catch(java.lang.NumberFormatException e2) {
            		System.out.println("opcion incorrecta vuelve a intentarlo.");
            	}
           
            }while(opcion!=0);
            
            
        } catch (Exception e) {
          e.printStackTrace();
        }
    }    
    

	private int menu() {
		System.out.println("\n\n Opciones: "
				+ "\n 1- ConsultarSaldo"
				+ "\n 2- Ingresar saldo"
				+ "\n 3- Extraer saldo"
				+ "\n 4- Transferencia"
				+ "\n 5- Pedir prestamo a " + plazoPrestamo+" meses"
				+ "\n 0- Salir");
		System.out.print("\n Opcion: ");
		Scanner teclado=new Scanner(System.in);
		return teclado.nextInt();
	}
	
	private void accion(int opcion, Compute comp) throws RemoteException {
		Ordenes task = null;
		String ordenAMandar="";
		Scanner teclado=new Scanner(System.in);
		
		switch (opcion) {
			case 1:{
				ordenAMandar= ID_CLIENTE
						+DIVISOR + PosiblesOrdenes.CONSULTAR;
				break;
			}
			case 2:{
	            System.out.print("\n Introduce la cantidad a INGRESAR:");
	            double cantidad=teclado.nextDouble();
	            ordenAMandar=ID_CLIENTE
	            		+DIVISOR + PosiblesOrdenes.INGRESAR
	            		+DIVISOR + cantidad;
				break;
			}
			case 3:{
				   System.out.print("\n Introduce la cantidad a RETIRAR:");
		           double cantidad=teclado.nextDouble();
		           ordenAMandar=ID_CLIENTE
		        		   +DIVISOR + PosiblesOrdenes.RETIRAR
		        		   +DIVISOR + cantidad;
				break;
			}
			case 4:{
					System.out.print("\n Introduce id al que le quieras hacer la transferencia: ");
					int id_destino=teclado.nextInt();  
					System.out.print("\n Introduce la cantidad a MANDAR:");
			        double cantidad=teclado.nextDouble();
			        ordenAMandar=ID_CLIENTE 
			        		+ DIVISOR + PosiblesOrdenes.TRANSFERENCIA 
			        		+ DIVISOR + cantidad 
			        		+ DIVISOR + id_destino;
				break;
			}
			case 5:{
				  ordenAMandar=ID_CLIENTE 
			        		+ DIVISOR + PosiblesOrdenes.CONSULTARPRESTAMO;
				  task = new Ordenes(ordenAMandar);
				  String comprobacion = comp.executeTask(task);
				  
				  String[] trozos = comprobacion.split("["+DIVISOR+"]");
				  
				  System.out.println(trozos[0]);
				  
				  int situacion=Integer.parseInt(trozos[1]);
				  double cantidad=0;
				  
				  ordenAMandar=ID_CLIENTE+DIVISOR+PosiblesOrdenes.PASAR; //para el caso de que no eligan nada, no repita acciones
				  
				  if(situacion==0) {
					  System.out.println("Quieres devolver parte del Prestamo: \n 1-SI \n 2-NO");
					  int realizar=teclado.nextInt();
					  
					  if(realizar==1) {
						  System.out.print("\n cantidad a devolver: ");
						  cantidad=teclado.nextDouble();
						  ordenAMandar=ID_CLIENTE 
					        		+ DIVISOR + PosiblesOrdenes.DEVOLVERPRESTAMO
					        		+ DIVISOR + cantidad;
					  }
				  }
				  else {
					  System.out.println("Quieres pedir un Prestamo: \n 1-SI \n 2-NO");
					  int realizar=teclado.nextInt();
					  
					  if(realizar==1) {
						  System.out.print("\n cantidad requerida en el prestamo: ");
						  cantidad=teclado.nextDouble();
						  ordenAMandar=ID_CLIENTE 
					        		+ DIVISOR + PosiblesOrdenes.REALIZARPRESTAMO
					        		+ DIVISOR + cantidad
					        		+ DIVISOR + this.plazoPrestamo;  
					  }
				  }
				  
				break;
			}

		default:
			break;
		}

        task = new Ordenes(ordenAMandar);
        String resultado = comp.executeTask(task);
		
        System.out.println(resultado);
	}
    
}
