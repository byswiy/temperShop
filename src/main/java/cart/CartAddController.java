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

@WebServlet("/cart/add")
public class CartAddController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 상품으로 저장할 데이터를 가져온다
		int cartIdx = Integer.parseInt(request.getParameter("cartIdx"));
		int member_userIdx = Integer.parseInt(request.getParameter("member_userIdx"));
		int product_prodIdx = Integer.parseInt(request.getParameter("product_prodIdx"));
		
		// 상품을 하나의 정보로 합쳐준다
		CartInfo cartInfo = new CartInfo(cartIdx, member_userIdx, product_prodIdx);
		
		
		
		// DB에 저장한다
		CartInfoDao dao = new CartInfoDao();
		boolean result = dao.insertCartInfo(cartInfo);
		
		if(result) {
			// 장바구니 추가에 성공했다면 200 상태코드 반환
			// 세션에 정보를 저장한다
			HttpSession session = request.getSession();
			session.setAttribute("cartInfo", result);
			
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			// 장바구니 추가에 실패했다면 204 상태코드 반환
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}
	}
}
