package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.Database;
import vo.PurchaseInfo;

public class PurchaseInfoDao {
	
	// 구매 정보를 삽입하기 위한 INSERT 쿼리
	public boolean insertPurchaseInfo(PurchaseInfo purchaseInfo) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO purchase_info(member_userIdx, product_prodIdx, cart_cartIdx, cost, message, purchaseDate) VALUES (?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, purchaseInfo.getMember_userIdx());
			pstmt.setInt(2, purchaseInfo.getProduct_prodIdx());
			pstmt.setInt(3, purchaseInfo.getCart_cartIdx());
			pstmt.setInt(4, purchaseInfo.getCost());
			pstmt.setString(5, purchaseInfo.getMessage().toString());
			pstmt.setString(6, purchaseInfo.getPurchaseDate().toString());
			
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
	
	public boolean deletePurchaseIdx(int purchaseIdx) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM purchase_info WHERE purchaseIdx = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, purchaseIdx);
			
			int count = pstmt.executeUpdate();
			
			return count == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		
		return false;
	}
}
