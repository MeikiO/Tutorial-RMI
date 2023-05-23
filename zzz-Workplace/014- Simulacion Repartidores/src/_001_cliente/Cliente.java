package _001_cliente;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import commons.HacerPedidos;
import commons.Pedido;

class Cliente implements Runnable{
    
  private String nameClienteAExtraer;
  private int port;
  private String nombre;
  private String tlf;
  private String direccion;

  public Cliente(int i) {
      this.port= 1090;
      this.nameClienteAExtraer = "ServerGestion";
      this.nombre="nombre"+i;
      this.tlf="tlf"+i;
      this.direccion="direccion"+i;
  }
  
  public static void main(String args[]) {

      ExecutorService executor=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
      
      for(int i=0;i<10;i++) {
          Cliente nuevo=new Cliente(i);
          nuevo.run();
      }
   
/*
 El ejercicio al final no es paralelizable y no importa si utilizamos hilos o no, es totalmente procedural y la conexión se hace 1 a 1 con el destino.

 

Lo que si se ha conseguido ha sido que mientras se ejecuta, y si subcontrata 1 y2 están caídos, ira al 3, pero si se levanta 1 o 2 durante la ejecución todo el flujo pasara a ellos. 
  
 */
      
      
    }
    
    @Override
    public void run() {
  
     
      /*
          funcionamiento de los clientes al hacer pedido:
            -> se lanzan con todos los hilos disponibles de la maquina
            
            -> cada cliente antes de hacer pedido, tiene un tiempo de 
            espera entre 1 y 5 segundos.
            
            -> entre cliente y cliente hay 2 segundos de pausa, al pedir.
       
           
           -> necesitamos generador de nombres, telefono y direcciones.

       */
      
        try {
            
        	if(System.getSecurityManager()==null) {
        	//decimos que security policy implementamos
        		System.setProperty("java.security.policy", "file:C:\\Users\\Lenovo\\Documents\\GitHub\\PBL\\zzz-Workplace\\014- Simulacion Repartidores\\src\\MySecurityPolicy.policy");
        		System.setSecurityManager(new RMISecurityManager());
        	}
        	
        	
            Registry registry = LocateRegistry.getRegistry(port);
            HacerPedidos comp = (HacerPedidos) registry.lookup(nameClienteAExtraer);
            
            GeneradorPedidos generador=new GeneradorPedidos(this.nombre,this.tlf,this.direccion);
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
}
