package cliente;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import compute.Monedas;
import compute.Task;

public class Transaccion implements Task<BigDecimal>, Serializable {

    private static final long serialVersionUID = 227L;

    private BigDecimal montonInicial;

	private Monedas moneda; 

	public Transaccion(BigDecimal montonInicial, Monedas elegida) {
		this.montonInicial=montonInicial;
		this.moneda=elegida;
	}

	@Override
	public BigDecimal execute() {
		BigDecimal convertedAmount = this.montonInicial.multiply(this.moneda.getValorRepectoAlEuro());
		return convertedAmount.setScale(2, RoundingMode.HALF_UP);
	}   
}
