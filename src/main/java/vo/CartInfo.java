package vo;

public class CartInfo {
	private int cartIdx;
	private int member_userIdx;
	private int product_prodIdx;
	
	public CartInfo(int cartIdx, int member_userIdx, int product_prodIdx) {
		this.cartIdx = cartIdx;
		this.member_userIdx = member_userIdx;
		this.product_prodIdx = product_prodIdx;
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
	
	
}
