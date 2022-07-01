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
		CartListInfo cartInfo = (CartListInfo) session.getAttribute("cartList");
		
		// 수정할 장바구니 번호를 가져온다
		int cartIdx = Integer.parseInt(request.getParameter("cartIdx"));

		// 수정할 상품의 데이터를 가져온다
		int beforeQuantity = cartInfo.getProdQuantity(); // -> DB를 사용해서 수정하도록 함
		int afterQuantity = Integer.parseInt(request.getParameter("afterQuantity"));
		
		String beforeProdSize = cartInfo.getProdSize();
		String afterProdSize = request.getParameter("afterProdSize");
		
		boolean result = beforeQuantity != afterQuantity || !beforeProdSize.equals(afterProdSize);
		
		if(result) {
			cartInfo.setProdQuantity(afterQuantity);
			cartInfo.setProdSize(afterProdSize);
			
			// 구매할 때 사용하기
			session.setAttribute("cart", cartInfo);
			
			response.setStatus(HttpServletResponse.SC_OK);
			
		} else {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
		}
	}

}