package ar.com.ciu.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.CallableStatement;

import ar.com.ciu.model.Cliente;

public class Main {

	private static Connection dbConnection = null;
	
	public static void main(String[] args) {
		try {
			//creo la conexion
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tpventas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			//Lo uso para crear sentencias sql
			Statement statement = dbConnection.createStatement();
			//insert 
			String sql = "INSERT INTO cliente (id_cliente, codigo, apellido, nombre) VALUES (5000,'Lokesh','Gupta','Blabla')";
			statement.executeUpdate(sql);
			//termina de ejecutar la query
			statement.close();
			//cierro la conexion para liberar los recursos
			dbConnection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		}
	}

