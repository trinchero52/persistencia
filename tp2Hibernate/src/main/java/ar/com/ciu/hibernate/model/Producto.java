package ar.com.ciu.hibernate.model;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;

import ar.com.ciu.hibernate.run.HibernateUtil;

@Entity(name = "Producto")
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="nativoDeBaseDeDatos")
	private Long id;
	@Column
	private String codigo;
	@Column
	private String descripcion;
	@OneToOne
	@JoinColumn(name = "precio_id", foreignKey=@ForeignKey(name="producto_id_fk"))
	private Precio precio;
	@OneToOne
	@JoinColumn(name = "precioHistorico_id", foreignKey=@ForeignKey(name="producto_id_fk"))
	private Precio precioHistorico;
	@ManyToMany(mappedBy="productos")
	private List<Proveedor> proveedores;

	public Producto() {
		super();
	}
	public Producto(String codigo, String descripcion) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.proveedores = new ArrayList<Proveedor>();
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
	
	public void cargarPrecio(Precio precio) {
		if(this.precio == null) {
			this.setPrecio(precio);
		} else {
			Precio precioHistorico = this.getPrecio();
			this.setPrecioHistorico(precioHistorico);
			this.setPrecio(precio);
		}
	}
	public Precio getPrecioHistorico() {
		return precioHistorico;
	}
	public void setPrecioHistorico(Precio precioHistorico) {
		this.precioHistorico = precioHistorico;
	}

}
