package commons;

import java.io.Serializable;
import java.util.UUID;

public class Pedido implements Serializable {
    
    private UUID id;
    private String producto;
    private String bebidas;
    private String entrantes;
    
    private Double totalCosto;
    private boolean estado;
    
    private String nombreCliente;
    private String tlf;
    private String Direccion;
   
    public Pedido(UUID id, String producto, String bebidas, String entrantes, Double totalCosto, boolean estado,
        String nombreCliente, String tlf, String direccion) {
      super();
      this.id = id;
      this.producto = producto;
      this.bebidas = bebidas;
      this.entrantes = entrantes;
      this.totalCosto = totalCosto;
      this.estado = estado;
      this.nombreCliente = nombreCliente;
      this.tlf = tlf;
      Direccion = direccion;
    }


    public UUID getId() {
      return id;
    }

    public void setId(UUID id) {
      this.id = id;
    }

    public String getProducto() {
      return producto;
    }

    public void setProducto(String producto) {
      this.producto = producto;
    }

    public String getBebidas() {
      return bebidas;
    }

    public void setBebidas(String bebidas) {
      this.bebidas = bebidas;
    }

    public String getEntrantes() {
      return entrantes;
    }

    public void setEntrantes(String entrantes) {
      this.entrantes = entrantes;
    }

    public Double getTotalCosto() {
      return totalCosto;
    }

    public void setTotalCosto(Double totalCosto) {
      this.totalCosto = totalCosto;
    }

    public boolean isEstado() {
      return estado;
    }

    public void setEstado(boolean estado) {
      this.estado = estado;
    }

    public String getNombreCliente() {
      return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
      this.nombreCliente = nombreCliente;
    }

    public String getTlf() {
      return tlf;
    }

    public void setTlf(String tlf) {
      this.tlf = tlf;
    }

    public String getDireccion() {
      return Direccion;
    }

    public void setDireccion(String direccion) {
      Direccion = direccion;
    }


    @Override
    public String toString() {
      return "Pedido [id=" + id + ", producto=" + producto + ", bebidas=" + bebidas + ", entrantes=" + entrantes
          + ", totalCosto=" + totalCosto + ", estado=" + estado + ", nombreCliente=" + nombreCliente + ", tlf=" + tlf
          + ", Direccion=" + Direccion + "]";
    }
    
    
    
}
