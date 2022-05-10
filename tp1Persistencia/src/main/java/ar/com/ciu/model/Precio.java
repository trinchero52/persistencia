package ar.com.ciu.model;

import java.util.Date;

public class Precio {
	private Integer id_precio;
    private Double monto; 
    private Date fecha;
    private Integer id_producto;
    
    public Precio(Integer id_precio, Double monto, Date fecha, Integer id_producto) {
		super();
		this.id_precio = id_precio;
		this.monto = monto;
		this.fecha = fecha;
		this.id_producto = id_producto;
	}

	public Integer getId_precio() {
		return id_precio;
	}

	public void setId_precio(Integer id_precio) {
		this.id_precio = id_precio;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}
    
    
}
