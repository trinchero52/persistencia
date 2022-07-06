package ar.com.ciu.persistencia.tp3SpringBoot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Factura")
@Table(name = "factura")
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="nativoDeBaseDeDatos")
	@GenericGenerator(name="nativoDeBaseDeDatos", strategy="native")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", foreignKey = @ForeignKey(name = "factura_cliente_id_fk"))
	private Cliente cliente;
	
	@Column
	private Date fecha;
	
	@Column
	private int numero;
	
	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Detalle> detalles;
	
	public Factura( Date fecha, int numero) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.detalles = new ArrayList<Detalle>();
	}
	
	public void agregarDetalle(Producto prod, int cant) {
		Detalle detalle = new Detalle(cant);
		detalle.setFactura(this);
		detalle.setProducto(prod);
		detalle.setPrecio(prod.getPrecio());
		detalles.add(detalle);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Factura))
			return false;
		Factura other = (Factura) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public List<Detalle> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}
	
}
