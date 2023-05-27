package traspaso_monedas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;


import java.math.BigDecimal;

import compute.Monedas;
import compute.Task;

public class ConvertidorMonedas implements Task<BigDecimal>, Serializable {

    private static final long serialVersionUID = 227L;

    private BigDecimal montoInicial;

	private Monedas moneda; 


	public ConvertidorMonedas(BigDecimal montonInicial, Monedas elegida) {
		this.montoInicial=montonInicial;
		this.moneda=elegida;
	}


	@Override
	public BigDecimal execute() {
		BigDecimal convertedAmount = this.montoInicial.multiply(this.moneda.getValorRepectoAlEuro());
		return convertedAmount.setScale(2, RoundingMode.HALF_UP);
	}   
	

	
}
