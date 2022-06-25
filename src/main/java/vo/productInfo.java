package vo;

import java.time.LocalDateTime;

public class ProductInfo {
	private int prodIdx;
	private String prodName;
	private int prodPrice;
	private int prodStock;
	private int prodQuantity;
	private String prodSize;
	private String prodColor;
	private String prodCategory;
	private String prodImg;
	private LocalDateTime regDate;
	
	public ProductInfo() {
		
	}

	public ProductInfo(int prodIdx, String prodName, int prodPrice, int prodStock, int prodQuantity, String prodSize, String prodColor, String prodCategory, String prodImg, LocalDateTime regDate) {
		this.prodIdx = prodIdx;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodStock = prodStock;
		this.prodQuantity = prodQuantity;
		this.prodSize = prodSize;
		this.prodColor = prodColor;
		this.prodCategory = prodCategory;
		this.prodImg = prodImg;
		this.regDate = regDate;
	}
	
	public ProductInfo(int prodIdx, String prodName, int prodPrice, int prodStock, String prodSize, String prodColor, String prodCategory, String prodImg, LocalDateTime regDate) {
		this(prodIdx, prodName, prodPrice, prodStock, 0, prodSize, prodColor, prodCategory, prodImg, regDate);
	}

	// productAddController
	public ProductInfo(String prodName, int prodPrice, int prodStock,  String prodSize, String prodColor, String prodCategory, String prodImg, LocalDateTime regDate) {
		this(0, prodName, prodPrice, prodStock, 0, prodSize, prodColor, prodCategory, prodImg, regDate);
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

	public int getProdQuantity() {
		return prodQuantity;
	}

	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}
	
	
	
}
