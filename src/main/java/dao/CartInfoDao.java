package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import util.Database;
import vo.CartInfo;
import vo.CartJoinProduct;

public class CartInfoDao {
	// 장바구니 정보를 삽압하는 insert 쿼리
	public boolean insertCartInfo(CartInfo cartInfo) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO cart_info(member_userIdx, product_prodIdx, quantity) VALUES(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cartInfo.getMember_userIdx());
			pstmt.setInt(2, cartInfo.getProduct_prodIdx());
			pstmt.setInt(3, cartInfo.getQuantity());

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
	public boolean deleteCartIdx(int cartIdx) {
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

	public CartInfo selectCartIdx(int cartIdx) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		CartInfo cartInfo = null;

		try {
			String sql = "SELECT * FROM cart_info WHERE cartIdx = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cartIdx);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				int member_userIdx = rs.getInt("member_userIdx");
				int product_prodIdx = rs.getInt("product_prodIdx");
				int quantity = rs.getInt("quantity");

				cartInfo = new CartInfo(member_userIdx, product_prodIdx, quantity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}

		return cartInfo;
	}

	// 장바구니 정보를 수정하는 UPDATE 쿼리
	public boolean updateCartInfo(CartInfo cartInfo) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "UPDATE cart_info SET quantity = ? WHERE cartIdx = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cartInfo.getQuantity());
			pstmt.setInt(2, cartInfo.getCartIdx());

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
	
	public List<CartJoinProduct> selectUserIdx(int member_userIdx) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<CartJoinProduct> cartInfoList = new ArrayList<>();

		try {
			String sql = "SELECT * FROM cart_info JOIN product_info ON cart_info.product_prodIdx = product_info.prodIdx WHERE member_userIdx = ? ORDER BY cartIdx DESC";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, member_userIdx);

			rs = pstmt.executeQuery();

			while(rs.next()) {
				int cartIdx = rs.getInt("cartIdx");
				int product_prodIdx = rs.getInt("product_prodIdx");
				int quantity = rs.getInt("quantity");
				int prodIdx = rs.getInt("prodIdx");
				String prodShopName = rs.getString("prodShopName");
				String prodName = rs.getString("prodName");
				int prodPrice = rs.getInt("prodPrice");
				int prodStock = rs.getInt("prodStock");
				String prodSize = rs.getString("prodSize");
				String prodColor = rs.getString("prodColor");
				String prodCategory = rs.getString("prodCategory");
				String prodType = rs.getString("prodType");
				String prodImg = rs.getString("prodImg");
				String date = rs.getString("regDate");
				date = date.substring(0, date.indexOf('.'));
				date = date.replace(' ', 'T');
				LocalDateTime regDate = LocalDateTime.parse(date);

				CartJoinProduct cartInfo = new CartJoinProduct(cartIdx, member_userIdx, product_prodIdx, quantity, prodIdx, prodShopName, prodName, prodPrice,
						prodStock, prodSize, prodColor, prodCategory, prodType, prodImg, regDate);
				
				cartInfoList.add(cartInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}

		return cartInfoList;
	}
	
	public List<CartInfo> selectCartList(int member_userIdx) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<CartInfo> cartInfoList = new ArrayList<>();

		try {
			String sql = "SELECT * FROM cart_info WHERE member_userIdx = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, member_userIdx);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int cartIdx = rs.getInt("cartIdx");
				int product_prodIdx = rs.getInt("product_prodIdx");
				int quantity = rs.getInt("quantity");

				CartInfo cartInfo = new CartInfo(cartIdx, member_userIdx, product_prodIdx, quantity);
				
				cartInfoList.add(cartInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}

		return cartInfoList;
	}
}
