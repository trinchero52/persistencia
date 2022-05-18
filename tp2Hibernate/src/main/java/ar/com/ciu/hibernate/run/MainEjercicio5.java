package ar.com.ciu.hibernate.run;

import java.util.Date;

import org.hibernate.Session;

import ar.com.ciu.hibernate.model.Cliente;
import ar.com.ciu.hibernate.model.Cuenta;
import ar.com.ciu.hibernate.model.Detalle;
import ar.com.ciu.hibernate.model.Factura;
import ar.com.ciu.hibernate.model.Precio;
import ar.com.ciu.hibernate.model.Producto;
import ar.com.ciu.hibernate.model.Proveedor;

public class MainEjercicio5 {
	
	
	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("123", "pepe", "sanz");
		Cliente cliente2 = new Cliente("124", "tomas", "trinchero");
		Cliente cliente3 = new Cliente("125", "carlos", "ramon");
		Cuenta cuenta1 = new Cuenta("123");
		cliente1.setCuenta(cuenta1);
		Proveedor proveedor1 = new Proveedor("coca cola");
		Proveedor proveedor2 = new Proveedor("cigarros");
		Producto producto1 = new Producto("12", "bici");
		producto1.getProveedores().add(proveedor1);
		Producto producto2 = new Producto("90", "moto");
		producto2.getProveedores().add(proveedor1);
		producto2.getProveedores().add(proveedor2);
		//Date fecha1 = new Date();
		Precio precio1 = new Precio(120.0, new Date(10052022));
		Precio precio2 = new Precio(150.0, new Date(20052023));
		producto1.setPrecio(precio1);
		Factura factura1 = new Factura(new Date(10052022), 1);
		factura1.setCliente(cliente3);
		Detalle detalle1 = new Detalle(5);
		detalle1.setFactura(factura1);
		detalle1.setProducto(producto2);
		
		producto1.cargarPrecio(precio2);
		/*6) Realizar un método que de alta a un Proveedor, sin asignar productos al mismo, crear
		más de un proveedor*/
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			session.persist(cliente1);
			session.persist(cliente2);
			session.persist(cliente3);
			session.persist(cuenta1);
			session.persist(proveedor1);
			session.persist(proveedor2);
			session.persist(producto1);
			session.persist(producto2);
			session.persist(precio1);
			session.persist(precio2);
			session.persist(factura1);
			session.persist(detalle1);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		HibernateUtil.getSessionFactory().close();
	}

}
