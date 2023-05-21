import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public static boolean insertItemToDB(OrderItem oi) throws ClassNotFoundException, IOException {

		// jdbc code...
		boolean f = false;
		try {

			Connection con = JDBC.createC();
			String q = "insert into shopping_cart(name, price) values(?,?)";

			// preparedStatement
			PreparedStatement psmt = con.prepareStatement(q);

			// set the value of parameters
			psmt.setString(1, oi.getItemName());
			psmt.setLong(2, oi.getItemPrice());

			// execute...
			psmt.executeUpdate();
			f = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;

	}
}
