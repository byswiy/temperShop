package Purchase;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PurchaseInfoDao;

@WebServlet("/CancelPurchaseController")
public class PurchaseCancelController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("purchaseIdx") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		int purchaseIndx = Integer.parseInt(request.getParameter("purchaseIdx"));
		
		PurchaseInfoDao dao = new PurchaseInfoDao();
		boolean result = dao.deletePurchaseIdx(purchaseIndx);
		
		if(result) {
			// 200 상태 코드 전달
			response.setStatus(HttpServletResponse.SC_OK);
		}
	}

}
