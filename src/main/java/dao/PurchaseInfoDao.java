package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import util.Database;
import vo.PurchaseInfo;
import vo.ReviewInfo;

public class PurchaseInfoDao {

	// 구매 정보를 삽입하기 위한 INSERT 쿼리
	public boolean insertPurchaseInfo(PurchaseInfo purchaseInfo) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO purchase_info(userIdx, purchaseShopName, purchaseName, purchasePrice, purchaseQuantity, purchaseCost, purchaseSize, "
					   + "purchaseColor, message, purchaseImg, purchaseDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, purchaseInfo.getUserIdx());
			pstmt.setString(2, purchaseInfo.getPurchaseShopName());
			pstmt.setString(3, purchaseInfo.getPurchaseName());
			pstmt.setInt(4, purchaseInfo.getPurchasePrice());
			pstmt.setInt(5, purchaseInfo.getPurchaseQuantity());
			pstmt.setInt(6, purchaseInfo.getPurchaseCost());
			pstmt.setString(7, purchaseInfo.getPurchaseSize());
			pstmt.setString(8, purchaseInfo.getPurchaseColor());
			pstmt.setString(9, purchaseInfo.getMessage());
			pstmt.setString(10, purchaseInfo.getPurchaseImg());
			pstmt.setString(11, purchaseInfo.getPurchaseDate().toString());

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

	public boolean updateMessageByProdIdx(String message, String purchaseDate) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "UPDATE purchase_info SET message = ? WHERE purchaseDate = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, message);
			pstmt.setString(2, purchaseDate);

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

	public PurchaseInfo selectPurchaseInfoByUseIdx(int userIdx) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		PurchaseInfo purchaseInfo = null;

		try {
			String sql = "SELECT * FROM purchase_info WHERE userIdx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userIdx);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				int purchaseIdx = rs.getInt("purchaseIdx");
				String purchaseShopName = rs.getString("purchaseShopName");
				String purchaseName = rs.getString("purchaseName");
				int purchasePrice = rs.getInt("purchasePrice");
				int purchaseQuantity = rs.getInt("purchaseQuantity");
				int purchaseCost = rs.getInt("purchaseCost");
				String purchaseSize = rs.getString("purchaseSize");
				String purchaseColor = rs.getString("purchaseColor");
				String message = rs.getString("message");
				String purchaseImg = rs.getString("purchaseImg");
				String date = rs.getString("purchaseDate");
				date = date.substring(0, date.indexOf('.'));
				date = date.replace(' ', 'T');
				LocalDateTime purchaseDate = LocalDateTime.parse(date);
				
				purchaseInfo = new PurchaseInfo(purchaseIdx, userIdx, purchaseShopName, purchaseName, purchasePrice, purchaseQuantity, purchaseCost,
															    purchaseSize, purchaseColor, message, purchaseImg, purchaseDate);
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
	
	public PurchaseInfo selectBypurchaseIdx(int purchaseIdx) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		PurchaseInfo purchaseInfo = null;

		try {
			String sql = "SELECT * FROM purchase_info WHERE purchaseIdx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, purchaseIdx);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				int userIdx = rs.getInt("userIdx");
				String purchaseShopName = rs.getString("purchaseShopName");
				String purchaseName = rs.getString("purchaseName");
				int purchasePrice = rs.getInt("purchasePrice");
				int purchaseQuantity = rs.getInt("purchaseQuantity");
				int purchaseCost = rs.getInt("purchaseCost");
				String purchaseSize = rs.getString("purchaseSize");
				String purchaseColor = rs.getString("purchaseColor");
				String message = rs.getString("message");
				String purchaseImg = rs.getString("purchaseImg");
				String date = rs.getString("purchaseDate");
				date = date.substring(0, date.indexOf('.'));
				date = date.replace(' ', 'T');
				LocalDateTime purchaseDate = LocalDateTime.parse(date);
				
				purchaseInfo = new PurchaseInfo(purchaseIdx, userIdx, purchaseShopName, purchaseName, purchasePrice, purchaseQuantity, purchaseCost,
															    purchaseSize, purchaseColor, message, purchaseImg, purchaseDate);
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
	
	public List<PurchaseInfo> selectByUserIdx(int userIdx) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<PurchaseInfo> purchaseInfoList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM purchase_info WHERE userIdx = ? ORDER BY  purchaseDate DESC";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, userIdx);
			
			rs = pstmt.executeQuery();
			
			// 결과가 있을 수도 있고 없을 수도 있기 때문에
			// while을 사용해서 결과가 있을 때까지 동작하도록 한다
			while(rs.next()) {
				int purchaseIdx = rs.getInt("purchaseIdx");
				String purchaseShopName = rs.getString("purchaseShopName");
				String purchaseName = rs.getString("purchaseName");
				int purchasePrice = rs.getInt("purchasePrice");
				int purchaseQuantity = rs.getInt("purchaseQuantity");
				int purchaseCost = rs.getInt("purchaseCost");
				String purchaseSize = rs.getString("purchaseSize");
				String purchaseColor = rs.getString("purchaseColor");
				String message = rs.getString("message");
				String purchaseImg = rs.getString("purchaseImg");
				String date = rs.getString("purchaseDate");
				date = date.substring(0, date.indexOf('.'));
				date = date.replace(' ', 'T');
				LocalDateTime purchaseDate = LocalDateTime.parse(date);
				
				PurchaseInfo nthPurchaseInfo = new PurchaseInfo(purchaseIdx, userIdx, purchaseShopName, purchaseName, purchasePrice, purchaseQuantity, purchaseCost,
															    purchaseSize, purchaseColor, message, purchaseImg, purchaseDate);
				
				purchaseInfoList.add(nthPurchaseInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		
		return purchaseInfoList;
	}
	
	public boolean deletePurchaseIdx(String purchaseDate) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "DELETE FROM purchase_info WHERE purchaseDate = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, purchaseDate);

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
