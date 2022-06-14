package ar.com.ciu.run;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;

import org.hibernate.Session;

import ar.com.ciu.model.Alimento;
import ar.com.ciu.model.Cliente;
import ar.com.ciu.model.Congelado;
import ar.com.ciu.model.Cuenta;
import ar.com.ciu.model.Detalle;
import ar.com.ciu.model.Factura;
import ar.com.ciu.model.Frio;
import ar.com.ciu.model.General;
import ar.com.ciu.model.Gondola;
import ar.com.ciu.model.Precio;
import ar.com.ciu.model.Producto;
import ar.com.ciu.model.Proveedor;

public class Main {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("123", "pepe", "sanz");
		Cliente cliente2 = new Cliente("124", "tomas", "trinchero");
		Cliente cliente3 = new Cliente("125", "carlos", "ramon");
		Cuenta cuenta1 = new Cuenta("123");
		cliente1.setCuenta(cuenta1);
		Proveedor proveedor1 = new Proveedor("coca cola");
		Proveedor proveedor2 = new Proveedor("cigarros");
		General general1 = new General("12", "bici general", 500);
		General general2 = new General("20", "pescado general", 300);

		general1.getProveedores().add(proveedor1);
		Frio frio1 = new Frio("155", "frio 1", LocalDate.now(), 50, 100);
		frio1.getProveedores().add(proveedor1);
		frio1.getProveedores().add(proveedor2);
		// Date fecha1 = new Date();
		Precio precio1 = new Precio(new BigDecimal(1600.0), new Date(10052022));
		Precio precio2 = new Precio(new BigDecimal(90.0), new Date(20052023));
		general2.getProveedores().add(proveedor2);
		general2.setPrecio(precio2);
		general1.setPrecio(precio1);
		Factura factura1 = new Factura(new Date(10052022), 1);
		factura1.setCliente(cliente3);
		Detalle detalle1 = new Detalle(5);
		detalle1.setFactura(factura1);
		detalle1.setProducto(frio1);
		Precio precio3 = new Precio(new BigDecimal(190.0), new Date(20052023));
		Precio precio4 = new Precio(new BigDecimal(290.0), new Date(20052023));
		Precio precio5 = new Precio(new BigDecimal(290.0), new Date(20052023));
		// general1.cargarPrecio(precio2);
		Gondola gondola1 = new Gondola("180", "gondola 1", LocalDate.now(), 5);
		gondola1.setPrecio(precio3);
		frio1.setPrecio(precio4);
		Congelado congelado1 = new Congelado("290", "congelado1", LocalDate.now());
		congelado1.setPrecio(precio5);
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.persist(cliente1);
			session.persist(cliente2);
			session.persist(cliente3);
			session.persist(cuenta1);
			session.persist(proveedor1);
			session.persist(proveedor2);
			session.persist(general1);
			session.persist(general2);
			session.persist(frio1);
			session.persist(precio1);
			session.persist(precio2);
			session.persist(precio3);
			session.persist(precio4);
			session.persist(precio5);
			session.persist(factura1);
			session.persist(detalle1);
			session.persist(gondola1);
			session.persist(congelado1);
			session.getTransaction().commit();
			// punto 2)a)
			/*
			 * System.out.print("            ------  productos  ------              ");
			 * Query query = session.createQuery("from Producto");
			 * 
			 * @SuppressWarnings("unchecked") List<Producto> productos =
			 * query.getResultList(); productos.stream().forEach( p ->
			 * System.out.print(p.toString())); //punto 2)b)
			 * System.out.print("            ------  alimentos  ------              ");
			 * Query query2 = session.createQuery("from Alimento");
			 * 
			 * @SuppressWarnings("unchecked") List<Alimento> alimentos =
			 * query2.getResultList(); alimentos.stream().forEach( a ->
			 * System.out.print(a.toString()));
			 */
			// punto 2)c)
			/*
			 * System.out.print("------- gondolas actuales----------------"); Query query3 =
			 * session.createQuery("from Gondola");
			 * 
			 * @SuppressWarnings("unchecked") List<Gondola> gondolas =
			 * query3.getResultList(); gondolas.stream().forEach(a ->
			 * System.out.print(a.toString())); //punto 2)d)
			 * 
			 */
			System.out.print("------- general que cumple requisito----------------");
			Query queryGeneralesConPesoMayorA400 = session.createQuery("from General where peso > 400");
			@SuppressWarnings("unchecked")

			List<General> generalesConPesoMayorA400 = queryGeneralesConPesoMayorA400.getResultList();
			List<General> generalesFiltrados = generalesConPesoMayorA400.stream()
					.filter(g -> g.getPrecioFinal().compareTo(new BigDecimal("1500.00")) == 1)
					.collect(Collectors.toList());
			generalesFiltrados.stream().forEach(g -> System.out.println(g.toString()));
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

		HibernateUtil.getSessionFactory().close();
	}

}
