package ar.com.ciu.persistencia.tp3SpringBoot.dto;

import ar.com.ciu.persistencia.tp3SpringBoot.model.Cuenta;

public class CuentaDTO {
	private Long id;
	private String numero;
	private Cuenta cuenta;
	
	
	public CuentaDTO(String numero) {
		super();
		this.numero = numero;
		
	}
	
	public CuentaDTO(Cuenta cuenta) {
		this(
			cuenta.getNumero()
				);
		this.id = cuenta.getId();
		this.setCuenta(cuenta);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "CuentaDTO [id=" + id + ", numero=" + numero + ", cuenta=" + cuenta + "]";
	}
	
	
}
