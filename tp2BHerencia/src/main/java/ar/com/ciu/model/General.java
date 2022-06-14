package ar.com.ciu.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name="General")
@Table(name="general")
@PrimaryKeyJoinColumn(name = "producto_id")
public class General extends Producto{
	private Integer peso;
	public General(String codigo, String descripcion,Integer peso) {
		super(codigo,descripcion);
		this.peso = peso;
	}

	
	public Integer getPeso() {
		return peso;
	}


	public void setPeso(Integer peso) {
		this.peso = peso;
	}


	@Override
	public BigDecimal getPrecioFinal() {
		if(this.peso >= 2 && this.peso <= 4) {
			return (this.getPrecio().getMonto().multiply(new BigDecimal(0.04)).add(this.getPrecio().getMonto()));
		} else if (this.peso >= 4 && this.peso <= 7) {
			return (this.getPrecio().getMonto().multiply(new BigDecimal(0.07)).add(this.getPrecio().getMonto()));
		} else if (this.peso > 7) {
			return (this.getPrecio().getMonto().multiply(new BigDecimal(0.12)).add(this.getPrecio().getMonto()));
		}
		return this.getPrecio().getMonto();
	}


	@Override
	public String toString() {
		return "General [peso=" + peso + ", descripcion=" + descripcion + ", precio=" + precio.getMonto() + "]";
	}
	
	
	
}
