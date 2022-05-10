package ar.com.ciu.hibernate.model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="Detalle")
@Table(name="detalle")
public class Detalle {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="nativoDeBaseDeDatos")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "factura_id", foreignKey=@ForeignKey(name="detalle_factura_id_fk"))
	@Column
	private Factura factura;
	@Column
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "producto_id")
	private Producto producto;
	@Column
	private int Cantidad;
	@Column
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "precio_id")
	private Precio precio;

	public Detalle() {
		super();
	}
	
	public Detalle(int cantidad) {
		super();
		Cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Detalle))
			return false;
		Detalle other = (Detalle) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return Cantidad;
	}

	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}

	public Precio getPrecio() {
		return precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}

}
