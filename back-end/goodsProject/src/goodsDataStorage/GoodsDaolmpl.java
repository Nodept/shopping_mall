package goodsDataStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Dto.GoodsDto;
import goodsProject.Connector;

public class GoodsDaolmpl implements GoodsDao {
	private final Connector dbConnector = new Connector();

	// 제품 생성
	@Override
	public GoodsDto insertGoods(GoodsDto goods) {
		String sql = "INSERT INTO goods (name, info, price) VALUES (?, ?, ?)";

		// try-with-resource를 이용해서 자원 반환
		try (Connection con = dbConnector.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstmt.setString(1, goods.getGoodsName());
			pstmt.setString(2, goods.getGoodsInfo());
			pstmt.setInt(3, goods.getGoodsPrice());
			pstmt.executeUpdate();
			// 이 부분이 이해가 안되요
			try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					int goodsNumber = generatedKeys.getInt(1);
					goods.setGoodsNumber(goodsNumber);
				} else {
					throw new SQLException("제품 생성에 실패했습니다.");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return goods;
	}

	@Override
	public GoodsDto selectGoods(int goodsNumber) {
		String sql = "SELECT * FROM goods WHERE number = ?";
		try (Connection con = dbConnector.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, goodsNumber);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				GoodsDto goods = new GoodsDto();
				goods.setGoodsNumber(rs.getInt("Number"));
				goods.setGoodsInfo(rs.getString("info"));
				goods.setGoodsName(rs.getString("Name"));
				goods.setGoodsPrice(rs.getInt("Price"));
				return goods;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateGoods(GoodsDto goods) {
		String sql = "UPDATE goods SET name = ?, info = ?, price = ? WHERE number = ?";
		try (Connection con = dbConnector.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, goods.getGoodsName());
			pstmt.setString(2, goods.getGoodsInfo());
			pstmt.setInt(3, goods.getGoodsPrice());
			pstmt.setInt(4, goods.getGoodsNumber());
			int updatedRows = pstmt.executeUpdate();
			return updatedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteGoods(int goodsNumber) {
		String sql = "DELETE FROM goods WHERE number = ?";
		try (Connection con = dbConnector.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, goodsNumber);
			int deletedRows = pstmt.executeUpdate();
			return deletedRows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<GoodsDto> selectAllGoods() {
		List<GoodsDto> goods = new ArrayList<>();
		String sql = "SELECT * FROM goods";
		try (Connection con = dbConnector.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				GoodsDto good = new GoodsDto();
				good.setGoodsNumber(rs.getInt("Number"));
				good.setGoodsInfo(rs.getString("info"));
				good.setGoodsName(rs.getString("Name"));
				good.setGoodsPrice(rs.getInt("Price"));
				goods.add(good);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goods;
	}

}
