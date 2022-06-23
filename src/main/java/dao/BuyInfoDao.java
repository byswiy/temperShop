package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.Database;
import vo.PurchaseInfo;

public class BuyInfoDao {
	
	// 구매 정보를 삽입하기 위한 INSERT 쿼리
	public boolean insertBuyInfo(PurchaseInfo buyInfo) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO buy_info(member_userIdx, product_prodIdx, cost, buyDate) VALUES (?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, buyInfo.getUserIdx());
			pstmt.setInt(2, buyInfo.getProdIdx());
			pstmt.setInt(3, buyInfo.getCost());
			pstmt.setString(4, buyInfo.getBuyDate().toString());
			
			int count = pstmt.executeUpdate();

			return count == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return false;
	}
}
