package ar.com.ciu.model;

public class Producto {
	private Integer id_producto;
    private String codigo; 
    private String descripcion;
    private Integer id_precio;
    
    public Producto(Integer id_producto, String codigo, String descripcion, Integer id_precio) {
    	super();
    	this.id_producto = id_producto;
    	this.codigo = codigo;
    	this.descripcion = descripcion;
    	this.id_precio = id_precio;
	}

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
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

	public Integer getId_precio() {
		return id_precio;
	}

	public void setId_precio(Integer id_precio) {
		this.id_precio = id_precio;
	}
    
    
}
