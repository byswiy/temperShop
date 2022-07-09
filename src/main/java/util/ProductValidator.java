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

	public boolean prodShopNameValidator(String prodShopName) {
		boolean correctProdShopName = false;

		// 상품 명 정규표현식
		correctProdShopName = prodShopName.matches(Validator.VALIDATOR);
		if (!correctProdShopName) {
			return false;
		}

		return correctProdShopName;
	}

	public boolean prodNameValidator(String prodName) {
		boolean correctProdName = false;

		// 상품 명 정규표현식
		correctProdName = prodName.matches(Validator.VALIDATOR);
		if (!correctProdName) {
			return false;
		}

		return correctProdName;
	}

	public boolean prodStockOrProdPriceValidator(int prodStock, int prodPrice) {
		boolean correctPriceOrStock = false;
		// 상품 가격, 재고 파라미터
		correctPriceOrStock = prodStock >= 0 || prodPrice >= 0;
		if (!correctPriceOrStock) {
			return false;
		}
		return correctPriceOrStock;
	}

	public boolean prodSizeValidator(String prodSize) {
		boolean correctProdSize = false;

		// 상품 사이즈 파라미터
		correctProdSize = prodSize.matches("^[A-Z]+${1}");
		if (!correctProdSize) {
			return false;
		}

		return correctProdSize;
	}

	public boolean prodColorValidator(String prodColor) {
		boolean correctProdColor = false;

		// 상품 색상 파라미터
		correctProdColor = prodColor.matches("^[a-zA-Z]+$");
		if (!correctProdColor) {
			return false;
		}
		
		return correctProdColor;
	}
	
	public boolean prodCategoryValidator(String prodCategory) {
		boolean correctProdCategory = false;

		// 상품 카테고리 파라미터
		correctProdCategory = prodCategory.matches(Validator.VALIDATOR);
		if (!correctProdCategory) {
			return false;
		}

		return correctProdCategory;
	}
	
	public boolean prodTypeValidator(String prodType) {
		boolean correctProdType = false;

		// 상품 카테고리 파라미터
		correctProdType = prodType.matches("^[a-zA-Z]+$");
		if (!correctProdType) {
			return false;
		}

		return correctProdType;
	}

}
