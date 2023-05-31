package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.Scanner;

import common.Calculadora;

public class Cliente {
	Scanner teclado;
	Registry registry;
	Calculadora stub;
	
	public Cliente(Calculadora stub2) {
		//TODO
		this.stub=stub2;
		teclado = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		try {
        	Registry registry = LocateRegistry.getRegistry(1099);
        	
            Calculadora stub = (Calculadora) registry.lookup("Operaciones"); 
            
            Cliente programa=new Cliente(stub);
            programa.hacerOperaciones();
            
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

	}
	
	private void hacerOperaciones() {
		int opcion=0;
		do {
			opcion=this.menu();
			
			if(opcion!=0) {
				System.out.println("introduce n1: ");
				int n1=teclado.nextInt();
				System.out.println("introduce n2: ");
				int n2=teclado.nextInt();				

				double respuesta=0;
				
				try {
					switch(opcion) {
						case 1: respuesta=stub.sumar(n1, n2);break;
						case 2: respuesta=stub.restar(n1, n2); break;
						case 3: respuesta=stub.multiplicar(n1, n2); break;
						case 4: respuesta=stub.dividir(n1, n2); break;
						default: break;
					}
				}
				catch (RemoteException e) {
					e.printStackTrace();
				}
				
				System.out.println("Respuesta: " + respuesta);
			}
			
		
		}while(opcion!=0);
	}
	
	private int menu() {
		int opcion;
		
		System.out.println("1.- Sumar");
		System.out.println("2.- Restar");
		System.out.println("3.- Multiplicar");
		System.out.println("4.- Dividir");
		System.out.println("0.- Salir");
		System.out.print ("Selecione una opcion: ");
		
		opcion = teclado.nextInt();
		teclado.nextLine();
		
		return opcion;
	}
}
