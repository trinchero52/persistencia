package ar.com.ciu.model;

import java.util.Date;

public class Factura {
	private Integer id_factura;
    private Integer id_cliente;
    private Date fecha;
    private Integer numero;
     
    public Factura(Integer id_factura, Integer id_cliente, Date fecha, Integer numero) {
    	super();
    	this.id_factura = id_factura;
    	this.id_cliente = id_cliente;
    	this.fecha = fecha;
    	this.numero = numero;
	}

	public Integer getId_factura() {
		return id_factura;
	}

	public void setId_factura(Integer id_factura) {
		this.id_factura = id_factura;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
    
}
