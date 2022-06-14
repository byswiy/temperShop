package vo;

import java.time.LocalDateTime;

public class productInfo {
	private int prodIdx;
	private String prodName;
	private int prodPrice;
	private int prodStock;
	private char prodSize;
	private String prodColor;
	private String prodImg;
	private LocalDateTime regDate;
	
	public productInfo() {
		
	}
	
	public productInfo(int prodIdx, String prodName, int prodPrice, int prodStock, char prodSize, String prodColor, String prodImg, LocalDateTime regDate) {
		this.prodIdx = prodIdx;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodStock = prodStock;
		this.prodSize = prodSize;
		this.prodColor = prodColor;
		this.prodImg = prodImg;
		this.regDate = regDate;
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

	public char getProdSize() {
		return prodSize;
	}

	public void setProdSize(char prodSize) {
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
	
	
}
