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
		
		// 아이디 파라미터
		boolean correctId = false;
		
		// 시작은 반드시 영소문자로 시작하며 영대소문자, 숫자로 이루어진 6~16자 아이디 정규식
		correctId = id.matches("^[a-z]{1}[A-Za-z0-9]{5,15}$");
		
		if(!correctId) {
			return false;
		}
		
		return correctId;
	}
}
