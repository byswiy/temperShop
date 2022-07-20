package review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.MemberInfo;

@WebServlet("/review/delete")
public class ReviewDeleteController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 전달한 reviewIdx를 사용해서 DB에 저장된 데이터를 삭제하도록 한다
		int reviewIdx = Integer.parseInt(request.getParameter("reviewIdx"));
		String member_id = request.getParameter("member_id");
		
		HttpSession session = request.getSession();
		MemberInfo memberInfo = (MemberInfo) session.getAttribute("loginUserInfo");
		String loginId = memberInfo.getId();
		
		// DB에서 해당 reviewIdx를 가진 후기를 삭제한다
		ReviewService service = new ReviewService();
		
		if(member_id.equals(loginId) || loginId.equals("admin00")) {
			boolean result = service.deleteReview(reviewIdx);
			if(result) {
				response.sendRedirect("http://localhost/temperShop/review/list?reviewPage=1");
			}
		} else {
			response.sendRedirect("http://localhost/temperShop/review/list?reviewPage=1");
		}
		
		
		
		// 클라이언트에게 삭제 결과인 200 상태 코드를 전달
	}

}
