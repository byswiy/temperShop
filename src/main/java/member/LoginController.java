package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.BadParameterException;
import util.MemberValidator;
import vo.MemberInfo;

@WebServlet("/member/login")
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그 아웃 처리
		HttpSession session = request.getSession();
		session.removeAttribute("loginUserInfo");
		
		response.sendRedirect("/temperShop/product/product_list.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");	
			
			MemberValidator validator = new MemberValidator();
			
			// 아이디, 비밀번호 검증
			if(!validator.idValidator(id))							throw new BadParameterException();
			else if(!validator.pwValidator(pw)) 						throw new BadParameterException();
			
			MemberInfo loginInfo = new MemberInfo();
			loginInfo.setId(id);
			loginInfo.setPw(pw);
			
			// 로그인 서비스
			MemberService service = new MemberService();
			loginInfo = service.selectId(id);
			
			if(loginInfo == null || !loginInfo.getPw().equals(pw)) {
				// 아이디나 비밀번호의 오류일 경우 401 상태 코드 반환
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			} else {
				// 로그인에 성공했다면 200 반환 및 세션 저장
				HttpSession session = request.getSession();
				session.setAttribute("loginUserInfo", loginInfo);
				response.setStatus(HttpServletResponse.SC_OK);
			}
		} catch(BadParameterException e) {
			// 파라미터 검증에 예외가 생겼을 때 400 상태코드 반환 
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
	}

}
