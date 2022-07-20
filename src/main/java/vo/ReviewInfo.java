package vo;

import java.time.LocalDateTime;

public class ReviewInfo {
	private int reviewIdx;
	private String member_id;
	private int purchase_idx;
	private String contents;
	private LocalDateTime insertDate;
	
	public ReviewInfo() {
		
 	}
	
	public ReviewInfo(int reviewIdx, String member_id, int purchase_idx, String contents, LocalDateTime insertDate) {
		this.reviewIdx = reviewIdx;
		this.member_id = member_id;
		this.purchase_idx = purchase_idx;
		this.contents = contents;
		this.insertDate = insertDate;
	}
	
	public ReviewInfo(String member_id, int purchase_idx, String contents, LocalDateTime insertDate) {
		this(0, member_id, purchase_idx, contents, insertDate);
	}
	

	public int getReviewIdx() {
		return reviewIdx;
	}
	public void setReviewIdx(int reviewIdx) {
		this.reviewIdx = reviewIdx;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getPurchase_idx() {
		return purchase_idx;
	}
	public void setPurchase_idx(int purchase_idx) {
		this.purchase_idx = purchase_idx;
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
