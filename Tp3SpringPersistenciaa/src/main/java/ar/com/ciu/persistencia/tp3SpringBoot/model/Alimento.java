package ar.com.ciu.persistencia.tp3SpringBoot.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "Alimento")
@Table(name = "alimento")
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "alimento_id")
public abstract class Alimento extends Producto{
	
	protected LocalDate fechaDeIngreso;

	public Alimento(String codigo, String descripcion, LocalDate fechaDeIngreso) {
		super(codigo, descripcion);
		this.fechaDeIngreso = fechaDeIngreso;
	}

	@Override
	protected abstract BigDecimal getPrecioFinal();

	public LocalDate getFechaDeIngreso() {
		return fechaDeIngreso;
	}

	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	
	

}
