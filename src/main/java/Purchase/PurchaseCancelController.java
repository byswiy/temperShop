package Purchase;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PurchaseInfoDao;
import vo.PurchaseInfo;

// 구매 내역에서 상품을 삭제했을 경우 이동하는 controller
@WebServlet("/purchase/cancel")
public class PurchaseCancelController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("purchaseIdx") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		if(request.getParameter("userIdx") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		int purchaseIdx = Integer.parseInt(request.getParameter("purchaseIdx"));
		
		int userIdx = Integer.parseInt(request.getParameter("userIdx"));
		
		PurchaseInfoDao dao = new PurchaseInfoDao();
		
		boolean result = dao.deletePurchaseIdx(purchaseIdx);
		
		if(result) {
			response.sendRedirect("http://localhost/temperShop/purchase/history?userIdx="+userIdx);
		} else {
			
		}
	}

}
