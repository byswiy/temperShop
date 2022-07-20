package vo;

public class PaymentInfo {
	private int user_idx;
	private String imp_uid;
	private String merchant_uid;
	private int paid_amount;
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getImp_uid() {
		return imp_uid;
	}
	public void setImp_uid(String imp_uid) {
		this.imp_uid = imp_uid;
	}
	public String getMerchant_uid() {
		return merchant_uid;
	}
	public void setMerchant_uid(String merchant_uid) {
		this.merchant_uid = merchant_uid;
	}
	public int getPaid_amount() {
		return paid_amount;
	}
	public void setPaid_amount(int paid_amount) {
		this.paid_amount = paid_amount;
	}
	
	public PaymentInfo(int user_idx, String imp_uid, String merchant_uid, int paid_amount) {
		this.user_idx = user_idx;
		this.imp_uid = imp_uid;
		this.merchant_uid = merchant_uid;
		this.paid_amount = paid_amount;
	}
	
	
}
