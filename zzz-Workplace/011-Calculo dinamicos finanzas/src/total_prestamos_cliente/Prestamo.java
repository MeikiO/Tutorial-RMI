package total_prestamos_cliente;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

import compute.Task;

public class Prestamo implements Task<BigDecimal>, Serializable {

    private static final long serialVersionUID = 227L;

    private BigDecimal precio; 
    private BigDecimal tasaInteres;
    private BigDecimal plazo;
    

	public Prestamo(BigDecimal precio, BigDecimal tasaInteres, BigDecimal plazo) {
		super();
		this.precio = precio;
		this.tasaInteres = tasaInteres;
		this.plazo = plazo;
	}

	@Override
	public BigDecimal execute() {
        BigDecimal interes = precio.multiply(tasaInteres).multiply(plazo);
        BigDecimal total = precio.add(interes);
        
        System.out.println("Interés: " + interes);
        System.out.println("Total: " + total);
        
        return total.setScale(2, RoundingMode.HALF_UP);
	}

    
    
}
