package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.BadParameterException;
import util.MemberValidator;
import vo.MemberInfo;

// 수정할 수 있는 정보 : 연락처, 주소, 이메일
// 수정할 때 보여줄 회원 정보 : 아이디, 이름, 연락처, 주소, 이메일
@WebServlet("/member/update")
public class UpdateExclusionPwController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			// 수정할 이름, 연락처, 주소, 이메일 데이터를 꺼내온다
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String postalCode = request.getParameter("postalCode");
			String addr = request.getParameter("addr");
			String email = request.getParameter("email");
			
			MemberValidator validator = new MemberValidator();
			
			// 수정할 정보들의 데이터를 검증한다
			if(!validator.nameValidator(name))						throw new BadParameterException();
			else if(!validator.telValidator(tel)) 					throw new BadParameterException();
			else if(!validator.postalCodeValidator(postalCode)) 	throw new BadParameterException();
			else if(!validator.addrValidator(addr)) 				throw new BadParameterException();
			else if(!validator.emailValidator(email))				throw new BadParameterException();
			
			// 세션에 저장했던 아이디를 꺼내온다
			HttpSession session = request.getSession();
			MemberInfo loginInfo = (MemberInfo) session.getAttribute("loginUserInfo");
			String id = loginInfo.getId();
			
			// 수정할 연락처와 이메일이 사용중인지 확인
			// 사용중인 데이터가 있다면 409 상태코드 반환
			MemberService service = new MemberService();
			if(service.existTelOrEmail(id, tel, email)) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				return;
			}
			
			// 회원 정보 수정
			MemberInfo memberInfo = new MemberInfo(id, name, tel, postalCode, addr, email);
			service.updateExclusionPw(memberInfo);
			
			session.setAttribute("loginUserInfo", memberInfo);
		} catch(BadParameterException e) {
			// 파라미터 검증에 예외가 생겼을 때 400 상태코드 반환 
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
