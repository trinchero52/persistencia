package ar.com.ciu.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity(name = "Alimento")
@Table(name = "alimento")
@PrimaryKeyJoinColumn(name = "producto_id")

public abstract class Alimento extends Producto{
	@Column
	protected LocalDate fechaDeIngreso;

	public Alimento(String codigo, String descripcion, LocalDate fechaDeIngreso) {
		super(codigo, descripcion);
		this.fechaDeIngreso = fechaDeIngreso;
	}

	public LocalDate getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}

	@Override
	public String toString() {
		return "Alimento [descripcion=" + descripcion + "]";
	}

	
}
