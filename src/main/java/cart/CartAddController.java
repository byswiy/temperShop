package cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartInfoDao;
import vo.CartInfo;
import vo.CartJoinProduct;
import vo.MemberInfo;

@WebServlet("/cart/add")
public class CartAddController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("prodIdx") == null || request.getParameter("quantity") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		HttpSession session = request.getSession();
		MemberInfo memberInfo = (MemberInfo) session.getAttribute("loginUserInfo");
		
		// 상품으로 저장할 데이터를 가져온다
		int member_userIdx = memberInfo.getUserIdx();
		int product_prodIdx = Integer.parseInt(request.getParameter("prodIdx"));
		
		// 상품 구매 수량을 가져온다
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		if(quantity <= 0) {
			response.setStatus(HttpServletResponse.SC_CONFLICT);
			return;
		}
		
		// 상품을 하나의 정보로 합쳐준다
		CartInfo cartInfo = new CartInfo(member_userIdx, product_prodIdx, quantity);
		
		// DB에 저장한다
		CartInfoDao dao = new CartInfoDao();
		boolean result = dao.insertCartInfo(cartInfo);
		
		List<CartInfo> cartInfoList = dao.selectCartList(member_userIdx);
		
		if(result) {
			session.setAttribute("cartList", cartInfoList);
			
		} else {
			
		}
	}
}
