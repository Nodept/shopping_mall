import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Order {
	enum Choose {
		ITEMLIST(1), BUYITEM(2), CANCELBUY(3), EXITSHOP(4);
		private int value;
		private Choose(int value) {
			this.value = value;
		}
	}

	private static final int ITEMLIST = 1;

	public static void main(String[] args) throws NumberFormatException, IOException, SQLException {
		System.out.println("온라인 쇼핑몰에 오신걸 환영합니다");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			System.out.println("1번 누르면 상품 리스트 봅니다.");
			System.out.println("2번 누르면 상품 구매합니다.");
			System.out.println("3번 누르면 상품 구매취소 합니다.");
			System.out.println("4번 누르면 온라인쇼핑몰에서 나가집니다.");
			int c = Integer.parseInt(br.readLine());
			
			
			
			if (c == ITEMLIST) {
				OrderDao.showAllItem();
			} else if (c == 2) {

			} else if (c == 3) {

			} else if (c == 4) {
				break;
			} else {
				throw new NumberFormatException();
			}

		}
	}

	

}
