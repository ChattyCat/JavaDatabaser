package pendelum_pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class dbConnection {
	
	public Connection getConnection() {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Connection con = DriverManager.getConnection(LogInCred.getURL(), LogInCred.getUser(), LogInCred.getPassword());
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
