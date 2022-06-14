package ar.com.ciu.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "Gondola")
@Table(name = "gondola")
@PrimaryKeyJoinColumn(name = "alimento_id")
public class Gondola extends Alimento{
	@Column
	private Integer volumen;
	
	public Gondola(String codigo, String descripcion , LocalDate fechaDeIngreso, Integer volumen) {
		super(codigo,descripcion,fechaDeIngreso);
		this.volumen = volumen;
	}

	public Integer getVolumen() {
		return volumen;
	}

	public void setVolumen(Integer volumen) {
		this.volumen = volumen;
	}

	@Override
	public BigDecimal getPrecioFinal() {
		if(this.volumen > 400) {
			return  (this.getPrecio().getMonto().multiply(new BigDecimal(0.03)).add(this.getPrecio().getMonto()));
		} else {
			return this.getPrecio().getMonto();
		}
		
	}

	@Override
	public String toString() {
		return "Gondola [descripcion=" + descripcion + "]";
	}
	 
}
