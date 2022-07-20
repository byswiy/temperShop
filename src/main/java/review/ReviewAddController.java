package review;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.MemberInfo;
import vo.ReviewInfo;

@WebServlet("/review/add")
public class ReviewAddController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		MemberInfo memberInfo = (MemberInfo) session.getAttribute("loginUserInfo");
		
		String member_id = memberInfo.getId();
		int purchase_idx = Integer.parseInt(request.getParameter("purchaseIdx"));
		String contents = request.getParameter("contents");
		LocalDateTime insertDate = LocalDateTime.now();

		// 공지사항 데이터를 공지사항 정보로 뭉쳐주고
		ReviewInfo reviewInfo = new ReviewInfo(member_id, purchase_idx, contents, insertDate);

		// 공지사항 테이블에 저장
		ReviewService service = new ReviewService();
		boolean result = service.addReview(reviewInfo);
		
		response.setStatus(HttpServletResponse.SC_OK);
		
		response.sendRedirect("http://localhost/temperShop/review/list?reviewPage=1");
		if (result) {
			// 후기 목록 페이지로 이동
		} else {
			// 후기 추가 실패와 관련된 처리를 함
		}
	}

}
