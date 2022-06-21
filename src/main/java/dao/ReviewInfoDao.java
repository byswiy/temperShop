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
				String date = rs.getString("joinDate");
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
}
