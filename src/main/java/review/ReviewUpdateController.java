package review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ReviewInfo;

@WebServlet("/review/update")
public class ReviewUpdateController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정할 후기의 정보를 가져온다
		int reviewIdx = Integer.parseInt(request.getParameter("reviewIdx"));
		String contents = request.getParameter("contents");
		
		ReviewInfo reviewInfo = new ReviewInfo();
		reviewInfo.setReviewIdx(reviewIdx);
		reviewInfo.setContents(contents);
		
		ReviewService service = new ReviewService();
		
		boolean result = service.updateReview(reviewInfo);
		
		if(result) {
			// 후기 수정에 성공했다면 상태코드 200 반환
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			// 후기 수정에 실패했다면 상태코드 400 반환
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
