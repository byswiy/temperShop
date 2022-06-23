package cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.CartListInfo;

@WebServlet("/cart/update")
public class CartUpdateController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 장바구니 목록에서 저장했던 세션을 사용해 수정할 정보를 가져온다
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		CartListInfo cartInfo = (CartListInfo) session.getAttribute("cartListInfo");
		
		
	}
}
