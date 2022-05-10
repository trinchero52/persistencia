package ar.com.ciu.model;

public class Cliente {
	private Integer id_cliente;
	private String codigo;
	private String apellido;
	private String nombre;

	public Cliente(Integer id_cliente, String elCodigo, String elApellido, String elNombre) {
		super();
		this.id_cliente = id_cliente;
		this.codigo = elCodigo;
		this.apellido = elApellido;
		this.nombre = elNombre;
	}

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
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
