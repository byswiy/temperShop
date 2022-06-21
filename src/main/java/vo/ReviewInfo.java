package vo;

import java.time.LocalDateTime;

public class ReviewInfo {
	private int reviewIdx;
	private int member_userIdx;
	private int product_prodIdx;
	private String contents;
	private LocalDateTime insertDate;
	
	public ReviewInfo() {
		
 	}
	
	public int getReviewIdx() {
		return reviewIdx;
	}
	public void setReviewIdx(int reviewIdx) {
		this.reviewIdx = reviewIdx;
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
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public LocalDateTime getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(LocalDateTime insertDate) {
		this.insertDate = insertDate;
	}
	
	
}
