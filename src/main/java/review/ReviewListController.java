package review;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ReviewInfo;

@WebServlet("/review/list")
public class ReviewListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 후기를 불러오는 컨트롤러
		// 상품 후기 목록에 대한 정보를 json으로 불러와 저장한다
		ReviewService service = new ReviewService();
		String data = service.loadReviewInfo();
		
		// JOSN을 전달한다.
		response.setContentType("text/json;application=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(data);
		
		out.close();
	}
}
