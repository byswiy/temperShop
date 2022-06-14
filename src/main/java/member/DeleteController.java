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

		// 회원 탈퇴
		MemberService service = new MemberService();
		service.deleteMemberInfo(id);

		// 회원 정보 세션 삭제
		session.invalidate();

		// 정상적으로 회원 탈퇴가 되었다면 200 상태코드 반환
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
