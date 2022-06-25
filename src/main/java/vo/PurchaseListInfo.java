package vo;

import java.time.LocalDateTime;

public class PurchaseListInfo {
	private String purchaseId;
	private String purchaseName;
	private int purchasePrice;
	private int purchaseQuantity;
	private String purchaseSize;
	private String purchaseColor;
	private LocalDateTime purchaseDate;
	
	public PurchaseListInfo(String purchaseId, String purchaseName, int purchasePrice, int purchaseQuantity, String purchaseSize, String purchaseColor, LocalDateTime purchaseDate) {
		this.purchaseId = purchaseId;
		this.purchaseName = purchaseName;
		this.purchasePrice = purchasePrice;
		this.purchaseQuantity = purchaseQuantity;
		this.purchaseSize = purchaseSize;
		this.purchaseColor = purchaseColor;
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
	
	
}
