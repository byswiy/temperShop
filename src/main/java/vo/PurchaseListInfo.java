package vo;

import java.time.LocalDateTime;

public class PurchaseListInfo {
	private String purchaseId;
	private String purchaseShopName;
	private String purchaseName;
	private int purchasePrice;
	private int purchaseQuantity;
	private String purchaseSize;
	private String purchaseColor;
	private String purchaseType;
	private LocalDateTime purchaseDate;
	
	public PurchaseListInfo(String purchaseId, String purchaseShopName, String purchaseName, int purchasePrice,
							int purchaseQuantity, String purchaseSize, String purchaseColor, String purchaseType,
							LocalDateTime purchaseDate) {
		this.purchaseId = purchaseId;
		this.purchaseShopName = purchaseShopName;
		this.purchaseName = purchaseName;
		this.purchasePrice = purchasePrice;
		this.purchaseQuantity = purchaseQuantity;
		this.purchaseSize = purchaseSize;
		this.purchaseColor = purchaseColor;
		this.purchaseType = purchaseType;
		this.purchaseDate = purchaseDate;
	}
	
	
	
	public String getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getPurchaseName() {
		return purchaseName;
	}
	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}
	public int getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public String getPurchaseSize() {
		return purchaseSize;
	}
	public void setPurchaseSize(String purchaseSize) {
		this.purchaseSize = purchaseSize;
	}
	public String getPurchaseColor() {
		return purchaseColor;
	}
	public void setPurchaseColor(String purchaseColor) {
		this.purchaseColor = purchaseColor;
	}
	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}



	public String getPurchaseShopName() {
		return purchaseShopName;
	}



	public void setPurchaseShopName(String purchaseShopName) {
		this.purchaseShopName = purchaseShopName;
	}



	public String getPurchaseType() {
		return purchaseType;
	}



	public void setPurchaseType(String purchaseType) {
		this.purchaseType = purchaseType;
	}
	
	
}
