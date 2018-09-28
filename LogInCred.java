package pendelum_pack;

public class LogInCred {
	private static final String url = "jdbc:sqlserver://localhost:1433;database=Assignment1";
	private static final String user = "sapp";
	private static final String password = "sapp";
	
	public static String getURL(){
		return url;
	}
	public static String getUser(){
		return user;
	}
	public static String getPassword(){
		return password;
	}
}
