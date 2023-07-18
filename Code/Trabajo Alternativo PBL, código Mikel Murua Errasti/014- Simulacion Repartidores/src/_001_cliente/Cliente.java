package _001_cliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import commons.HacerPedidos;
import commons.Pedido;

class Cliente{
  
  private final static int NUMPUERTO=1090;
  private final static String NOMBRESERVER="ServerGestion";
  
  public static void main(String args[]) {
      for(int i=0;i<10;i++) {
    	  
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
   }
}
