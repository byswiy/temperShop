package review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PurchaseInfoDao;
import vo.PurchaseInfo;

@WebServlet("/review/info")
public class ReviewInfoController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("purchaseIdx") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		int purchaseIdx = Integer.parseInt(request.getParameter("purchaseIdx")); 
		
		PurchaseInfoDao dao = new PurchaseInfoDao();
		
		PurchaseInfo purchaseInfo = dao.selectBypurchaseIdx(purchaseIdx);
		
		HttpSession session = request.getSession();
		session.setAttribute("reviewInfo", purchaseInfo);
		
		response.sendRedirect("http://localhost/temperShop/review/review_add.jsp?purchaseIdx="+purchaseIdx);

	}
}
