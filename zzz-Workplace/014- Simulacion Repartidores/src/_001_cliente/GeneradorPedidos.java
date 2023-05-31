package _001_cliente;

import java.util.Random;
import java.util.UUID;
import commons.Pedido;

public class GeneradorPedidos {

  private String[] listaProductos= {"Normal","Chicken burger","Vegana","Triple deluxe con bacon","La todo"};
  private String[] listaBebidas= {"Agua","Agua con gas","Fanta","Pepsi","Cocacola"};
  private String[] listaEntrantes= {"Ensalada","Patatas","Patatas Deluxe","Nuggets","Patatas Rotas con queso"};
  
  private Random generador;
  
  private String nombreCliente;
  private String tlf;
  private String direccion;
  
  public GeneradorPedidos(String nombreCliente, String tlf, String direccion) {
    super();
    this.nombreCliente = nombreCliente;
    this.tlf = tlf;
    this.direccion = direccion;
    
    this.generador=new Random();
  }
  
  public Pedido generarPedido() {
    String producto=this.listaProductos[this.generador.nextInt(4)];
    String bebidas=this.listaBebidas[this.generador.nextInt(4)];
    String entrantes=this.listaEntrantes[this.generador.nextInt(4)];
    
    UUID id=new UUID(this.generador.nextLong(), this.generador.nextLong());
    
    String contenido = producto+bebidas+entrantes;
    Double total=contenido.length()*0.5;
    
    return new Pedido(id,producto,bebidas,entrantes,total
    ,false, this.nombreCliente,this.tlf,this.direccion);
  }
}
