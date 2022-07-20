package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.MemberInfo;

@WebServlet("/member/delete")
public class DeleteController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션에 저장된 로그인 정보에서 id를 꺼낸다
		HttpSession session = request.getSession();

		MemberInfo memberInfo = (MemberInfo) session.getAttribute("loginUserInfo");
		String id = memberInfo.getId();
		String pw = memberInfo.getPw();
		
		String inputPw = request.getParameter("pw");

		// 회원 탈퇴
		if(inputPw.equals(pw)) {
			MemberService service = new MemberService();
			boolean result = service.deleteMemberInfo(id);
			
			if(result) {
				session.invalidate();
				response.setStatus(HttpServletResponse.SC_OK);
			}
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		} 
		
	}

}
