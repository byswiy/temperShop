package vo;

import java.time.LocalDateTime;

public class BuyInfo {
	private int buyIdx;
	private int userIdx;
	private int prodIdx;
	private int cost;
	private LocalDateTime buyDate;
	
	public BuyInfo(int buyIdx, int userIdx, int prodIdx, int cost, LocalDateTime buyDate) {
		this.buyIdx = buyIdx;
		this.userIdx = userIdx;
		this.prodIdx = prodIdx;
		this.cost = cost;
		this.buyDate = buyDate;
	}
	
	
	public BuyInfo(int userIdx, int prodIdx, int cost, LocalDateTime buyDate) {
		this(0, userIdx, prodIdx, cost, buyDate);
	}



	public int getBuyIdx() {
		return buyIdx;
	}
	public void setBuyIdx(int buyIdx) {
		this.buyIdx = buyIdx;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public int getProdIdx() {
		return prodIdx;
	}
	public void setProdIdx(int prodIdx) {
		this.prodIdx = prodIdx;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public LocalDateTime getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(LocalDateTime buyDate) {
		this.buyDate = buyDate;
	}
	
	
}
