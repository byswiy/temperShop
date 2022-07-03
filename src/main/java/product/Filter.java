package product;

import dao.FilterDao;
import vo.ProductInfo;

public class Filter {
	// 옷과 악세사리를 나누는 type 필터
	public ProductInfo typeFilter(String prodType) {
		ProductInfo productInfo = new ProductInfo();
		FilterDao dao = new FilterDao();
		
		// productListController로 값을 전달한다
		productInfo = dao.selectProdType(prodType);
		
		return productInfo;
		
	}
	
	// prodCategoey에 따라 상품을 나누는 필터
	public ProductInfo categoryFilter(String prodType, String prodCategory) {
		ProductInfo productInfo = new ProductInfo();
		FilterDao dao = new FilterDao();
		
		// productListController로 값을 전달한다
		productInfo = dao.selectProdCategory(prodType, prodCategory);
		
		return productInfo;
		
	}
	
	// prodSize에 따라 상품을 나누는 필터
	public void sizeyFilter() {
		
	}
	
	// prodColor에 따라 상품을 나누는 필터
	public void colorFilter() {
		
	}
	
	
	// 기본 상품 순 필터
	public void filter() {
		
	}
	
	// 가격 낮은 순 필터
	public void cheapPriceFilter() {
		
	}
	
	// 가격 높은 순 필터
	public void expensivePriceFileter() {
		
	}
	
	public void dfd(String prodType) {
		
	}
}
