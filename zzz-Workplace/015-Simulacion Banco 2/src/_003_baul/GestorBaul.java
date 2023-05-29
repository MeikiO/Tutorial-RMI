package _003_baul;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;


public class GestorBaul {
	
	public final Integer MAXGENERADAS=5;
	Map<Integer,Cuenta> mapaCuentas;
	
	private final static String DIVISOR="_";
	
	private final static Double tasaIntereses=5.1;
	
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
				BigDecimal prestamo = new BigDecimal(generador.nextDouble()+generador.nextInt(maximo)+2000);
				TotalPrestamoAdevolver = prestamo.setScale(2, RoundingMode.HALF_UP).doubleValue();		
			}
						
			Cuenta nueva=new Cuenta(i, saldoTotal,TotalPrestamoAdevolver,prestamoSolicitado);	
			this.mapaCuentas.put(i,nueva);
		}
		
	}


	public String procesarPeticion(String string) {
		StringBuilder resultado=new StringBuilder();
		String[] trozos = string.split("["+DIVISOR+"]");
		
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
				case "CONSULTARPRESTAMO":{
					resultado.append(this.consultarPrestamo(id));
					break;
				}
				case "REALIZARPRESTAMO":{
					double cantidad=Double.parseDouble(trozos[2]);
					BigDecimal plazo=new BigDecimal(trozos[3]);
					resultado.append(this.realizarPrestamo(id,cantidad,plazo));
					break;
				}
				case "DEVOLVERPRESTAMO":{
					double cantidad=Double.parseDouble(trozos[2]);
					resultado.append(this.devolverPrestamo(id,cantidad));
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
	

	public String consultarSaldo(Integer id) {
		String resultado = "\n Saldo total disponible para cliente id["+id+"]: \n";
		resultado=resultado+this.mapaCuentas.get(id).getSaldoTotal()+"\n";
		return resultado;
	}
	
	private String ingresarDineroCuenta(Integer id, double cantidad) {
		double totalAOperar=Math.abs(cantidad);

		this.mapaCuentas.get(id).ingresar(totalAOperar);
		
		return "\n Operacion hecha de forma correcta"
				+ "\nDinero aportado: "+totalAOperar
				+ " \nSaldo tras operacion: "+this.mapaCuentas.get(id).getSaldoTotal();
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


	private String consultarPrestamo(Integer id) {
		
		boolean condicion= this.mapaCuentas.get(id).isPrestamoSolicitado();
		String mensaje="";
		if(condicion) {
			mensaje="\n Prestamo activo "
					+ "\n Total del prestamo a devolver "+this.mapaCuentas.get(id).getTotalPrestamoAdevolver()
					+ DIVISOR + "0";
		}
		else {
			mensaje="No se tiene ningun prestamo actualmente"+DIVISOR+"1";
		}
		
		return mensaje;
	}

	private String realizarPrestamo(Integer id, double cantidad,BigDecimal plazo) {
		BigDecimal tasa=new BigDecimal(this.tasaIntereses/100);
		BigDecimal precio=new BigDecimal(cantidad);
        BigDecimal interes = precio.multiply(tasa).multiply(plazo);
        BigDecimal total = precio.add(interes);
        
        double totalPrestamo=total.setScale(2, RoundingMode.HALF_UP).doubleValue();
        
        this.mapaCuentas.get(id).setTotalPrestamoAdevolver(totalPrestamo);
        this.mapaCuentas.get(id).setPrestamoSolicitado(true);
        
        String mensaje="\n Prestamo realizado correctamente"
        		+ "\n Prestamo a "+plazo+" meses"
        		+ "\n Tasa de intereses a "+ this.tasaIntereses +" %"
        		+ "\n Total a devolver: "+totalPrestamo;
        
		return mensaje;
	}

	private String devolverPrestamo(Integer id, double cantidad) {
		String resultado="";
		double totalAOperar=Math.abs(cantidad);
		double totalPrestamo=this.mapaCuentas.get(id).getTotalPrestamoAdevolver();
		
		
		if(totalAOperar <= this.mapaCuentas.get(id).getSaldoTotal()) {
			
			/*2 casos,
			 1- paga menos del total 
			 2- paga mas del total o lo mismo (se quita prestamo)
			*/ 
	
			String nota="";
			if(totalAOperar < totalPrestamo) {
				this.mapaCuentas.get(id).retirar(totalAOperar);		
				this.mapaCuentas.get(id).pagarPrestamo(totalAOperar);
			}
			else {
				//si paga mas o lo mismo solo le descontaremos lo que quede del prestamo.
				totalAOperar=totalPrestamo;
				this.mapaCuentas.get(id).retirar(totalAOperar);		
				this.mapaCuentas.get(id).setPrestamoSolicitado(false);
				this.mapaCuentas.get(id).setTotalPrestamoAdevolver(0.0);
				nota="Prestamo integramente pagado, muchas gracias por su esfuerzo";
			}
			
			resultado="\n Operacion hecha de forma correcta"
					+ "\n Dinero retirado:"+ totalAOperar
					+ "\n Total del prestamo restante: "+totalPrestamo
					+ "\n Saldo tras operacion: "+this.mapaCuentas.get(id).getSaldoTotal()
					+ "\n "+nota;
		}
		else {
			resultado="Dinero insuficiente en cuenta intentelo con otra cantidad";
		}
		
		return resultado;
	}

	
}
