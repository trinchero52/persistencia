package ar.com.ciu.persistencia.tp3SpringBoot.dto;

import ar.com.ciu.persistencia.tp3SpringBoot.model.Detalle;
import ar.com.ciu.persistencia.tp3SpringBoot.model.Factura;
import ar.com.ciu.persistencia.tp3SpringBoot.model.Precio;
import ar.com.ciu.persistencia.tp3SpringBoot.model.Producto;

public class DetalleDTO {
	private Long id;
	private Long idProducto;
	private Long idFactura;
	private Integer cantidad;
	private Long idPrecio;
	private Detalle detalle;

	public DetalleDTO(Integer cantidad) {
		super();
		this.cantidad = cantidad;
	}

	public DetalleDTO(Detalle detalle) {
		this(detalle.getCantidad());
		this.setDetalle(detalle);
		this.id = detalle.getId();
		this.idProducto = detalle.getProducto().getId();
		this.idPrecio = detalle.getPrecio().getId();
		this.idFactura = detalle.getFactura().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Long getIdPrecio() {
		return idPrecio;
	}

	public void setIdPrecio(Long idPrecio) {
		this.idPrecio = idPrecio;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	
}
