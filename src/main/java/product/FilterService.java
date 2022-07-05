package product;

import dao.FilterDao;
import vo.ProductInfo;

public class FilterService {
	// 옷을 구분하는 필터 : Top, Bottom, Dress
	public ProductInfo typeFilter(String prodType) {
		ProductInfo productInfo = new ProductInfo();
		
		FilterDao dao = new FilterDao();
		productInfo = dao.selectProdType(prodType);
		
		return productInfo;
	}
	
	// 옷을 종류별로 구분하는 필터
	// Top : 민소매, 반팔, 얇은 셔츠, 얇은 가디건, 간팔, 얇은 니트
	// Bottom : 반바지, 면바지, 청바지
	// Dress : 원피스, 스커트
	public ProductInfo categoryFilter(String prodType, String prodCategory) {
		ProductInfo productInfo = new ProductInfo();
		productInfo = typeFilter(prodType);

		String selectProdType = productInfo.getProdType();
		
		FilterDao dao = new FilterDao();
		productInfo = dao.selectProdCategory(selectProdType, prodCategory);
		
		return productInfo;
		
	}
	
	// prodSize에 따라 상품을 나누는 필터
	public ProductInfo sizeFilter(String prodType, String prodCategoey, String prodSize) {
		ProductInfo productInfo = new ProductInfo();
		productInfo = typeFilter(prodType);
		
		String selectProdType = productInfo.getProdType();
		
		FilterDao dao = new FilterDao();
		productInfo = dao.selectProdCategory(selectProdType, prodCategoey);
		
		String selectProdCategory = productInfo.getCategory();
		
		productInfo = dao.selectProdSize(selectProdType, selectProdCategory, prodSize);
		
		return productInfo;
	}
	
	// prodColor에 따라 상품을 나누는 필터
	public ProductInfo colorFilter(String prodColor) {
		ProductInfo productInfo = new ProductInfo();
		FilterDao dao = new FilterDao();
		
		// productListController로 값을 전달한다
		productInfo = dao.selectProdColor(prodColor);
		
		return productInfo;
	}
	
	
	// 기본 상품 순 필터
	public ProductInfo filter(int prodIdx) {
		ProductInfo productInfo = new ProductInfo();
		FilterDao dao = new FilterDao();
		
		productInfo = dao.selectProdIdx(prodIdx);
		
		return productInfo;
		
	}
	
	// 가격 낮은 순 필터
	public ProductInfo cheapPriceFilter(int prodPrice) {
		ProductInfo productInfo = new ProductInfo();
		FilterDao dao = new FilterDao();
		
		productInfo = dao.selectProdIdx(prodPrice);
		
		return productInfo;
	}
	
	// 가격 높은 순 필터
	public ProductInfo expensivePriceFileter(int prodPrice) {
		ProductInfo productInfo = new ProductInfo();
		FilterDao dao = new FilterDao();
		
		productInfo = dao.selectProdIdx(prodPrice);
		
		return productInfo;
	}
	
}
