import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

	static Connection con;
	
	public static Connection createC() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			FileSqlReader fr = new FileSqlReader();
			String user = fr.getFile(1);
			String password = fr.getFile(2);
			String url = fr.getFile(0);
			con = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
