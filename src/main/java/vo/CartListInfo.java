package vo;

public class CartListInfo extends ProductInfo{
	private int cartIdx;
	private int member_userIdx;
	private int product_prodIdx;
	private String prodShopName;
	private String prodName;
	private int prodPrice;
	private int prodQuantity;
	private String prodSize;
	private String prodColor;
	private String prodType;
	private String prodImg;
	
	public CartListInfo(int member_userIdx, int product_prodIdx, String prodShopName, String prodName, int prodPrice,
			            int prodQuantity, String prodSize, String prodColor, String prodType, String prodImg
	) {
		this.member_userIdx = member_userIdx;
		this.product_prodIdx = product_prodIdx;
		this.prodShopName = prodShopName;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodQuantity = prodQuantity;
		this.prodSize = prodSize;
		this.prodColor = prodColor;
		this.prodType = prodType;
		this.prodImg = prodImg;
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
	public int getProdQuantity() {
		return prodQuantity;
	}
	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
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
	
	
}
