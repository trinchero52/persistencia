package ar.com.ciu.persistencia.tp3SpringBoot.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "General")
@Table(name = "general")
@PrimaryKeyJoinColumn(name = "alimento_id")
public class General extends Producto{
	
	private int peso;

	public General(String codigo, String descripcion, int peso) {
		super(codigo, descripcion);
		this.peso = peso;
	}

	@Override
	protected BigDecimal getPrecioFinal() {
		if(peso >= 2 && peso <=4 ) {
			return this.getPrecio().getMonto().add(this.getPrecio().getMonto().multiply(new BigDecimal("0.04")));
		}
		else if(peso >=4 && peso <= 7) {
			return this.getPrecio().getMonto().add(this.getPrecio().getMonto().multiply(new BigDecimal("0.07")));
		}
		else if(peso > 7) {
			return this.getPrecio().getMonto().add(this.getPrecio().getMonto().multiply(new BigDecimal("0.12")));
		}
		return this.getPrecio().getMonto();
		
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	

}
