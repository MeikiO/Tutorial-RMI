package traspaso_monedas;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;


import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.MonetaryConversions;
import java.math.BigDecimal;
import compute.Task;

public class ConvertidorMonedas implements Task<BigDecimal>, Serializable {

    private static final long serialVersionUID = 227L;

    private BigDecimal montoInicial; 
    private BigDecimal tasaAnual;
    private int anos;
    

	public ConvertidorMonedas(BigDecimal montoInicial, BigDecimal tasaAnual, int anos) {
		super();
		this.montoInicial = montoInicial;
		this.tasaAnual = tasaAnual;
		this.anos = anos;
	}


	@Override
	public BigDecimal execute() {
		// Definir las monedas de origen y destino
        CurrencyUnit from = Monetary.getCurrency("USD");
        CurrencyUnit to = Monetary.getCurrency("EUR");

        // Obtener la tasa de cambio entre las monedas
        CurrencyConversion conversion = MonetaryConversions.getConversion(to);
        BigDecimal exchangeRate = conversion.getExchangeRate(from).getFactor();

        // Calcular el monto convertido
        BigDecimal amount = new BigDecimal("1000.00");
        BigDecimal convertedAmount = amount.multiply(exchangeRate);

        
        
        // Imprimir el resultado
        System.out.println(amount + " " + from.getCurrencyCode() + " = " +
                convertedAmount + " " + to.getCurrencyCode());

        return convertedAmount;
	}   
	
	APLICAR LA LIBRERIA EN ESTE URL
	https://javamoney.github.io/ri.html 
	
}
