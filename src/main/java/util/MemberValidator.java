package util;

import vo.MemberInfo;

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
	public boolean allValidator(String id, String pw, String pwChk, String name, String tel, String addr, String email) {
		
		boolean correctAll = false;

		// 아이디 정규표현식 : 하나 이상의 영소문자와 숫자 / 아이디는 영대소문자와 숫자를 사용 / 길이는 6~16자
		correctAll = id.matches("^(?=.*[a-z])(?=.*\\d)+[a-zA-Z0-9]{5,15}$");
		if(!correctAll) {
			return false;
		}

		// 비밀번호 정규표현식 : 하나 이상의 영대소문자와 숫자 / 비밀번호는 영대소문자와 숫자를 사용 / 길이는 8~18자
		correctAll = pw.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)+[a-zA-Z0-9]{7,17}$");
		if(!correctAll) {
			return false;
		}

		// 이름 정규표현식 : 한글만 사용 / 길이는 2~4자
		correctAll = name.matches("^[가-힣]{1,3}$");
		if(!correctAll) {
			return false;
		}

		// 연락처 :

		// 주소 : 

		// 이메일 정규 표현식 : 영대소문자와 숫자로 시작한다 / @가 반드시 붙고 뒤에 영대소문자와 숫자가 들어갈 수 있다 / 
		//					   . 이 반드시 붙고 뒤에 영소문자가 2~3개 들어갈 수 있다
		correctAll = email.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9.-]+\\.[a-z]{1,2}$");	
		if(!correctAll) {
			return false;
		}

		return correctAll;
	}
	
	// 회원 정보 비밀번호 수정 시 필요한 validator
	public boolean updatePwValidator(String pw) {
		boolean correctPw = false;
		
		return correctPw;
	}
}
