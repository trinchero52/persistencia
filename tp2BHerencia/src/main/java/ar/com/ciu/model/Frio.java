package ar.com.ciu.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name="Frio")
@Table(name="frio")
@PrimaryKeyJoinColumn(name = "alimento_id")
public class Frio extends Alimento{
	@Column
	private Integer temperaturaMinima;
	@Column
	private Integer temperaturaMaxima;

	public Frio(String codigo, String descripcion,LocalDate fechaDeIngreso, Integer temperaturaMinima, Integer temperaturaMaxima) {
		super(codigo,descripcion,fechaDeIngreso);
		this.temperaturaMinima = temperaturaMinima;
		this.temperaturaMaxima = temperaturaMaxima;
	}


	@Override
	public BigDecimal getPrecioFinal() {
		BigDecimal precioBase = (this.getPrecio().getMonto().multiply(new BigDecimal(0.05)).add(this.getPrecio().getMonto()));
		LocalDate fechaActual = LocalDate.now();
		if(Math.abs(ChronoUnit.DAYS.between(fechaActual, this.getFechaDeIngreso())) + 1 >= 5) {
			precioBase.subtract(new BigDecimal(0.50));
		}
		return precioBase;
	}


	public Integer getTemperaturaMinima() {
		return temperaturaMinima;
	}


	public void setTemperaturaMinima(Integer temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}


	public Integer getTemperaturaMaxima() {
		return temperaturaMaxima;
	}


	public void setTemperaturaMaxima(Integer temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}
	
}
