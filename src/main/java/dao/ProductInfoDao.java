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
	
	// 상품 정보를 삽입하는 INSERT 쿼리
	public boolean insertProduct(ProductInfo productInfo) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "INSERT INTO product_info(prodShopName, prodName, prodPrice, prodStock, prodSize, prodColor, prodCategory, prodType, prodImg, regDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, productInfo.getProdShopName());
			pstmt.setString(2, productInfo.getProdName());
			pstmt.setInt(3, productInfo.getProdPrice());
			pstmt.setInt(4, productInfo.getProdStock());
			pstmt.setString(5, productInfo.getProdSize());
			pstmt.setString(6, productInfo.getProdColor());
			pstmt.setString(7, productInfo.getCategory());
			pstmt.setString(8, productInfo.getProdType());
			pstmt.setString(9, productInfo.getProdImg());
			pstmt.setString(10, productInfo.getRegDate().toString());
			
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
	
	// 상품의 수를 가져오기 위한 SELECT 쿼리
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
	 
	// pageNumber를 포함한 상품 정보를 모두 가져오는 SELECT 쿼리
	public List<ProductInfo> selectAll(int pageNumber) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<ProductInfo> productInfoList = new ArrayList<>();
		
		try {
			String sql = "SELECT * FROM product_info ORDER BY regDate DESC LIMIT ?, 12";
			
			// 9가 의미하는 것은 한 페이지에 보여줘야할 상품의 수 1번 페이지라면 1-1 = 0 0*9 => 0
			int startIndex = (pageNumber - 1) * 12;

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startIndex);
			
			rs = pstmt.executeQuery();
			
			// 결과가 있을 수도 있고 없을 수도 있기 때문에
			// while을 사용해서 결과가 있을 때까지 동작하도록 한다
			while(rs.next()) {
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
				
				ProductInfo nthProductInfo = new ProductInfo(prodIdx, prodShopName, prodName, prodPrice, prodStock, prodSize, prodColor, prodCategory, prodType, prodImg, regDate);
				
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
	
	// 상품 번호를 select해서 상품 정보를 저장하는 쿼리
	public ProductInfo selectProductIdx(int prodIdx) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ProductInfo productInfo = null;
		
		try {
			String sql = "SELECT * FROM product_info WHERE prodIdx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prodIdx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
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
				date = date.substring(0, 19);
				date = date.replace(' ', 'T');
				LocalDateTime regDate = LocalDateTime.parse(date);
				
				productInfo = new ProductInfo(prodIdx, prodShopName, prodName, prodPrice, prodStock, prodSize, prodColor, prodCategory, prodType, prodImg, regDate);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			db.closeResultSet(rs);
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
		
		return productInfo;
	}
	
	// 상품 삭제를 위한 DELETE 쿼리
	public void deleteProductInfo(int prodIdx) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM product_info WHERE prodIdx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prodIdx);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
	}
	
	// 상품 정보를 수정하는 UPDATE 쿼리
	public void updateProductInfo(ProductInfo productInfo) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			String sql = "UPDATE product_info SET prodName = ?, prodPrice = ?, prodStock = ?,"
					                           + "prodSize = ?, prodColor = ?, prodCategory = ?, prodType = ? WHERE prodIdx = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, productInfo.getProdName());
			pstmt.setInt(2, productInfo.getProdPrice());
			pstmt.setInt(3, productInfo.getProdStock());
			pstmt.setString(4, productInfo.getProdSize());
			pstmt.setString(5, productInfo.getProdColor());
			pstmt.setString(6, productInfo.getProdCategory());
			pstmt.setString(7, productInfo.getProdType());
			pstmt.setInt(8, productInfo.getProdIdx());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.closePstmt(pstmt);
			db.closeConn(conn);
		}
	}
	
	// 상품 재고를 감소 시키는 UPDATE 쿼리
		public void decreaseStock(int prodIdx, int quantity) {
			Database db = new Database();

			Connection conn = db.getConnection();
			PreparedStatement pstmt = null;
			
			try {
				String sql = "UPDATE product_info SET prodStock = prodStock - ? WHERE prodIdx = ?";
				
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, quantity);
				pstmt.setInt(2, prodIdx);
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.closePstmt(pstmt);
				db.closeConn(conn);
			}
		}
}
