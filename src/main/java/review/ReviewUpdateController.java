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
		
		ReviewInfo noticeInfo = new ReviewInfo();
		
		NoticeService service = new NoticeService();
		
		boolean result = service.updateNoticeInfo(noticeInfo);
		
		if(result) {
			// 공지사항을 성공적으로 수정했다면
			// 상태코드 200으로 응답
		} else {
			// 공지사항을 성공적으로 수정하지 못했다면
			// 상태 코드 400으로 응답
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
