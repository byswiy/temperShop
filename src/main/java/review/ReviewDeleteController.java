package review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/review/delete")
public class ReviewDeleteController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewIdx = Integer.parseInt(request.getParameter("reviewIdx"));
		
		// DB에서 해당 reviewIdx를 가진 후기를 삭제한다
		ReviewService service = new ReviewService();
		
		boolean result = service.deleteReview(reviewIdx);
		
		// 클라이언트에게 삭제 결과인 200 상태 코드를 전달
		if(result) {
			// 200 상태 코드 전달
			
		} else {
			// 삭제 하지 못했다는 의미의 상태 코드를 전달
			
		}
	}

}
