package Purchase;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PurchaseInfoDao;
import exception.BadParameterException;
import vo.PurchaseInfo;

@WebServlet("/update/message")
public class PurchaseMessageUpdateController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("purchaseDate") == null) {
			throw new BadParameterException();
    	}
		
		String date = request.getParameter("purchaseDate");
		
		String purchaseDate = date.substring(0, 19);
		
		String message = request.getParameter("message");
		
		PurchaseInfoDao dao = new PurchaseInfoDao();
		boolean result = dao.updateMessageByProdIdx(message, purchaseDate);
		
		if(result) {
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
	}

}
