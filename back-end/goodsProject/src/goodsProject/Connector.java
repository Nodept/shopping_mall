package goodsProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	private static final SqlConnectionData sqlData = new SqlConnectionData();
	private static final String dbUrl = sqlData.getFile(0); // your database url
	private static final String username = sqlData.getFile(1); // your database username
	private static final String password = sqlData.getFile(2); // your database password

	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(dbUrl,username,password);
	}
	
}
