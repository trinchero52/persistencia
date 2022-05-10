package ar.com.ciu.statementCallable;

//import com.mysql.cj.jdbc.CallableStatement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import ar.com.ciu.model.Factura;
import ar.com.ciu.model.Factura_Producto;

public class Main {

	private static Connection dbConnection = null;

	private static double calculoTotalFactura(Factura_Producto[] facturas) throws SQLException {
		double total = 0;
		String sqlTotal = "select monto from producto inner join precio on producto.id_precio = precio.id_precio where producto.id_producto = ?";
		for (Factura_Producto factura : facturas) {
			PreparedStatement preparedStatement = dbConnection.prepareStatement(sqlTotal);
			preparedStatement.setInt(1, factura.getId_producto());

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				double subTotal = rs.getDouble(1);// preguntar por getDouble
				total += subTotal;
			}
		}
		return total;
	}

	private static int crearFactura(Factura factura) throws SQLException {
		String query = "{call nueva_factura(?, ?, ?, ?)}";
		CallableStatement cs = dbConnection.prepareCall(query);
		cs.setInt(1, factura.getId_cliente());
		cs.setDate(2, new java.sql.Date(factura.getFecha().getTime()));
		cs.setInt(3, factura.getNumero());
		cs.registerOutParameter(4, Types.INTEGER);
		cs.execute();
		int idFactura = cs.getInt(4);
		cs.close();
		factura.setId_factura(idFactura);
		return idFactura;
	}

	private static void crearProducto(int idFactura, Factura_Producto[] fps) throws SQLException {
		String queryFP = "{call nuevo_factura_producto(?, ?, ?)}";
		CallableStatement cs = dbConnection.prepareCall(queryFP);
		for (Factura_Producto fp : fps) {
			cs.setInt(1, idFactura);
			cs.setInt(2, fp.getId_producto());
			cs.setInt(3, fp.getCantidad());
			cs.execute();
		}
		cs.close();
	}

	public static void main(String[] args) {
		try {
			// conexion
			Class.forName("com.mysql.cj.jdbc.Driver");
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpventas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");


			// productos
			Factura_Producto fps[] = new Factura_Producto[3];
			fps[0] = new Factura_Producto(90, 9, 1);
			fps[1] = new Factura_Producto(90, 3, 1);
			fps[2] = new Factura_Producto(90, 14, 1);

			// precio total
			double total = calculoTotalFactura(fps);
			System.out.println("el total: " + total);

			if (total <= 100) {
				System.out.println("el total que se intenta facturar es " + total + ", menor que 100");
				return;
			} 
			
			// factura
			Factura factura = new Factura(90, 420, new Date(), 20);
			int idFactura = crearFactura(factura);
			System.out.println("idFactura: " + idFactura);
			// productos
			crearProducto(idFactura, fps);
			dbConnection.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
