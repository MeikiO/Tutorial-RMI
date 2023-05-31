package _001_cliente;

import java.io.Serializable;
import compute.Task;

public class Ordenes implements Task<String>,Serializable {

    private static final long serialVersionUID = 227L;

   private String ordenMandada;
   
	public Ordenes(String ordenMandada) {
		super();
		this.ordenMandada = ordenMandada;
	}

	@Override
	public String recibirOrden() {
		return this.ordenMandada;
	}
}
