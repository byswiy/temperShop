package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberInfoDao;
import exception.BadParameterException;
import util.MemberValidator;
import vo.MemberInfo;

@WebServlet("/member/updatePw")
public class UpdatePwController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 현재 비밀번호와 수정할 비밀번호 데이터를 꺼내온다
			String oldPw = request.getParameter("oldPw");
			String newPw = request.getParameter("newPw");
			String newPwChk = request.getParameter("newPwChk");
			
			// 비밀번호 검증
			MemberValidator validator = new MemberValidator();
			if(!validator.updatePwValidator(oldPw)) 				throw new BadParameterException();
			else if(!validator.updatePwValidator(newPw))			throw new BadParameterException();
			else if(!validator.updatePwValidator(newPwChk))			throw new BadParameterException();
			
			HttpSession session = request.getSession();
			MemberInfo loginUserInfo = (MemberInfo) session.getAttribute("loginUserInfo");
			
			String id = loginUserInfo.getId();
			
			// 로그인한 비밀번호와 전달 받은 oldPw가 같다면 비밀번호를 변경하도록 한다
			if(loginUserInfo.getPw().equals(oldPw)) {
				MemberService service = new MemberService();
				service.updatePw(id, newPw);
				
			} else {
				// 비밀번호가 일치하지 않는다면 400 상태 코드 응답
				response.setStatus(400);
				return;
			}
		} catch(BadParameterException e) {
			// 파라미터 검증에 예외가 생겼을 때 400 상태코드 반환 
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
