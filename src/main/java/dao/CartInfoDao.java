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
import vo.ProductInfo;

public class CartInfoDao {
	// 장바구니 정보를 삽압하는 insert 쿼리
	public boolean insertCartInfo(CartInfo cartInfo) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		try {
			String sql = "INSERT INTO cart_info(cartIdx, member_userIdx, product_prodIdx, quantity) VALUES(?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, cartInfo.getCartIdx());
			pstmt.setInt(2, cartInfo.getMember_userIdx());
			pstmt.setInt(3, cartInfo.getProduct_prodIdx());
			pstmt.setInt(4, cartInfo.getQuantity());

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

	public List<CartInfo> selectAll(int pageNumber) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<CartInfo> cartInfoList = new ArrayList<>();

		try {
			String sql = "SELECT * FROM cart_info ORDER BY cartIdx DESC LIMIT ?, 5";

			int startIndex = (pageNumber - 1) * 5;

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, startIndex);

			rs = pstmt.executeQuery();

			// 결과가 있을 수도 있고 없을 수도 있기 때문에
			// while을 사용해서 결과가 있을 때까지 동작하도록 한다
			while (rs.next()) {
				int member_userIdx = rs.getInt("member_userIdx");
				int product_prodIdx = rs.getInt("product_prodIdx");
				int prodQuantity = rs.getInt("quantity");

				CartInfo nthCartInfo = new CartInfo(member_userIdx, product_prodIdx, prodQuantity);

				cartInfoList.add(nthCartInfo);
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
}
