import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Order {
	enum Choose {
		ITEMLIST(1), BUYITEM(2), SHOPPINGLIST(3), CANCELBUY(4), EXITSHOP(5);

		private int value;

		private Choose(int value) {
			this.value = value;
		}
	}

	private static final int ITEMLIST = 1;
	private static final int BUYITEM = 2;
	private static final int SHOPPINGLIST = 3;
	private static final int CANCELBUY = 4;

	public static void main(String[] args)
			throws NumberFormatException, IOException, SQLException, ClassNotFoundException {
		System.out.println("온라인 쇼핑몰에 오신걸 환영합니다");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("1번 누르면 상품 리스트 봅니다.");
			System.out.println("2번 누르면 상품을 장바구니에 넣습니다.");
			System.out.println("3번 누르면 장바구니에 담긴 리스트 확인.");
			System.out.println("4번 누르면 장바구니 비우기를 합니다.");
			System.out.println("5번 누르면 온라인쇼핑몰에서 나가집니다.");
			int c = Integer.parseInt(br.readLine());

			if (c == ITEMLIST) {
				OrderDao.showAllItem();
			} else if (c == BUYITEM) {
				System.out.println("원하는 아이템 이름을 입력하세요");
				String name = br.readLine();
				System.out.println("원하는 아이템 가격을 입력하세요");
				int price = Integer.parseInt(br.readLine());

				OrderItem oi = new OrderItem(name, price);
				boolean answer = OrderDao.insertItemToDB(oi);

				System.out.println(oi);

				if (answer) {
					System.out.println("성공적으로 쇼핑카트에 집어 넣었습니다");
				} else {
					System.out.println("뭔가 에러가 발생했습니다.....");
				}
			} else if (c == SHOPPINGLIST) {
				OrderDao.showShoppingList();
				
				
			} else if (c == CANCELBUY) {
				OrderDao.deleteShoppingDB();
				System.out.println("성공적으로 쇼핑카트가 비워집니다");
				System.out.println("=========================");
			} else if (c == 5) {
				break;
			} else {
				throw new NumberFormatException();
			}

		}
	}

}
