import java.util.Scanner;

import goodsProject.GoodsController;

public class GoodsMakeMain {
	private static final Scanner sc = new Scanner(System.in);
	private static final GoodsController goodscon = new GoodsController();

	public static void main(String[] args) {

		boolean flag = true;
		while (flag) {
			System.out.println("\n1. 상품 등록");
			System.out.println("2. 상품 조회");
			System.out.println("3. 모든 상품 조회");
			System.out.println("4. 상품 수정");
			System.out.println("5. 상품 삭제");
			System.out.println("6. 종료");
			System.out.println("메뉴 입력:");

			int option = sc.nextInt();
			switch (option) {
			case 1:
				goodscon.createGoods();
				break;
			case 2:
				goodscon.getGoods();
				break;
			case 3:
				goodscon.getAllGoods();
				break;
			case 4:
				goodscon.updateGoods();
				break;
			case 5:
				goodscon.deleteGoods();
				break;
			case 6:
				flag = false;
				break;

			default:
				break;
			}
		}
	}

}
