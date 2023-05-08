package client;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.Scanner;

import common.LaInterfazBateria;
import common.RuedaDelantera;
import common.RuedaTrasera;



public class CPU {
	Scanner teclado;
	Registry registry;
	private RuedaDelantera r1;
	private RuedaDelantera r2;
	private RuedaTrasera r3;
	private RuedaTrasera r4;
	private LaInterfazBateria bateria;
	
	public CPU(RuedaDelantera r1, RuedaDelantera r2, RuedaTrasera r3, RuedaTrasera r4, LaInterfazBateria bateria) {
		//TODO
		this.r1=r1;
		this.r2=r2;
		this.r3=r3;
		this.r4=r4;
		this.bateria=bateria;
		teclado = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		try {

			//cada stub tiene su puerto y su direccion lookup (el puesto en el bind)
			// cada puerto solo puede ser usado por 1 proceso a la vez.
			
			
			/*los errores vienen dado por los siguientes puntos
			 -> La interfaz no extiende Remote
			 -> Los metodos de la interfaz no tienen
				<return> foo() throws RemoteException;
				
			 -> el puerto usado por algun elemento esta ya usado
			 -> el nombre de registro esta mal en algun lado
			 
			*/
			
			
			//En este ejercicio se quiere trabajar el uso de diferentes stubs
			// en una aplicacion distribuida. (el ejercicio es largo pero facil)
			
        	Registry registry = LocateRegistry.getRegistry(1091);
            RuedaDelantera r1 =  (RuedaDelantera) registry.lookup("direccion1"); 
            
            registry  = LocateRegistry.getRegistry(1092);
            RuedaDelantera r2 = (RuedaDelantera) registry.lookup("direccion2");
            
            registry  = LocateRegistry.getRegistry(1093);
            RuedaTrasera r3=(RuedaTrasera) registry.lookup("motor3");
            
            registry  = LocateRegistry.getRegistry(1094);
            RuedaTrasera r4=(RuedaTrasera) registry.lookup("motor4");
            
            registry  = LocateRegistry.getRegistry(1095);
            LaInterfazBateria bateria = (LaInterfazBateria) registry.lookup("bateria");
            
            CPU programa=new CPU(r1,r2,r3,r4,bateria);
            
            
            programa.hacerOperaciones();
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

	}
	
	private void hacerOperaciones() {
		int opcion=0;
		
		try {
			
			do {
				opcion=this.menu();
				
				if(opcion!=0) {

					String respuesta="";
					
					switch(opcion) {
						case 1:{
							System.out.println(r3.adelante());
							System.out.println(r4.adelante());	
							System.out.println("la bateria se ha descargado" + this.bateria.descargarBateria());
							break;
						}
						case 2:{
							System.out.println(r3.atras());
							System.out.println(r4.atras());	
							System.out.println("la bateria se ha descargado" + this.bateria.descargarBateria());
							break;
						}
						case 3:{
							System.out.println("Hacia que lado gira: \n 1-derecha \n 2-izquierda");
							int direccion=this.teclado.nextInt();
							System.out.println(r1.girar(direccion));
							System.out.println(r2.girar(direccion));
							break;
						}
						case 4:{
							System.out.println(r1.parar()); 
							System.out.println(r2.parar()); 
							System.out.println(r3.parar()); 
							System.out.println(r4.parar()); 
							break;
						}
						case 5:{
							System.out.println("Carga restante bateria: "+this.bateria.porcentajeBateria());
							break;
						}
						
						default: break;
					}
					
					System.out.println("Respuesta: " + respuesta);
				}
				
			
			}while(opcion!=0);
		
		}
		catch(RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	private int menu() {
		int opcion;
		
		System.out.println("1.- Adelante");
		System.out.println("2.- Atras");
		System.out.println("3.- Girar");
		System.out.println("4.- Parar");
		System.out.println("5.- Comprobar Bateria");
		
		System.out.println("0.- Salir");
		System.out.print ("Selecione una opcion: ");
		
		opcion = teclado.nextInt();
		teclado.nextLine();
		
		return opcion;
	}
}
