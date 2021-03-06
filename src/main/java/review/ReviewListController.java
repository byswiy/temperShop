package review;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ReviewInfoDao;
import vo.ReviewJoinPurchase;

@WebServlet("/review/list")
public class ReviewListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewPage = 1;
		
		if(request.getParameter("reviewPage") != null) {
			reviewPage = Integer.parseInt(request.getParameter("reviewPage"));
		}
		
		// 페이지의 갯수를 가져올 Dao
		ReviewInfoDao dao = new ReviewInfoDao();
		int amountPage = dao.getAmountReview();
		
		// 페이지 조회에 실패했을 경우
		int startIndex = (reviewPage - 1) * 10;
		if(startIndex >= amountPage) {
			// 없는 페이지 번호로 접근해서 상품 목록을 조회하지 못했을 때 204 상태코드 반환
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			return;
		}
		List<ReviewJoinPurchase> reviewInfoList = dao.selectReviewInfo(reviewPage);
		
		request.setAttribute("amount", amountPage);
		request.setAttribute("reviewList", reviewInfoList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/review/review_list.jsp");
		rd.forward(request, response);
	}
}
