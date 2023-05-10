package traspaso_monedas;

import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import compute.Compute;
import compute.Monedas;

import java.math.BigDecimal;

public class ComputeConvertidorMonedas {
    public static void main(String args[]) {
        
        try {
        	if(System.getSecurityManager()==null) {
          		System.setProperty("java.security.policy", "file:C:\\Users\\Lenovo\\Documents\\GitHub\\PBL\\zzz-Workplace\\012-Conversor de monedas\\src\\MySecurityPolicy.policy");
        		System.setSecurityManager(new RMISecurityManager());
        	}
        	
        	String name = "Compute";
           
            Registry registry = LocateRegistry.getRegistry(1099);
            Compute comp = (Compute) registry.lookup(name);

            ComputeConvertidorMonedas programa=new ComputeConvertidorMonedas();
            ConvertidorMonedas task = programa.introducir_datos();
            
            BigDecimal total = comp.executeTask(task);
            System.out.println("Cantidad en moneda seleccionada: "+total);
            
        } catch (Exception e) {
            System.err.println("Compute exception:");
            e.printStackTrace();
        }
    }    
    
    
    public ConvertidorMonedas introducir_datos() {
    	Scanner teclado=new Scanner(System.in);
        
    	System.out.println("Introduce monton inicial(en euros):  ");
        BigDecimal montonInicial = teclado.nextBigDecimal();
        
        System.out.println("Elige moneda: ");
        int i=1;
        for(Monedas actual:Monedas.values()) {
        	System.out.println(i+"-"+actual.getNombre());
        	i++;
        }
        
        System.out.println("Elegido: ");
        int elegido=teclado.nextInt();
        
        Monedas elegida=Monedas.DOLAR_ESTADOUNIDENSE;  
        switch(elegido) {
		    case 1 :elegida=Monedas.DOLAR_ESTADOUNIDENSE; break;
		    case 2:elegida=Monedas.YEN_JAPONES; break;
		    case 3:elegida=Monedas.LIBRA_ESTERLINA; break;
		    case 4:elegida=Monedas.DOLAR_AUSTRALIANO; break;
		    case 5:elegida=Monedas.DOLAR_CANADIENSE; break;
		    case 6:elegida=Monedas.FRANCO_SUIZO; break;
		    case 7:elegida=Monedas.RENMINBI_CHINO; break;
		    case 8:elegida=Monedas.DOLAR_HONGKONES; break;
		    case 9:elegida=Monedas.DOLAR_NEOZELANDES; break;
        } 

        


        ConvertidorMonedas task = new ConvertidorMonedas(montonInicial,elegida);
    	
        return task;
    }
    
}
