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