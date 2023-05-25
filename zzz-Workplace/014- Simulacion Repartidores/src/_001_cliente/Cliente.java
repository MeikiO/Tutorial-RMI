package _001_cliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


import commons.HacerPedidos;
import commons.Pedido;

class Cliente{
    
  private String nameClienteAExtraer;
  private int port;
  private String nombre;
  private String tlf;
  private String direccion;

  private final static int NUMPUERTO=1090;
  private final static String NOMBRESERVER="ServerGestion";
  

  
  public static void main(String args[]) {

      for(int i=0;i<10;i++) {

    	     
          /*
              funcionamiento de los clientes al hacer pedido:
                -> se lanzan con todos los hilos disponibles de la maquina
                
                -> cada cliente antes de hacer pedido, tiene un tiempo de 
                espera entre 1 y 5 segundos.
                
                -> entre cliente y cliente hay 2 segundos de pausa, al pedir.
           
               
               -> necesitamos generador de nombres, telefono y direcciones.

           */
          
            try {
            	
                Registry registry = LocateRegistry.getRegistry(NUMPUERTO);
                HacerPedidos comp = (HacerPedidos) registry.lookup(NOMBRESERVER);
                
                GeneradorPedidos generador=new GeneradorPedidos("nombre"+i,"tlf"+i,"direccion"+i);
                Pedido pedido=generador.generarPedido();
                
                System.out.println("\n Mandado pedido -----> "+pedido.getId().toString());
                
          
                boolean tarea1 = comp.hacerPedido(pedido);
                
                if(tarea1) {
                  System.out.println("El pedido "+ pedido.getId() +" se ha realizado correctamente ");        
                }
                else {
                  System.out.println("No se ha podido realizar el pedido "+pedido.getId());
                }
                
                System.out.println(tarea1);
          
                }
                catch(RemoteException e) {
                  e.printStackTrace();
                }
                catch (Exception e) {
                    e.printStackTrace();            
                }
      }
   
	/*
	 El ejercicio al final no es paralelizable y no importa si utilizamos hilos o no, es totalmente procedural y la conexión se hace 1 a 1 con el destino.
	
	Lo que si se ha conseguido ha sido que mientras se ejecuta, y si subcontrata 1 y2 están caídos, ira al 3, pero si se levanta 1 o 2 durante la ejecución todo el flujo pasara a ellos. 
	  
	 */
      
      
    }

}
