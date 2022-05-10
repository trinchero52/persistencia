package ar.com.ciu.hibernate.run;

import org.hibernate.Session;

import ar.com.ciu.hibernate.model.Cliente;
import ar.com.ciu.hibernate.model.Cuenta;

public class MainEjercicio5 {
	
	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("123", "pepe", "sanz");
		Cliente cliente2 = new Cliente("124", "tomas", "trinchero");
		Cliente cliente3 = new Cliente("125", "carlos", "ramon");
		Cuenta cuenta1 = new Cuenta("123");
		cliente1.setCuenta(cuenta1);
		
		/*6) Realizar un método que de alta a un Proveedor, sin asignar productos al mismo, crear
más de un proveedor*/
		
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		try {
			session.beginTransaction();
			session.persist(torta);
			session.persist(tortaFrita);
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
