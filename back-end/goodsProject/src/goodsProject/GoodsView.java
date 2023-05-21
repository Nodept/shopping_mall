package goodsProject;

import java.util.List;

import Dto.GoodsDto;

public class GoodsView {

	

	public void enterGoodsName() {
		System.out.println("Enter GoodsName : ");
	}

	public void enterGoodsInfo() {
		System.out.println("Enter GoodsInfo : ");
	}

	public void enterGoodsPrice() {
		System.out.println("Enter GoodsPrice : ");
	}

	public void createSuccess(GoodsDto goods) {
		System.out.println("상품이 성공적으로 생성되었습니다. 게시물의 아이디는 다음과 같습니다: " + goods.getGoodsNumber());
	}

	public void enterGoodsNumber() {
		System.out.println("Enter goods Number : ");
	}

	public void displayGoods(GoodsDto goods) {
		System.out.println("\n상품 번호 : " + goods.getGoodsNumber());
		System.out.println("상품 이름 : " + goods.getGoodsName());
		System.out.println("상품 가격 : " + goods.getGoodsPrice());
		System.out.println("상품 정보 : " + goods.getGoodsInfo());
	}

	public void displayGoodsNoExist() {
		System.out.println("상품이 없습니다. 추가 추 조회 해주세요");
	}

	public void displayAllgoods(List<GoodsDto> good) {
		for (GoodsDto goods : good) {
			displayGoods(goods);
			System.out.println("---------");
		}
	}

	public void updateSucess() {
		System.out.println("상품이 업데이트 되었습니다.");
	}

	public void updateFailed() {
		System.out.println("상품이 업데이트가 실패되었습니다.");
	}

	public void deleteSucess() {
		System.out.println("상품이 삭제 되었습니다.");
	}

	public void deleteFailed() {
		System.out.println("상품 삭제가 실패되었습니다.");
	}
}
