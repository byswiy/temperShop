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

public class ProductInfoDao {
	public boolean insertProduct(ProductInfo productInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO product_info(prodName, prodPrice, prodStock, prodSize, prodColor, prodImg, regDate, prodCategory) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, productInfo.getProdName());
			pstmt.setInt(2, productInfo.getProdPrice());
			pstmt.setInt(3, productInfo.getProdStock());
			pstmt.setString(4, productInfo.getProdSize());
			pstmt.setString(5, productInfo.getProdColor());
			pstmt.setString(6, productInfo.getProdImg());
			pstmt.setString(7, productInfo.getRegDate().toString());
			pstmt.setString(8, productInfo.getCategory());
			
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
	
	public int getCount() {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS amount FROM product_info";
			
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
	 
	public List<ProductInfo> selectAll(int pageNumber) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProductInfo> productInfoList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM product_info ORDER BY regDate DESC LIMIT ?, 9";
			
			// 9가 의미하는 것은 한 페이지에 보여줘야할 상품의 수 1번 페이지라면 1-1 = 0 0*9 => 0
			int startIndex = (pageNumber - 1) * 9;

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startIndex);
			
			rs = pstmt.executeQuery();
			
			// 결과가 있을 수도 있고 없을 수도 있기 때문에
			// while을 사용해서 결과가 있을 때까지 동작하도록 한다
			while(rs.next()) {
				int prodIdx = rs.getInt("prodIdx");
				String prodName = rs.getString("prodName");
				int prodPrice = rs.getInt("prodPrice");
				int prodStock = rs.getInt("prodStock");
				String prodSize = rs.getString("prodSize");
				String prodColor = rs.getString("prodColor");
				String prodImg = rs.getString("prodImg");
				String date = rs.getString("insertDate");
				date = date.substring(0, date.indexOf('.'));
				date = date.replace(' ', 'T');
				LocalDateTime regDate = LocalDateTime.parse(date);
				String prodCategory = rs.getString("prodCategory");
				
				ProductInfo nthProductInfo = new ProductInfo(prodIdx, prodName, prodPrice, prodStock, prodSize, prodColor, prodImg, regDate, prodCategory);
				
				productInfoList.add(nthProductInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		
		return productInfoList;
	}
}
