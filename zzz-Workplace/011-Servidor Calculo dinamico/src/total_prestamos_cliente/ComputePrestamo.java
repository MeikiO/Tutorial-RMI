package total_prestamos_cliente;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import compute.Compute;

import java.math.BigDecimal;

public class ComputePrestamo {
    public static void main(String args[]) {
        
        try {
        	if(System.getSecurityManager()==null) {
          		System.setProperty("java.security.policy", "file:C:\\Users\\Lenovo\\Documents\\GitHub\\PBL\\zzz-Workplace\\011-Servidor Calculo dinamico\\src\\MySecurityPolicy.policy");
        		System.setSecurityManager(new RMISecurityManager());
        	}
        	
        	String name = "Compute";
           
            Registry registry = LocateRegistry.getRegistry(1099);
            Compute comp = (Compute) registry.lookup(name);

            ComputePrestamo programa=new ComputePrestamo();
            Prestamo task = programa.introducir_datos();
            
            BigDecimal totalPrestamo = comp.executeTask(task);
            System.out.println("Cantidad total de prestamo a devolver: "+totalPrestamo+" €");
            
        } catch (Exception e) {
            System.err.println("Compute exception:");
            e.printStackTrace();
        }
    }    
    
    
    public Prestamo introducir_datos() {
    	Scanner teclado=new Scanner(System.in);
        
    	System.out.println("Introduce prestamo inicial: ");
        BigDecimal precio = teclado.nextBigDecimal();
        
        System.out.println("A cuanta tasa de interes: ");
        double porcentajeInteres=teclado.nextDouble();
        BigDecimal tasaInteres = new BigDecimal(porcentajeInteres/100);
        
        System.out.println("El plazo de devolucion en años: ");
        BigDecimal plazo = teclado.nextBigDecimal();

        Prestamo task = new Prestamo(precio, tasaInteres, plazo);
    	
        return task;
    }
    
}
