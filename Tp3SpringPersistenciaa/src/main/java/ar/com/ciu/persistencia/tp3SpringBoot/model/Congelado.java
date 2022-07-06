package ar.com.ciu.persistencia.tp3SpringBoot.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "Congelado")
@Table(name = "congelado")
@PrimaryKeyJoinColumn(name = "alimento_id")
public class Congelado extends Alimento{

	public Congelado(String codigo, String descripcion, LocalDate fechaDeIngreso) {
		super(codigo, descripcion, fechaDeIngreso);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected BigDecimal getPrecioFinal() {
		return this.getPrecio().getMonto().add(this.getPrecio().getMonto().multiply(new BigDecimal("0.05")));
	}

}
