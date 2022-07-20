package vo;

import java.time.LocalDateTime;

public class CartJoinProduct {
	private int cartIdx;
	private int member_userIdx;;
	private int product_prodIdx;
	private int quantity;
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
	
	public CartJoinProduct(int cartIdx, int member_userIdx, int product_prodIdx, int quantity, int prodIdx,
			String prodShopName, String prodName, int prodPrice, int prodStock, String prodSize, String prodColor,
			String prodCategory, String prodType, String prodImg, LocalDateTime regDate) {
		super();
		this.cartIdx = cartIdx;
		this.member_userIdx = member_userIdx;
		this.product_prodIdx = product_prodIdx;
		this.quantity = quantity;
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
	
	public int getCartIdx() {
		return cartIdx;
	}
	public void setCartIdx(int cartIdx) {
		this.cartIdx = cartIdx;
	}
	public int getMember_userIdx() {
		return member_userIdx;
	}
	public void setMember_userIdx(int member_userIdx) {
		this.member_userIdx = member_userIdx;
	}
	public int getProduct_prodIdx() {
		return product_prodIdx;
	}
	public void setProduct_prodIdx(int product_prodIdx) {
		this.product_prodIdx = product_prodIdx;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
