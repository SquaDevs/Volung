package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/projeto","root", "IANGA12ian");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}