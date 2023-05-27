package _003_baul;

import java.math.BigDecimal;
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
			
			BigDecimal saldoTotal = new BigDecimal(generador.nextDouble()+generador.nextInt(maximo)+2000);
			
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
		String[] trozos = string.split("[_]");
		
		Integer id=Integer.parseInt(trozos[0]);
		String accion=trozos[1];
		
		if(this.mapaCuentas.keySet().contains(id)) {
			switch(accion) {
				case "CONSULTAR":{
					resultado.append(this.consultarSaldo(id));
					break;
				}
				case "INGRESAR":{
					double cantidad=Double.parseDouble(trozos[2]);
					resultado.append(this.ingresarDineroCuenta(id,cantidad));
					break;
				}
				case "RETIRAR":{
					double cantidad=Double.parseDouble(trozos[2]);
					resultado.append(this.retirarDineroCuenta(id,cantidad));
					break;
				}
				case "TRANSFERENCIA":{
					double cantidad=Double.parseDouble(trozos[2]);
					int id_destino=Integer.parseInt(trozos[3]);
					resultado.append(this.realizarTransferenci(id,cantidad,id_destino));
					break;
				}
				case "PRESTAMO":{
					
					break;
				}
				case "":{
					break;
				}
			}
		}
		else {
			resultado.append("Datos de clientes no encontrados "
					+ "\n por favor contacte con el banco para mas informacion \n");
		}
		
		return resultado.toString();
	}
	
	
	
	
	
	private String realizarTransferenci(Integer id, double cantidad, Integer id_destino) {
		String resultado="";
		double totalAOperar=Math.abs(cantidad);

		if(totalAOperar <= this.mapaCuentas.get(id).getSaldoTotal()) {
			if(this.mapaCuentas.keySet().contains(id_destino)) {
				
				this.mapaCuentas.get(id).retirar(totalAOperar);	
				this.mapaCuentas.get(id_destino).ingresar(totalAOperar);
				
				resultado="Transferencia realizada correctamente";
			}
			else {
				resultado="No se ha podido encontrar el id destino.";
			}
		}
		else {
			resultado="Dinero insuficiente en cuenta intentelo con otra cantidad";
		}
		
		return resultado;
	}

	private String retirarDineroCuenta(Integer id, double cantidad) {
		String resultado="";
		double totalAOperar=Math.abs(cantidad);

		if(totalAOperar <= this.mapaCuentas.get(id).getSaldoTotal()) {
			this.mapaCuentas.get(id).retirar(totalAOperar);			
			resultado="\n Operacion hecha de forma correcta"
					+ "\nDinero retirado:"+totalAOperar
					+ " \nSaldo tras operacion: "+this.mapaCuentas.get(id).getSaldoTotal();
		}
		else {
			resultado="Dinero insuficiente en cuenta intentelo con otra cantidad";
		}
		
		return resultado;
	}

	
	private String ingresarDineroCuenta(Integer id, double cantidad) {
		double totalAOperar=Math.abs(cantidad);

		this.mapaCuentas.get(id).ingresar(totalAOperar);
		
		return "\n Operacion hecha de forma correcta"
				+ "\nDinero aportado: "+totalAOperar
				+ " \nSaldo tras operacion: "+this.mapaCuentas.get(id).getSaldoTotal();
	}
	
	
	public String consultarSaldo(Integer id) {
		String resultado = "\n Saldo total disponible para cliente id["+id+"]: \n";
		resultado=resultado+this.mapaCuentas.get(id).getSaldoTotal()+"\n";
		return resultado;
	}
	
}
