package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import java.util.Scanner;

import common.Calculadora;

public class Cliente {
	Scanner teclado;
	Registry registry;
	Calculadora stub;
	
	public Cliente() {
		//TODO
	}
	
	public static void main(String[] args) {
		try {
			Cliente cliente = new Cliente();
			cliente.hacerOperaciones();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

	}
	
	private void hacerOperaciones() {
		//TODO
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
