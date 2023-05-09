package interes_compuesto_cliente;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import compute.Task;

public class InteresCompuesto implements Task<BigDecimal>, Serializable {

    private static final long serialVersionUID = 227L;



    
	private double tasaInteresAnual;

	private int tiempoAnos;

	private double montonInicial;

	private int vecesCapitalizacionAno;
    

	public InteresCompuesto(double p, int t, double r, int n) {
		super();
		this.montonInicial=p;
		this.tiempoAnos=t;
		this.tasaInteresAnual=r;
		this.vecesCapitalizacionAno=n;
	}


	@Override
	public BigDecimal execute() {

        double amount = montonInicial * Math.pow(1 + (tasaInteresAnual / vecesCapitalizacionAno), vecesCapitalizacionAno * tiempoAnos);
        double cinterest = amount - montonInicial;
        System.out.println("Compound Interest after " + tiempoAnos + " years: "+cinterest);
        System.out.println("Amount after " + tiempoAnos + " years: "+amount);
		return new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP);
	}   
	
}
