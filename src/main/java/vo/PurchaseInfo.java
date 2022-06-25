package vo;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletResponse;

import dao.ProductInfoDao;

public class PurchaseInfo {
	private int purchaseIdx;
	private int member_userIdx;
	private int product_prodIdx;
	private int cart_cartIdx;
	private int cost;
	private String message;
	private LocalDateTime purchaseDate;
	
	public PurchaseInfo() {
		
	}
	
	public PurchaseInfo(int member_userIdx, int product_prodIdx, int cart_cartIdx, int cost, String message, LocalDateTime purchaseDate) {
		this.member_userIdx = member_userIdx;
		this.product_prodIdx = product_prodIdx;
		this.cart_cartIdx = cart_cartIdx;
		this.cost = cost;
		this.message = message;
		this.purchaseDate = purchaseDate;
	}
	
	public PurchaseInfo(int member_userIdx, int product_prodIdx,  int cost, String message, LocalDateTime purchaseDate) {
		this(member_userIdx, product_prodIdx, 0, cost, message, purchaseDate);
	}
	
	public int getPurchaseIdx() {
		return purchaseIdx;
	}
	public void setPurchaseIdx(int purchaseIdx) {
		this.purchaseIdx = purchaseIdx;
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
	public int getCart_cartIdx() {
		return cart_cartIdx;
	}
	public void setCart_cartIdx(int cart_cartIdx) {
		this.cart_cartIdx = cart_cartIdx;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	
	
}
