package pendelum_pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class dbConnection {
	static final String url = "jdbc:sqlserver://localhost:1433;database=******;";
	static final String user = "sapp";
	static final String password = "sapp";
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
