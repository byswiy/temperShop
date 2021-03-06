package cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartInfoDao;
import vo.CartInfo;
import vo.MemberInfo;

@WebServlet("/cart/update")

public class CartUpdateController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 장바구니 목록에서 저장했던 세션을 사용해 수정할 정보를 가져온다
		request.setCharacterEncoding("UTF-8");

		// 수정할 장바구니 번호를 가져온다
		int cartIdx = Integer.parseInt(request.getParameter("cartIdx"));

		// 수정할 상품의 데이터를 가져온다
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		HttpSession session = request.getSession();
		MemberInfo memberInfo = (MemberInfo) session.getAttribute("loginUserInfo");
		
		int userIdx = memberInfo.getUserIdx();
		
		CartInfo cartInfo = new CartInfo();
		cartInfo.setCartIdx(cartIdx);
		cartInfo.setQuantity(quantity);
		
		CartInfoDao dao = new CartInfoDao();
		boolean result = dao.updateCartInfo(cartInfo);
		
		if(result) {
			response.sendRedirect("http://localhost/temperShop/cart/list?userIdx="+userIdx);
		} else {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		}
		
	}

}