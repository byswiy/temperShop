package cart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartInfoDao;
import dao.ProductInfoDao;
import vo.CartInfo;
import vo.CartListInfo;
import vo.ProductInfo;

@WebServlet("/cart/list")
public class CartListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 페이지번호를 꺼내온다
		int pageNumber = 1;
		if (request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}

		// 페이지의 갯수를 가져올 dao
		CartInfoDao dao = new CartInfoDao();

		int amountOfProductInfo = dao.getAmountCart();
		// 페이지 조회에 실패할 경우
		int startIndex = (pageNumber - 1) * 8;
		if (startIndex >= amountOfProductInfo) {
			// 없는 페이지 번호로 접근해서 상품 목록을 조회하지 못했을 때
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			return;
		}

		List<CartListInfo> cartListInfo = new ArrayList<>();
		
		List<CartInfo> cartInfo = dao.selectAll(pageNumber);
		
		for(CartInfo cart : cartInfo) {
			int member_userIdx = cart.getMember_userIdx();
			int product_prodIdx = cart.getProduct_prodIdx();
			
			ProductInfo productInfo = new ProductInfo();
			ProductInfoDao prodDao = new ProductInfoDao();
			productInfo = prodDao.selectProductIdx(product_prodIdx);
			
			String prodShopName = productInfo.getProdShopName();
			String prodName = productInfo.getProdName();
			int prodPrice = productInfo.getProdPrice();
			int prodQuantity = cart.getQuantity();
			String prodSize = productInfo.getProdSize();
			String prodColor = productInfo.getProdColor();
			String prodType = productInfo.getProdType();
			String prodImg = productInfo.getProdImg();
			
			CartListInfo cartList = new CartListInfo(member_userIdx, product_prodIdx, prodShopName, prodName,
					                    prodPrice, prodQuantity, prodSize, prodColor, prodType, prodImg);
			
			cartListInfo.add(cartList);
		}

		// 요청 정보안에 상품 정보 저장
		request.setAttribute("cartList", cartListInfo);

		response.setStatus(HttpServletResponse.SC_OK);
	}
}
