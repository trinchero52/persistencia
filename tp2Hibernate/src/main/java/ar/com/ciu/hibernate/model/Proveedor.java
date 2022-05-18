package ar.com.ciu.hibernate.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "Proveedor")
@Table(name = "provedor")
public class Proveedor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="nativoDeBaseDeDatos")
	private Long id;
	@Column
	private String descripcion;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Producto> productos;
	
	public Proveedor() {
		super();
	}
	
	public Proveedor(String descripcion) {
		super();
		this.descripcion = descripcion;
		this.productos = new ArrayList<Producto>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj instanceof Proveedor))
			return false;

		Proveedor other = (Proveedor) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
