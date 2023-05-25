package baul;

import java.util.Map;
import java.util.TreeMap;

public class GestorBaul {
	
	public final Integer MAXGENERADAS=5;
	Map<Integer,Cuenta> mapaCuentas;
	
	public GestorBaul() {
		this.mapaCuentas=new TreeMap<>();
		this.inicializarBaul();
		
	}

	private void inicializarBaul() {
		for(int i=0;i<MAXGENERADAS;i++) {
			
			
			Cuenta nueva=new Cuenta(i, null);
			
			this.mapaCuentas.put(i,nueva);
		}
		
	}



	public String procesarPeticion(String string) {

		return "Esto se ha hecho bien En el baul";
	}
	
}
