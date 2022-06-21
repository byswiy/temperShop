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
	// 후기에 관한 데이터를 List로 묶어주는 select 쿼리
	public List<ReviewInfo> selectReviewInfo() {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 후기 정보를 하나로 묶어주기 위해 List 사용
		List<ReviewInfo> reviewInfoList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM product_review ORDER BY reviewIdx DESC LIMIT 10";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int reviewIdx = rs.getInt("reviewIdxl");
				int userIdx = rs.getInt("member_userIdx");
				int prodIdx = rs.getInt("product_prodIdx");
				String contents = rs.getString("contents");
				String date = rs.getString("insertDate");
				date = date.substring(0, 19);
				date = date.replace(' ', 'T');
				LocalDateTime insertDate = LocalDateTime.parse(date);
				
				ReviewInfo reviewInfo = new ReviewInfo();
				reviewInfo.setReviewIdx(reviewIdx);
				reviewInfo.setMember_userIdx(userIdx);
				reviewInfo.setProduct_prodIdx(prodIdx);
				reviewInfo.setContents(contents);
				reviewInfo.setInsertDate(insertDate);
				
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
	
	// 후기의 갯수를 가져오는 쿼리
	public int getAmountReview() {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int amount = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS amount FROM product_review";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			
			amount = rs.getInt("amount");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		
		return amount;
	}
	
	// 후기 작성 insert 쿼리
	public boolean insertReview(ReviewInfo reviewInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO product_review(reviewIdx, member_userIdx, product_prodIdx, contents, insertDate) VALUES (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewInfo.getReviewIdx());
			pstmt.setInt(2, reviewInfo.getMember_userIdx());
			pstmt.setInt(3, reviewInfo.getProduct_prodIdx());
			pstmt.setString(4, reviewInfo.getContents());
			pstmt.setString(5, reviewInfo.getInsertDate().toString());
			
			int count = pstmt.executeUpdate();
			
			return count == 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}	
		return false;
	}
	
	// reviewIdx를 사용해 해당 후기를 select하는 쿼리
	public ReviewInfo selectReviewIdx(int reviewIdx) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ReviewInfo reviewInfo = null;
		
		try {
			String sql = "SELECT * FROM product_review WHERE reviewIdx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reviewIdx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int member_userIdx = rs.getInt("member_userIdx");
				int product_prodIdx = rs.getInt("product_prodIdx");
				String contents = rs.getString("contents");
				String date = rs.getString("insertDate");
				date = date.substring(0, 19);
				date = date.replace(' ', 'T');
				LocalDateTime insertDate = LocalDateTime.parse(date);
				
				reviewInfo = new ReviewInfo(reviewIdx, member_userIdx, product_prodIdx, contents, insertDate);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		
		return reviewInfo;
	}
	
	// reviewIdx를 사용해 delete하는 쿼리
	public boolean deleteReviewByReviewIdx(int reviewIdx) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		boolean result = false;
		
		try {
			String sql = "DELETE FROM product_review WHERE reviewIdx = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reviewIdx);
			
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
}
