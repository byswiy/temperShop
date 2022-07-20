package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import util.Database;
import vo.ReviewInfo;
import vo.ReviewJoinPurchase;

public class ReviewInfoDao {
	public boolean insertReview(ReviewInfo reviewInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO review_info(member_id, purchase_idx, contents, insertDate) VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, reviewInfo.getMember_id());
			pstmt.setInt(2, reviewInfo.getPurchase_idx());
			pstmt.setString(3, reviewInfo.getContents());
			pstmt.setString(4, reviewInfo.getInsertDate().toString());
			
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
	
	public List<ReviewJoinPurchase> selectReviewInfo(int pageNumber) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ReviewJoinPurchase> reviewInfoList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM review_info JOIN purchase_info ON review_info.purchase_idx = purchase_info.purchaseIdx ORDER BY reviewIdx DESC LIMIT ?, 10";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, (pageNumber-1)*10);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int reviewIdx = rs.getInt("reviewIdx");
				String member_id = rs.getString("member_id");
				int purchase_idx = rs.getInt("purchase_idx");
				String contents = rs.getString("contents");
				String reviewDate = rs.getString("insertDate");
				reviewDate = reviewDate.substring(0, reviewDate.indexOf('.'));
				reviewDate = reviewDate.replace(' ', 'T');
				LocalDateTime insertDate = LocalDateTime.parse(reviewDate);
				int purchaseIdx = rs.getInt("purchaseIdx");
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
				
				ReviewJoinPurchase reviewInfo = new ReviewJoinPurchase(reviewIdx, member_id, purchase_idx, contents, insertDate,
						purchaseIdx, userIdx, purchaseShopName, purchaseName, purchasePrice, purchaseQuantity, purchaseCost, purchaseSize,
						purchaseColor, message, purchaseImg, purchaseDate);
				
				reviewInfoList.add(reviewInfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return reviewInfoList;
	}
	
	public List<ReviewJoinPurchase> selectReviewInfoId(String userId) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ReviewJoinPurchase> reviewInfoList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM review_info JOIN purchase_info ON review_info.purchase_idx = purchase_info.purchaseIdx WHERE member_id = ? ORDER BY reviewIdx DESC";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int reviewIdx = rs.getInt("reviewIdx");
				int purchase_idx = rs.getInt("purchase_idx");
				String contents = rs.getString("contents");
				String reviewDate = rs.getString("insertDate");
				reviewDate = reviewDate.substring(0, reviewDate.indexOf('.'));
				reviewDate = reviewDate.replace(' ', 'T');
				LocalDateTime insertDate = LocalDateTime.parse(reviewDate);
				int purchaseIdx = rs.getInt("purchaseIdx");
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
				
				ReviewJoinPurchase reviewInfo = new ReviewJoinPurchase(reviewIdx, userId, purchase_idx, contents, insertDate,
						purchaseIdx, userIdx, purchaseShopName, purchaseName, purchasePrice, purchaseQuantity, purchaseCost, purchaseSize,
						purchaseColor, message, purchaseImg, purchaseDate);
				
				reviewInfoList.add(reviewInfo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return reviewInfoList;
	}
	
	public int getAmountReview() {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int amount = 0;
		
		String sql = "SELECT COUNT(*) AS amount FROM review_info";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 공지사항의 갯수의 return 되는 결과가 무조건 있기 때문에
			rs.next();
			
			amount = rs.getInt("amount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return amount;
	}
	
	public int getAmountReviewId(String id) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int amount = 0;
		
		String sql = "SELECT COUNT(*) AS amount FROM review_info WHERE member_id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			// 공지사항의 갯수의 return 되는 결과가 무조건 있기 때문에
			rs.next();
			
			amount = rs.getInt("amount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return amount;
	}
	
	public boolean deleteReviewByReviewIdx(int reviewIdx) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM review_info WHERE reviewIdx = ? ";
		
		boolean result = false;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,	reviewIdx);
			
			int count = pstmt.executeUpdate();
			
			result = count == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return result;
	}
	
	public boolean updateReviewInfo(ReviewInfo reviewInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE review_info SET contents=? WHERE reviewIdx = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reviewInfo.getContents());
			pstmt.setInt(2, reviewInfo.getReviewIdx());
			
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
