package vo;

import java.time.LocalDateTime;

public class PurchaseInfo {
	private int purchaseIdx;
	private int userIdx;
	private String purchaseShopName;
	private String purchaseName;
	private int purchasePrice;
	private int purchaseQuantity;
	private int purchaseCost;
	private String purchaseSize;
	private String purchaseColor;
	private String message;
	private String purchaseImg;
	private LocalDateTime purchaseDate;

	public PurchaseInfo() {

	}

	public PurchaseInfo(int purchaseIdx, int useridx, String purchaseShopName, String purchaseName, int purchasePrice,
						int purchaseQuantity, int purchaseCost, String purchaseSize, String purchaseColor, String message,
						String purchaseImg, LocalDateTime purchaseDate) {
		this.purchaseIdx = purchaseIdx;
		this.userIdx = useridx;
		this.purchaseShopName = purchaseShopName;
		this.purchaseName = purchaseName;
		this.purchasePrice = purchasePrice;
		this.purchaseQuantity = purchaseQuantity;
		this.purchaseCost = purchaseCost;
		this.purchaseSize = purchaseSize;
		this.purchaseColor = purchaseColor;
		this.message = message;
		this.purchaseImg = purchaseImg;
		this.purchaseDate = purchaseDate;
	}

	
	public PurchaseInfo(int userIdx, String purchaseShopName, String purchaseName, int purchasePrice, int purchaseQuantity,
						int purchaseCost, String purchaseSize, String purchaseColor, String message,
						String purchaseImg, LocalDateTime purchaseDate) {
		this(0, userIdx, purchaseShopName, purchaseName, purchasePrice, purchaseQuantity, purchaseCost, purchaseSize, purchaseColor, message, purchaseImg, purchaseDate);

	}
		
	
	public int getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}

	public int getPurchaseIdx() {
		return purchaseIdx;
	}

	public void setPurchaseIdx(int purchaseIdx) {
		this.purchaseIdx = purchaseIdx;
	}

	public String getPurchaseShopName() {
		return purchaseShopName;
	}

	public void setPurchaseShopName(String purchaseShopName) {
		this.purchaseShopName = purchaseShopName;
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

	public int getPurchaseCost() {
		return purchaseCost;
	}

	public void setPurchaseCost(int purchaseCost) {
		this.purchaseCost = purchaseCost;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPurchaseImg() {
		return purchaseImg;
	}

	public void setPurchaseImg(String purchaseImg) {
		this.purchaseImg = purchaseImg;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}
