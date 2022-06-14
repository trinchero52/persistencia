package ar.com.ciu.persistencia.market.dto;

import ar.com.ciu.persistencia.market.model.Cliente;

public class ClienteDTO {

	private Long id;
	private String codigo;
	private String apellido;
	private String nombre;
	// constructores
	public ClienteDTO(String apellido, String nombre, String codigo) {
		super();
		this.codigo = codigo;
		this.apellido = apellido;
		this.nombre = nombre;
		
	}
	public ClienteDTO(Cliente cliente) {
		this(cliente.getCodigo(),
			 cliente.getApellido(),
			 cliente.getNombre());
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

	
	
}
