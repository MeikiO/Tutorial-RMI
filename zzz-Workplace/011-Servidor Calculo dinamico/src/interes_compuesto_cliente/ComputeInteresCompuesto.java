package interes_compuesto_cliente;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import compute.Compute;

import java.math.BigDecimal;

public class ComputeInteresCompuesto {
    public static void main(String args[]) {
        
        try {
        	if(System.getSecurityManager()==null) {
          		System.setProperty("java.security.policy", "file:C:\\Users\\Lenovo\\Documents\\GitHub\\PBL\\zzz-Workplace\\011-Servidor Calculo dinamico\\src\\MySecurityPolicy.policy");
        		System.setSecurityManager(new RMISecurityManager());
        	}
        	
        	String name = "Compute";
           
            Registry registry = LocateRegistry.getRegistry(1099);
            Compute comp = (Compute) registry.lookup(name);

            ComputeInteresCompuesto programa=new ComputeInteresCompuesto();
            InteresCompuesto task = programa.introducir_datos();
            
            BigDecimal totalPrestamo = comp.executeTask(task);
            System.out.println("Cantidad final: "+totalPrestamo+" €");
            
        } catch (Exception e) {
            System.err.println("Compute exception:");
            e.printStackTrace();
        }
    }    
    
    
    public InteresCompuesto introducir_datos() {
    	Scanner teclado=new Scanner(System.in);
        
    	System.out.println("Introduce monton inicial: ");
        BigDecimal montonInicial = teclado.nextBigDecimal();
        
        System.out.println("Tasa anual de intereses (%): ");
        double porcentajeInteres=teclado.nextDouble();
        BigDecimal tasaAnual = new BigDecimal(100/porcentajeInteres);
        
        System.out.println("años en deposito: ");
        int anos = teclado.nextInt();

        InteresCompuesto task = new InteresCompuesto(montonInicial,tasaAnual,anos);
    	
        return task;
    }
    
}
