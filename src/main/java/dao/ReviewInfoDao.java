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

public class ReviewInfoDao {
	public boolean insertReview(ReviewInfo reviewInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO review_info(member_userIdx, product_prodIdx, contents, insertDate) VALUES (?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewInfo.getMember_userIdx());
			pstmt.setInt(2, reviewInfo.getProduct_prodIdx());
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
	
	public List<ReviewInfo> selectReviewInfo(int pageNumber) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ReviewInfo> reviewInfoList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM review_info ORDER BY reviewIdx DESC LIMIT ?, 5";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, (pageNumber-1)*5);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int member_userIdx = rs.getInt("member_userIdx");
				int product_prodIdx = rs.getInt("product_prodIdx");
				String contents = rs.getString("contents");
				String date = rs.getString("insertDate");
				date = date.substring(0, date.indexOf('.'));
				date = date.replace(' ', 'T');
				LocalDateTime insertDate = LocalDateTime.parse(date);
				
				ReviewInfo reviewInfo = new ReviewInfo(member_userIdx, product_prodIdx, contents, insertDate);
				
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
