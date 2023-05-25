package _002_server_gestion;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import _001_cliente.GeneradorPedidos;
import commons.Subcontratacion;
import commons.HacerPedidos;
import commons.Pedido;





public class ServerGestion extends UnicastRemoteObject implements HacerPedidos {

    private String mensaje;
    private Pedido pedido;
    private final static int NUMPUERTO_GESTION=1090;

    private ConcurrentHashMap<String,Pedido> mapaPedidos;
    
    private double facturacionTotal;
    
    public ServerGestion() throws RemoteException {
      this.mapaPedidos=new ConcurrentHashMap<>();
      this.facturacionTotal=0.0;
    }

    public Pedido getPedido() {
      return pedido;
    }


    public void setPedido(Pedido pedido) {
      this.pedido = pedido;
    }


    public static void main(String[] args) {
        
        try {
                 	
        	Registry registry = LocateRegistry.createRegistry(NUMPUERTO_GESTION);

          
          HacerPedidos obj = new ServerGestion();
          String nameCliente1 = "ServerGestion";//despues seria sustituir esto por el UUID GENERADO
          registry.rebind(nameCliente1, obj);
          
          
            System.out.println("Servidor Gestor de pedidos Online");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }


    @Override
    public boolean hacerPedido(Pedido pedido) throws RemoteException {
     
      this.pedido=pedido;
      
      System.out.println("\n Pedido recibido: "+pedido.toString());
           
      //se manda el pedido a la subcontrata, para que hay haga el reparto
      
      boolean condicion=this.mandarPedidoASubcontratas(pedido);
      
 
      //si la condicion es correcta facturamos el pedido y hacemos una acumulacion de 
      //lo que se ha facturado hasta el momento.
      if(condicion) {
        System.out.println("---------El pedido"+pedido.getId().toString()+" se ha facturadado");
        this.facturacionTotal=facturacionTotal+pedido.getTotalCosto();
        System.out.println("Total facturado: "+this.facturacionTotal);
        
      }

      
      return condicion; //despues notificamos al cliente DEVOLVIENDO EL OKAY por el return del final de esta funcion
    }


    public boolean mandarPedidoASubcontratas(Pedido pedido) {
      
      boolean condicion=true;
      try {
        
          int port = 1090;
          String nameClienteAExtraer = "Subcontrata";
          int numServerTope=3;
          
          int numServerCerrados=0;
        
          for(int i=1;i<=numServerTope;i++) {
            try {
              Registry registry = LocateRegistry.getRegistry(port+i);
              Subcontratacion comp = (Subcontratacion) registry.lookup(nameClienteAExtraer+i);
              
              
              condicion = comp.subcontratarReparto(pedido); //LLAMAMOS A SUBCONTRATA_1,2 O 3
                           
              
              break; //para que solo el primero que este disponible pueda hacerlo
            }
            catch(java.rmi.ConnectException e){
              System.out.println("Servidor " + i + " no disponible");
              numServerCerrados++;
            }
          }
          
          if(numServerCerrados==numServerTope) {
            System.out.println("No se ha podido realizar el pedido, no hay servidores disponibles");
            condicion=false;
          }
          
      }
      catch(RemoteException e) {
        e.printStackTrace();
      }
      catch (Exception e) {
          e.printStackTrace();            
      }
      
      return condicion;
    }


}