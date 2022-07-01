package util;

// 상품 정보 파라미터
// 상품 명 파라미터 - 한글, 영소문자만 가능
//                   길이는 30자까지 가능

// 상품 가격 파마리터 - 양의 정수만 가능

// 상품 재고 파라미터 - 양의 정수만 가능

// 상품 구매 수량 파라미터 - 양의 정수만 가능

// 상품 사이즈 파라미터 - 영대문자 한 자만 가능

// 상품 색상 파라미터 - 영대소문자만 가능하고 10자까지 가능

// 상품 카테고리 파라미터 - 한글만 가능
public class ProductValidator {
	public boolean allValidator(String prodName, int prodPrice, int prodStock, String prodSize, String prodColor, String prodCategory) {
		boolean correctProduct = false;

		// 상품 명 정규표현식
		correctProduct = prodName.matches("^[가-힣a-zA-Z]+$");
		if (!correctProduct) {
			return false;
		}
		
		// 상품 가격, 재고 파라미터
		correctProduct = prodPrice >= 0 || prodStock >= 0;
		if(!correctProduct) {
			return false;
		}
		
		// 상품 사이즈 파라미터
		correctProduct = prodSize.matches("^[A-Z]+${1}");
		if(!correctProduct) {
			return false;
		}
		
		// 상품 색상 파라미터
		correctProduct = prodColor.matches("^[a-zA-Z]+$");
		if(!correctProduct) {
			return false;
		}
		
		// 상품 카테고리 파라미터
		correctProduct = prodCategory.matches("^[가-힣]+$");
		if(!correctProduct) {
			return false;
		}
		
		return correctProduct;
	}
	
	public boolean updateValidator(int prodPrice, int prodStock, String prodSize, String prodColor) {
		boolean correctProduct = false;
		
		correctProduct = prodPrice >= 0 || prodStock >= 0;
		if(!correctProduct) {
			return false;
		}
		
		// 상품 사이즈 파라미터
		correctProduct = prodSize.matches("^[A-Z]+${1}");
		if(!correctProduct) {
			return false;
		}
		
		// 상품 색상 파라미터
		correctProduct = prodColor.matches("^[a-zA-Z]+$");
		if(!correctProduct) {
			return false;
		}
		
		return correctProduct;
	}
	
}
