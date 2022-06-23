package cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartInfoDao;

@WebServlet("/cart/delete")
public class CartDeleteController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 삭제할 장바구니 번호를 가져온다
		if(request.getParameter("cartIdx") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		int cartIdx = Integer.parseInt(request.getParameter("cartIdx"));
		
		CartInfoDao dao = new CartInfoDao();
		boolean result = dao.deleteCartIdx(cartIdx);
		
		if(result) {
			// 장바구니를 정상적으로 삭제했다면 상태코드 200 반환
			response.setStatus(HttpServletResponse.SC_OK);
		}
	}
}
