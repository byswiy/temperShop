package Purchase;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PurchaseInfoDao;
import vo.PurchaseInfo;

@WebServlet("/update/message")
public class PurchaseMessageUpdateController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PurchaseInfo purchaseInfo = (PurchaseInfo) session.getAttribute("purchaseInfo");
		
		int product_prodIdx = purchaseInfo.getProduct_prodIdx();
		String message = request.getParameter("message");
		
		PurchaseInfoDao dao = new PurchaseInfoDao();
		dao.updateMessageByProdIdx(message, product_prodIdx);
		
		purchaseInfo = dao.selectPurchaseInfoByprodIdx(product_prodIdx);
		
		session.setAttribute("purchaseInfo", purchaseInfo);
	}

}
