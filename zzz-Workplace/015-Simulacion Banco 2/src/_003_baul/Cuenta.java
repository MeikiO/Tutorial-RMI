package _003_baul;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class Cuenta {
	
	Integer id;
	
	private BigDecimal saldoTotal;
	
	private Double TotalPrestamoAdevolver;
	private boolean prestamoSolicitado;

	
	public Cuenta(Integer id) {
		this.id=id;
		this.saldoTotal=new BigDecimal("0.0");
		
		this.TotalPrestamoAdevolver=0.0;
		this.prestamoSolicitado=false;		
	}
	public Cuenta(Integer id, BigDecimal saldoTotal, Double totalPrestamoAdevolver,
			boolean prestamoSolicitado) {
		super();
		this.id = id;
		this.saldoTotal = saldoTotal;
		TotalPrestamoAdevolver = totalPrestamoAdevolver;
		this.prestamoSolicitado = prestamoSolicitado;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void ingresar(Double cantidad) {
		this.setSaldoTotal(cantidad+this.getSaldoTotal());
	}
	
	public void retirar(Double cantidad) {
		this.setSaldoTotal(this.getSaldoTotal()-cantidad);
	}
	
	public Double getSaldoTotal() {
		return this.saldoTotal.setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
	public void setSaldoTotal(Double saldoTotal) {
		this.saldoTotal = new BigDecimal(""+saldoTotal);
	}
	public void pagarPrestamo(Double cantidad) {
		this.setTotalPrestamoAdevolver(this.getTotalPrestamoAdevolver()-cantidad);
	}
	public Double getTotalPrestamoAdevolver() {
		return TotalPrestamoAdevolver;
	}
	public void setTotalPrestamoAdevolver(Double totalPrestamoAdevolver) {
		TotalPrestamoAdevolver = totalPrestamoAdevolver;
	}
	public boolean isPrestamoSolicitado() {
		return prestamoSolicitado;
	}
	public void setPrestamoSolicitado(boolean prestamoSolicitado) {
		this.prestamoSolicitado = prestamoSolicitado;
	}
	
}
