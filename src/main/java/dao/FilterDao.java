package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import util.Database;
import vo.ProductInfo;

public class FilterDao {
	// prodType 칼럼을 사용한 필터
	public ProductInfo selectProdType(String prodType) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ProductInfo productInfo = null;
		
		try {
			String sql = "SELECT * FROM product_info WHERE prodType = ?";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, prodType);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				int prodIdx = rs.getInt("prodIdx");
				String prodShopName = rs.getString("prodShopName");
				String prodName = rs.getString("prodName");
				int prodPrice = rs.getInt("prodPrice");
				int prodStock = rs.getInt("prodStock");
				String prodSize = rs.getString("prodSize");
				String prodColor = rs.getString("prodColor");
				String prodCategory = rs.getString("prodCategory");
				String prodImg = rs.getString("prodImg");
				String date = rs.getString("regDate");
				date = date.substring(0, date.indexOf('.'));
				date = date.replace(' ', 'T');
				LocalDateTime regDate = LocalDateTime.parse(date);

				productInfo = new ProductInfo(prodIdx, prodShopName, prodName, prodPrice, prodStock, prodSize, prodColor, prodCategory, prodType, prodImg, regDate);
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
	
	// prodType 칼럼을 사용한 필터
		public ProductInfo selectProdCategory(String prodType, String prodCategory) {
			Database db = new Database();

			Connection conn = db.getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			ProductInfo productInfo = null;
			
			try {
				String sql = "SELECT * FROM product_info WHERE prodType = ? AND category = ?";
				
				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, prodType);
				pstmt.setString(2, prodCategory);

				rs = pstmt.executeQuery();

				if (rs.next()) {
					int prodIdx = rs.getInt("prodIdx");
					String prodShopName = rs.getString("prodShopName");
					String prodName = rs.getString("prodName");
					int prodPrice = rs.getInt("prodPrice");
					int prodStock = rs.getInt("prodStock");
					String prodSize = rs.getString("prodSize");
					String prodColor = rs.getString("prodColor");
					String prodImg = rs.getString("prodImg");
					String date = rs.getString("regDate");
					date = date.substring(0, date.indexOf('.'));
					date = date.replace(' ', 'T');
					LocalDateTime regDate = LocalDateTime.parse(date);

					productInfo = new ProductInfo(prodIdx, prodShopName, prodName, prodPrice, prodStock, prodSize, prodColor, prodCategory, prodType, prodImg, regDate);
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
}
