package ar.com.ciu.persistencia.tp3SpringBoot.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.ciu.persistencia.tp3SpringBoot.model.Cliente;
import ar.com.ciu.persistencia.tp3SpringBoot.model.Factura;

public class FacturaDTO {
	private Long id;
	private Long idCliente;
	private Cliente cliente;
	private Date fecha;
	private int numero;
	private Factura factura;
	
	private List<DetalleDTO> detallesDTO;
	public FacturaDTO(Date fecha, int numero) {
		super();
		this.fecha = fecha;
		this.numero = numero;
		this.detallesDTO = new ArrayList<DetalleDTO>();
	}
	public FacturaDTO(Factura factura) {
		this(factura.getFecha(), factura.getNumero());
		this.setFactura(factura);
		this.id = factura.getId();
		factura.setCliente(cliente);
		this.idCliente = factura.getCliente().getId();
		factura.getDetalles().stream().forEach(d -> this.detallesDTO.add(new DetalleDTO(d)));
	}
	
	public Factura getFactura() {
		return factura;
	}
	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
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
	public List<DetalleDTO> getDetallesDTO() {
		return detallesDTO;
	}
	public void setDetallesDTO(List<DetalleDTO> detallesDTO) {
		this.detallesDTO = detallesDTO;
	}
	@Override
	public String toString() {
		return "FacturaDTO [id=" + id + ", idCliente=" + idCliente + ", cliente=" + cliente + ", fecha=" + fecha
				+ ", numero=" + numero + ", factura=" + factura + ", detallesDTO=" + detallesDTO + "]";
	}
	
	
	
	
}