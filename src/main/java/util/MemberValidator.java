package util;

// 회원 정보 파라미터 
// 아이디 파라미터 - 길이: 6 ~ 16자로 제한
//					형태: 영어 대문자, 소문자, 숫자로 이루어질 수 있고 대문자는 필수가 아니다

// 비밀번호 파라미터 - 길이: 8 ~ 18자로 제한
//					  형태: 영어 대문자, 소문자, 숫자로 이루어지고 전부 필수로 하나씩 있어야한다

// 이름 파라미터 - 4자까지 가능하며 한글만 허용한다

// 연락처 파라미터 - 0000-0000 만 입력하도록 한다

// 주소 규칙 - 

// 이메일 규칙 - 반드시 @와 .을 포함하도록 한다
public class MemberValidator {
	public boolean idValidator(String id) {
		boolean correctId = false;

		// 아이디 정규표현식 : 하나 이상의 영소문자와 숫자 / 아이디는 영대소문자와 숫자를 사용 / 길이는 6~16자
		correctId = id.matches("^(?=.*[a-z])(?=.*\\d)+[a-zA-Z0-9]{5,15}$");
		if (!correctId) {
			return false;
		}
		
		return correctId;
	}
	
	public boolean pwValidator(String pw) {
		boolean correctPw = false;

		// 비밀번호 정규표현식 : 하나 이상의 영대소문자와 숫자 / 비밀번호는 영대소문자와 숫자를 사용 / 길이는 8~18자
		correctPw = pw.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)+[a-zA-Z0-9]{7,17}$");
		if (!correctPw) {
			return false;
		}
		
		return correctPw;
	}
	
	// 이름 정규표현식 : 한글만 사용 / 길이는 2~4자
	public boolean nameValidator(String name) {
		boolean correctName = false;

		correctName = name.matches("^[가-힣]{1,3}$");
		if (!correctName) {
			return false;
		}
		
		return correctName;
	}
	
	// 연락처 : 형식은 010-0000-0000과 같은 형식을 맞추도록한다
	public boolean telValidator(String tel) {
		boolean correctTel = false;

		correctTel = tel.matches("^\\d{3}-\\d{3,4}-\\d{4}$");
		if (!correctTel) {
			return false;
		}
		
		return correctTel;
	}
	
	// 우편번호 : 5자 숫자만 가능
	public boolean postalCodeValidator(String postalCode) {
		boolean correctPostalCode = false;

		correctPostalCode = postalCode.length() == 5;
		if (!correctPostalCode) {
			return false;
		}
		
		return correctPostalCode;
	}
	
	// 주소 : 한글과 숫자만 가능
	public boolean addrValidator(String addr) {
		boolean correctAddre = false;

		correctAddre = addr.matches("^[0-9가-힣\\s]+$");
		if (!correctAddre) {
			return false;
		}
		
		return correctAddre;
	}
	
	// 이메일 정규 표현식 : 영대소문자와 숫자로 시작한다 / @가 반드시 붙고 뒤에 영대소문자와 숫자가 들어갈 수 있다 /
	// . 이 반드시 붙고 뒤에 영소문자가 2~3개 들어갈 수 있다
	public boolean emailValidator(String email) {
		boolean correctEmail = false;

		correctEmail = email.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$");
		if (!correctEmail) {
			return false;
		}
		
		return correctEmail;
	}

}
