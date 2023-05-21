package Dto;

//상품 정보 
//DTO = Data Transfer Object 즉, 데이터만 저장한는 공간 아무런 비즈니스 로직이 존재하면 안된다.
public class GoodsDto {
	private int goodsNumber; // 상품번호(primary key)
	private String goodsName; // 상품이룸
	private String goodsInfo; // 상품정보
	private int goodsCnt; // 상품개수
	private int goodsPrice; // 상품가격

	public int getGoodsNumber() {
		return goodsNumber;
	}

	public void setGoodsNumber(int goodsNumber) {
		this.goodsNumber = goodsNumber;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public int getGoodsCnt() {
		return goodsCnt;
	}

	public void setGoodsCnt(int goodsCnt) {
		this.goodsCnt = goodsCnt;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

}
