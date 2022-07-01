package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import util.Database;
import vo.ProductInfo;

public class FilterDao {
	public void selectTypeFilter(ProductInfo productInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM product_info WHERE prodType = 옷";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, productInfo.getProdType());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
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
				
				productInfo = new ProductInfo(prodIdx, prodShopName,  prodName, prodPrice, prodStock,  prodSize, prodColor, prodCategory, prodImg, prodImg, regDate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		return false;
	}
}
