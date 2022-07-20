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

public class FilterDao {
	// pageNumber를 포함한 상품 정보를 모두 가져오는 SELECT 쿼리
	public List<ProductInfo> selectAll(int pageNumber, String prodType, String prodCategory, String prodSize) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<ProductInfo> productInfoList = new ArrayList<>();

		try {
			String sql = "SELECT * FROM product_info";

			if (prodSize != null) {
				sql += " WHERE prodType = '" + prodType + "' AND prodCategory = '" + prodCategory + "' And prodSize = '"
						+ prodSize + "'";
			} else if (prodCategory != null) {
				sql += " WHERE prodType = '" + prodType + "' AND prodCategory = '" + prodCategory + "'";
			} else if (prodType != null) {
				sql += " WHERE prodType = '" + prodType + "'";
			}

			sql += " ORDER BY regDate DESC LIMIT ?, 12";

			// 9가 의미하는 것은 한 페이지에 보여줘야할 상품의 수 1번 페이지라면 1-1 = 0 0*9 => 0
			int startIndex = (pageNumber - 1) * 12;

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, startIndex);

			rs = pstmt.executeQuery();

			// 결과가 있을 수도 있고 없을 수도 있기 때문에
			// while을 사용해서 결과가 있을 때까지 동작하도록 한다
			while (rs.next()) {
				int prodIdx = rs.getInt("prodIdx");
				String prodShopName = rs.getString("prodShopName");
				String prodName = rs.getString("prodName");
				int prodPrice = rs.getInt("prodPrice");
				int prodStock = rs.getInt("prodStock");
				String prodColor = rs.getString("prodColor");
				String prodImg = rs.getString("prodImg");
				String date = rs.getString("regDate");
				date = date.substring(0, date.indexOf('.'));
				date = date.replace(' ', 'T');
				LocalDateTime regDate = LocalDateTime.parse(date);

				ProductInfo nthProductInfo = new ProductInfo(prodIdx, prodShopName, prodName, prodPrice, prodStock,
						prodSize, prodColor, prodCategory, prodType, prodImg, regDate);

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
	
	public List<ProductInfo> selectColor(int pageNumber, String prodColor) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<ProductInfo> productInfoList = new ArrayList<>();

		try {
			String sql = "SELECT * FROM product_info";

			if (prodColor != null) {
				sql += " WHERE prodColor = '" + prodColor + "'";
			}

			sql += " ORDER BY regDate DESC LIMIT ?, 12";

			// 9가 의미하는 것은 한 페이지에 보여줘야할 상품의 수 1번 페이지라면 1-1 = 0 0*9 => 0
			int startIndex = (pageNumber - 1) * 12;

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, startIndex);

			rs = pstmt.executeQuery();

			// 결과가 있을 수도 있고 없을 수도 있기 때문에
			// while을 사용해서 결과가 있을 때까지 동작하도록 한다
			while (rs.next()) {
				int prodIdx = rs.getInt("prodIdx");
				String prodShopName = rs.getString("prodShopName");
				String prodName = rs.getString("prodName");
				int prodPrice = rs.getInt("prodPrice");
				int prodStock = rs.getInt("prodStock");
				String prodSize = rs.getString("prodSize");
				String prodCategory = rs.getString("prodCategory");
				String prodType = rs.getString("prodType");
				String prodImg = rs.getString("prodImg");
				String date = rs.getString("regDate");
				date = date.substring(0, date.indexOf('.'));
				date = date.replace(' ', 'T');
				LocalDateTime regDate = LocalDateTime.parse(date);

				ProductInfo nthProductInfo = new ProductInfo(prodIdx, prodShopName, prodName, prodPrice, prodStock,
						prodSize, prodColor, prodCategory, prodType, prodImg, regDate);

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
	
	public List<ProductInfo> selectPrice(int pageNumber, int price) {
		Database db = new Database();

		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<ProductInfo> productInfoList = new ArrayList<>();

		try {
			String sql = "SELECT * FROM product_info";

			if (price == 1) {
				sql += " ORDER BY prodPrice ASC LIMIT ?, 12";
			} else if(price == 2) {
				sql += " ORDER BY prodPrice DESC LIMIT ?, 12";
			}
			// 9가 의미하는 것은 한 페이지에 보여줘야할 상품의 수 1번 페이지라면 1-1 = 0 0*9 => 0
			int startIndex = (pageNumber - 1) * 12;

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, startIndex);

			rs = pstmt.executeQuery();

			// 결과가 있을 수도 있고 없을 수도 있기 때문에
			// while을 사용해서 결과가 있을 때까지 동작하도록 한다
			while (rs.next()) {
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

				ProductInfo nthProductInfo = new ProductInfo(prodIdx, prodShopName, prodName, prodPrice, prodStock,
						prodSize, prodColor, prodCategory, prodType, prodImg, regDate);

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
	
	public int getProdTypeAmount(String prodType) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS amount FROM product_info WHERE prodType = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prodType);
			
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
	
	public int getProdCategoryAmount(String prodType,  String prodCategory) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS amount FROM product_info WHERE prodType = ? AND prodCategory = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prodType);
			pstmt.setString(2, prodCategory);
			
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
	
	public int getProdSizeyAmount(String prodType,  String prodCategory, String prodSize) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS amount FROM product_info WHERE prodType = ? AND prodCategory = ? AND prodSize = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prodType);
			pstmt.setString(2, prodCategory);
			pstmt.setString(3, prodSize);
			
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
	
	public int getProdColor(String prodColor) {
		Database db = new Database();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int count = 0;
		
		try {
			String sql = "SELECT COUNT(*) AS amount FROM product_info WHERE prodColor = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, prodColor);
			
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
}
