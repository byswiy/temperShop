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
import vo.ProductInfo;

@WebServlet("/cart/add")
public class CartAddController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("member_userIdx") == null || request.getParameter("product_prodIdx") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		HttpSession session = request.getSession();
		ProductInfo productInfo = (ProductInfo) session.getAttribute("productList");
		MemberInfo memberInfo = (MemberInfo) session.getAttribute("loginUserInfo");
		
		// 상품으로 저장할 데이터를 가져온다
		int member_userIdx = memberInfo.getUserIdx();
		int product_prodIdx = productInfo.getProdIdx();
		
		// 상품 구매 수량을 가져온다
		int prodQuantity = productInfo.getProdQuantity();
		
		// 상품을 하나의 정보로 합쳐준다
		CartInfo cartInfo = new CartInfo(member_userIdx, product_prodIdx, prodQuantity);
		
		// DB에 저장한다
		CartInfoDao dao = new CartInfoDao();
		boolean result = dao.insertCartInfo(cartInfo);
		
		if(result) {
			// 장바구니 추가에 성공했다면 200 상태코드 반환
			// session에 정보를 저장한다
			session.setAttribute("cartInfo", cartInfo);
			
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			// 장바구니 추가에 실패했다면 204 상태코드 반환
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		}
	}
}
