package review;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Local;

import vo.ReviewInfo;

@WebServlet("/review/add")
public class ReviewAddController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 상품 번호를 가져온다
		if(request.getParameter("prodIdx") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		int prodIdx = Integer.parseInt(request.getParameter("prodIdx"));
		
		String contents = request.getParameter("contents");
		String insertDate = request.getParameter("insertDate");
		
		
		boolean result = service.addNotice(noticeInfo);
		
		if(result) {
			// 공지사항 목록 페이지로 이동
			response.sendRedirect(URLConfig.PAGE_NOTICE_LIST_URL);
		} else {
			// 공지사항 추가 실패와 관련된 처리를 함
		}
	}

}
