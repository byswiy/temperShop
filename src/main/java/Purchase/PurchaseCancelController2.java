package Purchase;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PurchaseInfoDao;
import vo.PurchaseInfo;

// 구매 취소 후 상품 목록으로 돌아갈 때 사용할 controller
@WebServlet("/purchase/cancel_list")
public class PurchaseCancelController2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("purchaseDate") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		String date = request.getParameter("purchaseDate");
		
		String purchaseDate = date.substring(0, 19);
		
		
		PurchaseInfoDao dao = new PurchaseInfoDao();
		
		boolean result = dao.deletePurchaseIdx(purchaseDate);
		
		if(result) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {

		}
	}

}
