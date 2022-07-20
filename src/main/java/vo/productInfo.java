package vo;

import java.time.LocalDateTime;

public class ProductInfo {
	private int prodIdx;
	private String prodShopName;
	private String prodName;
	private int prodPrice;
	private int prodStock;
	private String prodSize;
	private String prodColor;
	private String prodCategory;
	private String prodType;
	private String prodImg;
	private LocalDateTime regDate;
	
	public ProductInfo() {
		
	}
	
	public ProductInfo(int prodIdx, String prodShopName, String prodName, int prodPrice, int prodStock, String prodSize, String prodColor, String prodCategory, String prodType, String prodImg, LocalDateTime regDate) {
		this.prodIdx = prodIdx;
		this.prodShopName = prodShopName;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodStock = prodStock;
		this.prodSize = prodSize;
		this.prodColor = prodColor;
		this.prodCategory = prodCategory;
		this.prodType = prodType;
		this.prodImg = prodImg;
		this.regDate = regDate;
	}
	
	public ProductInfo(String prodShopName, String prodName, int prodPrice, int prodStock, String prodSize, String prodColor, String prodCategory, String prodType, String prodImg, LocalDateTime regDate) {
		this(0, prodShopName, prodName, prodPrice, prodStock, prodSize, prodColor, prodCategory, prodType, prodImg, regDate);
	}
	
	public ProductInfo(int prodIdx, String prodName, int prodPrice, int prodStock, String prodSize, String prodColor, String prodCategory, String prodType) {
		this(prodIdx, null, prodName, prodPrice, prodStock, prodSize, prodColor, prodCategory, prodType, null, null);
	}

	public String getCategory() {
		return prodCategory;
	}

	public void setCategory(String category) {
		this.prodCategory = category;
	}
	
	public int getProdIdx() {
		return prodIdx;
	}

	public void setProdIdx(int prodIdx) {
		this.prodIdx = prodIdx;
	}
	
	public String getProdShopName() {
		return prodShopName;
	}

	public void setProdShopName(String prodShopName) {
		this.prodShopName = prodShopName;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdStock() {
		return prodStock;
	}

	public void setProdStock(int prodStock) {
		this.prodStock = prodStock;
	}

	public String getProdSize() {
		return prodSize;
	}

	public void setProdSize(String prodSize) {
		this.prodSize = prodSize;
	}

	public String getProdColor() {
		return prodColor;
	}

	public void setProdColor(String prodColor) {
		this.prodColor = prodColor;
	}

	public String getProdImg() {
		return prodImg;
	}

	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public String getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}
	
	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}
	
	
	
}
