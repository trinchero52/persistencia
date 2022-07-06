package ar.com.ciu.persistencia.tp3SpringBoot.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "Gondola")
@Table(name = "gondola")
@PrimaryKeyJoinColumn(name = "alimento_id")
public class Gondola extends Alimento{

	private int volumen;
	
	public Gondola(String codigo, String descripcion, LocalDate fechaDeIngreso, int volumen) {
		super(codigo, descripcion, fechaDeIngreso);
		this.volumen = volumen;
	}

	@Override
	protected BigDecimal getPrecioFinal() {
		if(this.getVolumen() > 400) {
		return this.getPrecio().getMonto().add(this.getPrecio().getMonto().multiply(new BigDecimal("0.03")));
		}
		return this.getPrecio().getMonto();
		
	}

	public int getVolumen() {
		return volumen;
	}

	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}
	
	

}
