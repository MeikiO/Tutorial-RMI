package compute;

import java.math.BigDecimal;

public enum Monedas {
	DOLAR_ESTADOUNIDENSE("Dolar Estadounidense(USD)",1.0959424),
	YEN_JAPONES("Yen japones(JPY)",148.12668),
	LIBRA_ESTERLINA("libra esterlina (GBP)",0.8679377),
	DOLAR_AUSTRALIANO("El dólar australiano (AUD)",1.6222528),
	DOLAR_CANADIENSE("El dólar canadiense (CAD)",1.467672),
	FRANCO_SUIZO("franco suizo (CHF)",0.97517718),
	RENMINBI_CHINO("renminbi chino (CNY)",7.5848824),
	DOLAR_HONGKONES("dólar hongkonés (HKD)",8.5845438),
	DOLAR_NEOZELANDES("dólar neozelandés (NZD)",1.7295122),;

	private BigDecimal valorRepectoAlEuro;
	private String nombre;

	Monedas(String string, double d) {
		this.nombre=string;
		this.valorRepectoAlEuro=new BigDecimal(d);
	}

	public BigDecimal getValorRepectoAlEuro() {
		return valorRepectoAlEuro;
	}

	public String getNombre() {
		return nombre;
	}
	
}
