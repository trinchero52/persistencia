package ar.com.ciu.statementPrepared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import ar.com.ciu.model.Precio;

public class Main {

	private static Connection dbConnection = null;

	public static void main(String[] args) {
		try {
			Date fecha = new Date();
			Precio precio = new Precio(1000, 100.5, fecha, 1223);
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpventas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			String query="INSERT INTO precio (id_precio, monto, fecha, id_producto) VALUES (?, ?, ?, ?)";
	        PreparedStatement preparedStatement;
	        preparedStatement = dbConnection.prepareStatement(query);
	        preparedStatement.setInt(1, precio.getId_precio());
	        preparedStatement.setDouble(2, precio.getMonto());
	        preparedStatement.setDate(3, new java.sql.Date(precio.getFecha().getTime()));
	        preparedStatement.setInt(4, precio.getId_producto());
	        preparedStatement.executeUpdate();
	        
	        String query2 = "UPDATE producto SET id_precio = ? WHERE id_producto = ?";
	        preparedStatement = dbConnection.prepareStatement(query2);
	        preparedStatement.setInt(1, 1000);
	        preparedStatement.setInt(2, 1223);
	        preparedStatement.executeUpdate();
	        preparedStatement.close();
	        dbConnection.close();
	        System.out.println("HOLA ");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
	}

}
