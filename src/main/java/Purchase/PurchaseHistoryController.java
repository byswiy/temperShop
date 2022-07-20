package Purchase;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PaymentDao;
import dao.PurchaseInfoDao;
import vo.PaymentInfo;
import vo.PurchaseInfo;

@WebServlet("/purchase/history")
public class PurchaseHistoryController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		if(request.getParameter("userIdx") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		int userIdx = Integer.parseInt(request.getParameter("userIdx")); 
		
		
		
		PurchaseInfoDao dao = new PurchaseInfoDao();
		
		List<PurchaseInfo> purchaseInfoList = dao.selectByUserIdx(userIdx);
		
		request.setAttribute("purchaseList", purchaseInfoList);
		
		RequestDispatcher rd = request.getRequestDispatcher("/myPage/purchase_history.jsp");
		rd.forward(request, response);
		
	}

}
