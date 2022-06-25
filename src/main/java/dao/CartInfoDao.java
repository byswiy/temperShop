package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import util.Database;
import vo.CartInfo;
import vo.ProductInfo;

public class CartInfoDao {
	// 장바구니 정보를 삽압하는 insert 쿼리
	public boolean insertCartInfo(CartInfo cartInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO cart_info(cartIdx, member_userIdx, product_prodIdx) VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cartInfo.getCartIdx());
			pstmt.setInt(2, cartInfo.getMember_userIdx());
			pstmt.setInt(3, cartInfo.getProduct_prodIdx());
			
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
	
	// 장바구니에 필요한 상품 번호를 select하는 쿼리
	public ProductInfo selectProdIdx(int product_prodIdx) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ProductInfo productInfo = null;
		
		try {
			String sql = "SELECT * FROM product_info WHERE prodIdx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_prodIdx);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String prodName = rs.getString("prodName");
				int prodPrice = rs.getInt("prodPrice");
				int prodStock = rs.getInt("prodStock");
				int prodQuantity = rs.getInt("prodQuantity");
				String prodSize = rs.getString("prodSize");
				String prodColor = rs.getString("prodColor");
				String prodCategory = rs.getString("prodCategory");
				String prodImg = rs.getString("prodImg");
				String date = rs.getString("insertDate");
				date = date.substring(0, date.indexOf('.'));
				date = date.replace(' ', 'T');
				LocalDateTime regDate = LocalDateTime.parse(date);
				
				productInfo = new ProductInfo(product_prodIdx, prodName, prodPrice, prodStock, prodQuantity, prodSize, prodColor, prodCategory, prodImg, regDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		
		return productInfo;
		
	}
	
	// 장바구니의 갯수를 가져오는 쿼리
	public int getAmountCart() {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		int amount = 0;

		try {
			String sql = "SELECT COUNT(*) AS amount FROM cart_info";

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
	
	// cartIdx를 사용해 delete하는 쿼리
	public boolean deleteCartIdx (int cartIdx) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "DELETE FROM cart_info WHERE cartIdx = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cartIdx);

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
