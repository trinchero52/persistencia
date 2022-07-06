package ar.com.ciu.persistencia.tp3SpringBoot.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "Frio")
@Table(name = "frio")
@PrimaryKeyJoinColumn(name = "alimento_id")
public class Frio extends Alimento{
	
	private int temperaturaMinima;
	
	private int temperaturaMaxima;
	
	private LocalDate fechaActual;

	public Frio(String codigo, String descripcion, LocalDate fechaDeIngreso, int temperaturaMinima, int temperaturaMaxima, LocalDate fechaActual) {
		super(codigo, descripcion, fechaDeIngreso);
		this.temperaturaMaxima = temperaturaMaxima;
		this.temperaturaMinima = temperaturaMinima;
		this.fechaActual = fechaActual;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected BigDecimal getPrecioFinal() {
	
		 BigDecimal precioFinal = this.getPrecio().getMonto().add(this.getPrecio().getMonto().multiply(new BigDecimal("0.08")));
		 
		 if(this.fechaRestada()) {
			 precioFinal = precioFinal.subtract(this.getPrecio().getMonto().multiply(new BigDecimal("0.5")));
		 }
		 
		 return precioFinal;
	}
	
	public boolean fechaRestada() {
		
	return Math.abs(ChronoUnit.DAYS.between(this.getFechaActual(), this.getFechaDeIngreso())) + 1 >= 5;
		
	}

	public int getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(int temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}

	public int getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(int temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public LocalDate getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(LocalDate fechaActual) {
		this.fechaActual = fechaActual;
	}
	

}
