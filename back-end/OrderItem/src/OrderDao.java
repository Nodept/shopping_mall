import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderDao {

	public static void showAllItem() throws SQLException {
//		boolean = f = false;
		
		try {
			Connection con = JDBC.createC();
			// 상품 검색
			String q = "select * from item_list;";
			
			Statement stmt = con.createStatement();
			stmt.executeQuery(q);
			
			java.sql.ResultSet set = stmt.executeQuery(q);
			
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				int price = set.getInt(3);
				
				System.out.println("ID : " + id);
				System.out.println("Item Name : " + name);
				System.out.println("Price : " + price);
				System.out.println("==========================");
				
				
			}
//		f = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
