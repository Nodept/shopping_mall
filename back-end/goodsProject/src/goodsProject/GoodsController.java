package goodsProject;

import java.util.List;
import java.util.Scanner;

import Dto.GoodsDto;
import goodsDataStorage.GoodsDao;
import goodsDataStorage.GoodsDaolmpl;

public class GoodsController {
	private final GoodsDaolmpl goodsDao = new GoodsDaolmpl();
	private final GoodsView goodsview = new GoodsView();

	private final Scanner sc = new Scanner(System.in);

	public void createGoods() {
		// 이름 정보 가

		goodsview.enterGoodsName();
		String goodsName = sc.nextLine();

		goodsview.enterGoodsInfo();
		String goodsInfo = sc.nextLine();

		goodsview.enterGoodsPrice();
		int goodsPrice = sc.nextInt();

		GoodsDto newgoods = new GoodsDto();
		newgoods.setGoodsName(goodsName);
		newgoods.setGoodsInfo(goodsInfo);
		newgoods.setGoodsPrice(goodsPrice);

		int goodsNumeber = goodsDao.insertGoods(newgoods).getGoodsNumber();
		newgoods.setGoodsNumber(goodsNumeber);
	}

	public void getGoods() {
		goodsview.enterGoodsNumber();
		int goodsNumber = sc.nextInt();
		GoodsDto goods = goodsDao.selectGoods(goodsNumber);

		if (goods != null) {
			goodsview.displayGoods(goods);
		} else {
			goodsview.displayGoodsNoExist();
		}
	}

	public void getAllGoods() {
		List<GoodsDto> goods = goodsDao.selectAllGoods();
		goodsview.displayAllgoods(goods);
	}

	public void updateGoods() {
		goodsview.enterGoodsNumber();
		int goodsNumber = sc.nextInt();

		goodsview.enterGoodsName();
		String goodsName = sc.next();

		goodsview.enterGoodsPrice();
		int goodsPrice = sc.nextInt();

		goodsview.enterGoodsInfo();
		String goodsInfo = sc.next();

		GoodsDto goods = new GoodsDto();
		goods.setGoodsNumber(goodsNumber);
		goods.setGoodsName(goodsName);
		goods.setGoodsInfo(goodsInfo);
		goods.setGoodsPrice(goodsPrice);

		if (goodsDao.updateGoods(goods)) {
			goodsview.updateSucess();
		} else {
			goodsview.updateFailed();
		}
	}

	public void deleteGoods() {
		System.out.println("Enter Post Number:");
		int goodsNumber = sc.nextInt();

		if (goodsDao.deleteGoods(goodsNumber)) {
			goodsview.deleteSucess();
		} else {
			goodsview.deleteFailed();
		}
	}
}
