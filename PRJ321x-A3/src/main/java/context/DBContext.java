package context;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;

public class DBContext {
	private final String serverName = "localhost";
	private final String dbName = "ShoppingDataBase";
	private final String portNumber = "1433";
	private final String userID = "sa";
	private final String password = "1234";

	/*Sử dụng phương thức bên dưới để cho database kết nối tới máy chủ */
	public Connection getConnection() throws Exception {

		
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ":databaseName=" + dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		/* String sql = "dsa";
		 * ResultSet result = DriverManager.getConnection(url, userID, password).prepareStatement(sql).executeQuery(); */
		
		return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ShoppingDataBase;user=sa;password=1234;");
	}
}
