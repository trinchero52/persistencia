package ar.com.ciu.persistencia.tp3SpringBoot.dto;

import ar.com.ciu.persistencia.tp3SpringBoot.model.Cliente;
import ar.com.ciu.persistencia.tp3SpringBoot.model.Cuenta;

public class ClienteDTO {

	private Long id;
	private String codigo;
	private String apellido;
	private String nombre;
	private Cuenta cuenta;
	private String nroCuenta;
	//private Long cuentaId;
	private Cliente cliente;

	// constructores
	public ClienteDTO(String codigo, String apellido, String nombre) {
		super();
		this.codigo = codigo;
		this.apellido = apellido;
		this.nombre = nombre;
		
	}

	public ClienteDTO(Cliente cliente) {
		this(cliente.getCodigo(), cliente.getApellido(), cliente.getNombre());
		this.id = cliente.getId();
		//this.cuentaId = cliente.getCuenta().getId();
		this.setCliente(cliente);
		cliente.setCuenta(cuenta);
	}
	
	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

//	public Long getCuentaId() {
//		return cuentaId;
//	}
//
//	public void setCuentaId(Long cuentaId) {
//		this.cuentaId = cuentaId;
//	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "ClienteDTO [id=" + id + ", codigo=" + codigo + ", apellido=" + apellido + ", nombre=" + nombre
				+ ", cuenta=" + cuenta + ", nroCuenta=" + nroCuenta + ", cliente=" + cliente + "]";
	}
	
	

}
