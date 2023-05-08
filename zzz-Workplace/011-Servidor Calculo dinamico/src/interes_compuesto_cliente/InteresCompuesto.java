package interes_compuesto_cliente;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import compute.Task;

public class InteresCompuesto implements Task<BigDecimal>, Serializable {

    private static final long serialVersionUID = 227L;

    private BigDecimal montoInicial; 
    private BigDecimal tasaAnual;
    private int anos;
    

	public InteresCompuesto(BigDecimal montoInicial, BigDecimal tasaAnual, int anos) {
		super();
		this.montoInicial = montoInicial;
		this.tasaAnual = tasaAnual;
		this.anos = anos;
	}


	@Override
	public BigDecimal execute() {

	      BigDecimal uno = new BigDecimal("1.00");
	      BigDecimal tasaPeriodo = tasaAnual.divide(new BigDecimal("12.00"), 10, RoundingMode.HALF_UP);
			
	      BigDecimal periodos = new BigDecimal(anos * 12);
	        
		  BigDecimal montoFinal = montoInicial.multiply(uno.add(tasaPeriodo).pow(periodos.intValue()));
		   
		  return montoFinal.setScale(2, RoundingMode.HALF_UP);
	}   
	
}
