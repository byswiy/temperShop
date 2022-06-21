package review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ReviewInfo;

@WebServlet("/review/add")
public class ReviewAddController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 후기 작성을 위한 컨트롤러
		request.setCharacterEncoding("UTF-8");

		// 후기 작성에 필요한 데이터를 꺼내온다
		String contents = request.getParameter("contents");

		ReviewService service = new ReviewService();
		ReviewInfo reviewInfo = new ReviewInfo();

		boolean result = service.addReview(reviewInfo);

		if (result) {
			// 공지사항 목록 페이지로 이동
		} else {
			// 공지사항 추가 실패와 관련된 처리
		}
	}

}
