package _003_serverSubcontratas;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

import commons.Pedido;
import commons.Subcontratacion;




public class Subcontrata_3 extends UnicastRemoteObject implements Subcontratacion {

    private String mensaje;
    private final static int NUMPUERTO_SUBCONTRATA=1093;
    private final static String NOMBRESERVER="Subcontrata3";
    
    private Random random;

    public Subcontrata_3(String string) throws RemoteException {
      super();
      this.mensaje=string;
      this.random=new Random();
    }


    public static void main(String[] args) {
        
      
        try {
        	
        	if(System.getSecurityManager()==null) {
        	//decimos que security policy implementamos
        		System.setProperty("java.security.policy", "file:C:\\Users\\Lenovo\\Documents\\GitHub\\PBL\\zzz-Workplace\\014- Simulacion Repartidores\\src\\MySecurityPolicy.policy");
        		System.setSecurityManager(new RMISecurityManager());
        	}
        	
          Registry registry = LocateRegistry.createRegistry(NUMPUERTO_SUBCONTRATA);

          Subcontratacion obj = new Subcontrata_3("Hola que tal estas, soy 3");
          registry.rebind(NOMBRESERVER, obj);

            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }


    @Override
    public boolean subcontratarReparto(Pedido pedido) throws RemoteException {
      System.out.println("Pedido a repartir \n "+pedido.toString());
      
      /*
        aqui esta la parte para que los repartidores hagan el reparto del pedido
        hace falta varios hilos para simular los repartidores disponibles.
        
        FALTAN (Y MEJOR SI CONSULTAS)
        
        -> maximo 5 repartidores por enpresa subcontratada
          -> cada repartidor es 1 hilo
          
    
        -> Los demas pedidos se quedan esperando, y los introducimos en 
        una blocking queue, para repartirlos segun orden.
        
        
        -> el maximo numero de pedidos que pueden tener es 10, repartiendo
        o en espera.
           -> si los pedidos son 10 el server se bloqueara, y no 
             dejara entrar mas pedidos hasta que los pedidos llegen a 7
             
             -> para bloquear el acceso hacemos una funcion de comprobacion
             de capacidad antes de ejecutar esta funcion subcontratarReparto()
             le pasa true, si la capacidad esta bien y false si no.
           
        
        
        -> si no hay pedidos en espera esta inactivo y no hace nada.


        HECHOS

        -> los pedidos tendran un tiempo de espera random, de 2 a 10 segundos
        
        -> hay una probabilidad del 20% de que el pedido no se haga.
          -> random de 0 a100 y si el numero es mayor a 80 el pedido no se hara
      */
      
      
      boolean condicion=true;
      
      
      try {
        
        System.out.println("Repartidor va ha repartir pedido a "+pedido.getDireccion());
        
        int segundos=this.random.nextInt(8)+2;
        Thread.sleep(segundos*1000);
        
        
        int probabilidad=this.random.nextInt(100);
        
        if(probabilidad>80) {
            System.out.println("El pedido no se ha podido realizar\n");
            condicion=false;
        }
        else {
          System.out.println("Pedido realizado correctamente\n");
          condicion=true;
        }
        
        
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      
      
      return condicion;
    }





}