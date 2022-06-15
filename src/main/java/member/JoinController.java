package member;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.BadParameterException;
import util.MemberValidator;
import vo.MemberInfo;

@WebServlet("/member/join")
public class JoinController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			// 회원 정보로 입력된 데이터를 꺼내온다
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String pwChk = request.getParameter("pwChk");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String addr = request.getParameter("addr");
			String email = request.getParameter("email");
			LocalDateTime joinDate = LocalDateTime.now();
			
			// 꺼내온 데이터를 검증한다
			MemberValidator validator = new MemberValidator();
			if(!validator.allValidator(id, pw, pwChk, name, tel, addr, email)) {
				throw new BadParameterException();
			}
			
			// 데이터를 하나의 정보로 합친다
			MemberInfo memberInfo = new MemberInfo(id, pw, name, tel, addr, email, joinDate);
			
			MemberService service = new MemberService();
			
			// 아이디, 연락처, 이메일의 유효성 검사
			// 이미 사용중인 데이터라면 409 상태코드 반환
			if(service.existIdOrTelOrEmail(id, tel, email)) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				return;
			}
			
			int status = service.join(memberInfo);
			response.setStatus(status);
			
		} catch(BadParameterException e) {
			// 파라미터 검증에 예외가 생겼을 때 400 상태코드 반환 
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
	}

}
