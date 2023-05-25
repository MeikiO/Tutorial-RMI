package _003_baul;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

public class Cuenta {
	
	Integer id;
	
	private Double saldoTotal;
	private Map<String,BigDecimal> divisas;
	
	private Double TotalPrestamoAdevolver;
	private boolean prestamoSolicitado;
	
	private Double depositoAPlazos;
	private boolean depositoRealizado;
	
	public Cuenta(Integer id) {
		this.id=id;
		this.saldoTotal=0.0;
		this.divisas=new TreeMap<>();
		
		this.TotalPrestamoAdevolver=0.0;
		this.prestamoSolicitado=false;
		
		this.depositoAPlazos=0.0;
		this.depositoRealizado=false;
		
	}
	public Cuenta(Integer id, Double saldoTotal, Double totalPrestamoAdevolver,
			boolean prestamoSolicitado, Double depositoAPlazos, boolean depositoRealizado) {
		super();
		this.id = id;
		this.saldoTotal = saldoTotal;
		this.divisas=new TreeMap<>();
		TotalPrestamoAdevolver = totalPrestamoAdevolver;
		this.prestamoSolicitado = prestamoSolicitado;
		this.depositoAPlazos = depositoAPlazos;
		this.depositoRealizado = depositoRealizado;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getSaldoTotal() {
		return saldoTotal;
	}
	public void setSaldoTotal(Double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}
	public Map<String, BigDecimal> getDivisas() {
		return divisas;
	}
	public void setDivisas(Map<String, BigDecimal> divisas) {
		this.divisas = divisas;
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
	public Double getDepositoAPlazos() {
		return depositoAPlazos;
	}
	public void setDepositoAPlazos(Double depositoAPlazos) {
		this.depositoAPlazos = depositoAPlazos;
	}
	public boolean isDepositoRealizado() {
		return depositoRealizado;
	}
	public void setDepositoRealizado(boolean depositoRealizado) {
		this.depositoRealizado = depositoRealizado;
	}
	
}
