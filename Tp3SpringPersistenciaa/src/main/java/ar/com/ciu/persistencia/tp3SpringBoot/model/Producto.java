package ar.com.ciu.persistencia.tp3SpringBoot.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "Producto")
@Table(name = "producto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Producto {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="nativoDeBaseDeDatos")
	@GenericGenerator(name="nativoDeBaseDeDatos", strategy="native")
	protected Long id;
	
	@Column
	protected String codigo;
	
	@Column
	protected String descripcion;
	
	
	@OneToOne
	@JoinColumn(name = "precioHistorico_id", foreignKey=@ForeignKey(name="producto_precio_historico_id_fk"))
	protected Precio precioHistorico;
	
	@OneToOne
	@JoinColumn(name = "precio_id", foreignKey=@ForeignKey(name="producto_precio_id_fk"))
	protected Precio precio;
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	protected List<Proveedor> proveedores;

	public Producto(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.proveedores = new ArrayList<Proveedor>();
		
	}
	
	protected abstract BigDecimal getPrecioFinal();
	
	public void cargarPrecio( Precio precio) {
		if (this.getPrecio() == null) {
			this.setPrecio(precio);
		} else {
			Precio precioHistorico = this.getPrecio();
			this.setPrecioHistorico(precioHistorico);
			this.precio = precio;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Producto))
			return false;

		Producto other = (Producto) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Precio getPrecio() {
		return precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Precio getPrecioHistorico() {
		return precioHistorico;
	}

	public void setPrecioHistorico(Precio precioHistorico) {
		this.precioHistorico = precioHistorico;
	}

	@Override
	public String toString() {
		return "Producto [descripcion=" + descripcion + "]";
	}

	
	
	

}
