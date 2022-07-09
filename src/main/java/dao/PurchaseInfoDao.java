package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import util.Database;
import vo.ProductInfo;
import vo.PurchaseInfo;
import vo.PurchaseListInfo;

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
			pstmt.setString(5, purchaseInfo.getMessage());
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

	public void updateMessageByProdIdx(String message, int product_prodIdx) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "UPDATE purchase_info SET message = ? WHERE product_prodIdx = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, message);
			pstmt.setInt(2, product_prodIdx);

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
	}

	public PurchaseInfo selectPurchaseInfoByprodIdx(int prodIdx) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		PurchaseInfo purchaseInfo = null;

		try {
			String sql = "SELECT * FROM purchase_info WHERE product_prodIdx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prodIdx);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				int purchaseIdx = rs.getInt("purchaseIdx");
				int member_userIdx = rs.getInt("member_userIdx");
				int product_prodIdx = rs.getInt("product_prodIdx");
				int cart_cartIdx = rs.getInt("cart_cartIdx");
				int cost = rs.getInt("cost");
				String message = rs.getString("message");
				String date = rs.getString("purchaseDate");
				date = date.substring(0, 19);
				date = date.replace(' ', 'T');
				LocalDateTime purchaseDate = LocalDateTime.parse(date);

				purchaseInfo = new PurchaseInfo(purchaseIdx, member_userIdx, product_prodIdx, cart_cartIdx, cost,
						message, purchaseDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}

		return purchaseInfo;
	}

	// 상품의 수를 가져오기 위한 SELECT 쿼리
	public int getCount() {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int count = 0;

		try {
			String sql = "SELECT COUNT(*) AS amount FROM purchase_info";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			rs.next();

			count = rs.getInt("amount");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return count;
	}
}
