package util;

public class Validator {
	// 회원 정보 관련 validator
	public static final String ID_VALIDATOR = "^(?=.*[a-z])(?=.*\\d)+[a-zA-Z0-9]{5,15}$";
	
	public static final String PW_VALIDATOR = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)+[a-zA-Z0-9]{7,17}$";
	
	public static final String NAME_VALIDATOR = "^[가-힣]{1,3}$";
	
	public static final String EMAIL_VALIDATOR = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
	
	
	// 상품 정보 관련 validator
}
