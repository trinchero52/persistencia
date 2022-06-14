package ar.com.ciu.model;

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

@Entity(name="Factura")
@Table(name="factura")

public class Factura {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="nativoDeBaseDeDatos")
	private Long id;
	//@Column
	@ManyToOne
	@JoinColumn(name="cliente_id", foreignKey=@ForeignKey(name="factura_id_fk"))
	private Cliente cliente;
	@Column
	private Date fecha;
	@Column
	private int numero;
	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Detalle> detalles;
	
	public Factura() {
		super();
	}
	
	public Factura( Date fecha, int numero) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.detalles = new ArrayList<Detalle>();
	}
	
	// metodos
		@Override
		public int hashCode() {
			return Objects.hash(this.id);
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == this) return true;
			if (!(o instanceof Factura)) {
				return false;
			}
			Factura other = (Factura) o;
			return Objects.equals(this.id, other.getId());
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
