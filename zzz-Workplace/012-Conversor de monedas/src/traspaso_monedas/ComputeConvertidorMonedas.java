package traspaso_monedas;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import compute.Compute;

import java.math.BigDecimal;

public class ComputeConvertidorMonedas {
    public static void main(String args[]) {
        
        try {
        	if(System.getSecurityManager()==null) {
          		System.setProperty("java.security.policy", "file:C:\\Users\\Lenovo\\Documents\\GitHub\\PBL\\zzz-Workplace\\011-Servidor Calculo dinamico\\src\\MySecurityPolicy.policy");
        		System.setSecurityManager(new RMISecurityManager());
        	}
        	
        	String name = "Compute";
           
            Registry registry = LocateRegistry.getRegistry(1099);
            Compute comp = (Compute) registry.lookup(name);

            ComputeConvertidorMonedas programa=new ComputeConvertidorMonedas();
            ConvertidorMonedas task = programa.introducir_datos();
            
            BigDecimal totalPrestamo = comp.executeTask(task);
            System.out.println("Cantidad final: "+totalPrestamo+" €");
            
        } catch (Exception e) {
            System.err.println("Compute exception:");
            e.printStackTrace();
        }
    }    
    
    
    public ConvertidorMonedas introducir_datos() {
    	Scanner teclado=new Scanner(System.in);
        
    	System.out.println("Introduce monton inicial: ");
        BigDecimal montonInicial = teclado.nextBigDecimal();
        
        System.out.println("Tasa anual de intereses (%): ");
        double porcentajeInteres=teclado.nextDouble();
        BigDecimal tasaAnual = new BigDecimal(100/porcentajeInteres);
        
        System.out.println("años en deposito: ");
        int anos = teclado.nextInt();

        ConvertidorMonedas task = new ConvertidorMonedas(montonInicial,tasaAnual,anos);
    	
        return task;
    }
    
}
