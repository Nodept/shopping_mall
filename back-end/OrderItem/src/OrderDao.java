import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDao {
	private static Connection con = null;
	
	public static void showAllItem() throws SQLException {
//		boolean = f = false;
		
		try {
			Connection con = JDBC.createC();
			// 상품 검색
			String q = "select * from goods;";
			
			Statement stmt = con.createStatement();
			stmt.executeQuery(q);
			
			java.sql.ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String info = set.getString(3);
				int price = set.getInt(4);
				
				System.out.println("ID : " + id);
				System.out.println("Item Name : " + name);
				System.out.println("Item Info : " + name);
				System.out.println("Price : " + price);
				System.out.println("==========================");
			}
//		f = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			// try-with-resources 추가
		} finally {
			 if (con != null) con.close();
		}
	}
}
