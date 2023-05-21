package goodsDataStorage;

import java.util.List;

import Dto.GoodsDto;

//간단하게 Dao CRUD를 진행하는 곳이다.
public interface GoodsDao {
	GoodsDto insertGoods(GoodsDto goods);
	
	GoodsDto selectGoods(int goodsNumber); //상품 선택 (read)
	
	boolean updateGoods(GoodsDto goods); // 상품 수정 (updata)
	
	boolean deleteGoods(int goodsNumber); // 상품 삭제  (delete)
	
	List<GoodsDto> selectAllGoods(); //모든 상품 조회

 }
