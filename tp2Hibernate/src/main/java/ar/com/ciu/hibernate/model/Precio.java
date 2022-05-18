package ar.com.ciu.hibernate.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Precio")
@Table(name = "precio")
public class Precio {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="nativoDeBaseDeDatos")
	private Long id;
	@Column
	private double monto;
	@Column
	private Date fecha;

	@OneToOne(mappedBy="precio", cascade=CascadeType.ALL)

	private Producto producto;

	public Precio() {
		super();
	}
	
	public Precio(double monto, Date fecha) {
		super();
		this.monto = monto;
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Precio))
			return false;

		Precio other = (Precio) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}
