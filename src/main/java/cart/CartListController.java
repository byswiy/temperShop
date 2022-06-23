package cart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartInfoDao;
import vo.CartInfo;
import vo.CartListInfo;
import vo.ProductInfo;

@WebServlet("/cart/list")
public class CartListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 장바구니 목록을 구현할 정보를 가져온다
		// 세션에서 정보를 가져온다
		HttpSession session = request.getSession();
		CartInfo cartInfo = (CartInfo) session.getAttribute("cartInfo");

		int cartIdx = cartInfo.getCartIdx();
		int member_userIdx = cartInfo.getMember_userIdx();
		int product_prodIdx = cartInfo.getProduct_prodIdx();

		// session에 저장된 product_prodIdx를 사용해서 상품 정보를 가져오도록한다
		CartInfoDao dao = new CartInfoDao();
		ProductInfo productInfo = dao.selectProdIdx(product_prodIdx);

		String prodName = productInfo.getProdName();
		int prodPrice = productInfo.getProdPrice();
		int prodQuantity = productInfo.getProdQuantity();
		String prodSize = productInfo.getProdSize();
		String prodColor = productInfo.getProdColor();
		String prodImg = productInfo.getProdImg();
		
		
		CartListInfo cartList = new CartListInfo();
		cartList.setMember_userIdx(member_userIdx);
		cartList.setProdIdx(product_prodIdx);
		cartList.setProdName(prodName);
		cartList.setProdPrice(prodPrice);
		cartList.setProdQuantity(prodQuantity);
		cartList.setProdSize(prodSize);
		cartList.setProdColor(prodColor);
		cartList.setProdImg(prodImg);
		
		
		// join한 데이터를 하나의 정보로 합쳐 세션에 저장한다
		session.setAttribute("cartListInfo", cartList);
		
		// 장바구니 목록에 대한 정보를 json으로 불러와 저장한다
		CartService service = new CartService();
		String data = service.loadCartInfo(request);
		
		// JOSN을 전달한다.
		response.setContentType("text/json;application=UTF-8");
		PrintWriter out = response.getWriter();

		out.print(data);

		out.close();
	
	}
}
