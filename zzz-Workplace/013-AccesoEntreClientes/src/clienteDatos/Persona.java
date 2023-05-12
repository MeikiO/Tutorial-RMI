package clienteDatos;

import java.io.Serializable;
import java.math.BigDecimal;

import compute.Task;

public class Persona implements Serializable{
	int id;
	String nombre;
	Integer cantidad;
	public Persona(int id, String nombre, Integer cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	@Override
	public String toString() {
	
		return this.id+" "+this.nombre+" "+this.cantidad;
	}
	
	
}
