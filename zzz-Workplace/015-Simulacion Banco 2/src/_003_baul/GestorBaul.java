package _003_baul;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;


public class GestorBaul {
	
	public final Integer MAXGENERADAS=5;
	Map<Integer,Cuenta> mapaCuentas;
	
	public GestorBaul() {
		this.mapaCuentas=new TreeMap<>();
		this.inicializarBaul();
	}

	private void inicializarBaul() {
		Random generador=new Random();
		int maximo=5000;
		for(int i=0;i<MAXGENERADAS;i++) {
			
			double saldoTotal = generador.nextDouble()+generador.nextInt(maximo)+2000;
			
			boolean prestamoSolicitado = generador.nextBoolean();
			double TotalPrestamoAdevolver=0.0;
			if(prestamoSolicitado) {
				TotalPrestamoAdevolver = generador.nextDouble()+generador.nextInt(maximo)+2000;			
			}
			
			boolean depositoRealizado = generador.nextBoolean();
			double depositoAPlazos=0.0;
			if(depositoRealizado) {
				depositoAPlazos = generador.nextDouble()+generador.nextInt(maximo)+2000;			
			}
			
			Cuenta nueva=new Cuenta(i, saldoTotal,TotalPrestamoAdevolver,prestamoSolicitado,depositoAPlazos,depositoRealizado);	
			this.mapaCuentas.put(i,nueva);
		}
		
	}


	public String procesarPeticion(String string) {
		StringBuilder resultado=new StringBuilder();
		String[] trozos = string.split("[.]");
		
		Integer id=Integer.parseInt(trozos[0]);
		String accion=trozos[1];
		
		switch(accion) {
			case "CONSULTAR":{
				resultado.append("Saldo total disponible para cliente id["+id+"]: \n");
				resultado.append(this.mapaCuentas.get(id).getSaldoTotal()+"\n");
				break;
			}
			case "":{
				break;
			}
		}
		return resultado.toString();
	}
	
}
