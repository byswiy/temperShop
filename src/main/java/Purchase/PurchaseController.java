package Purchase;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CartInfoDao;
import dao.ProductInfoDao;
import dao.PurchaseInfoDao;
import vo.CartInfo;
import vo.MemberInfo;
import vo.ProductInfo;
import vo.PurchaseInfo;

@WebServlet("/purchase")
public class PurchaseController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 상품 상세보기에서 구매하기 버튼을 눌렀을 때 (장바구니 거치지 않음)
		if(request.getParameter("cartIdx") == null) {
			// 세션에 담긴 로그인한 사용자의 정보를 가져온다
			HttpSession session = request.getSession();
			MemberInfo memberInfo = (MemberInfo) session.getAttribute("loginUserInfo");
			ProductInfo productInfo = (ProductInfo) session.getAttribute("prodDetail");
			
			// 상품 구매 시 필요한 데이터
			int userIdx = memberInfo.getUserIdx();
			int prodIdx = Integer.parseInt(request.getParameter("prodIdx"));
			
			ProductInfoDao dao = new ProductInfoDao();
			productInfo = dao.selectProductIdx(prodIdx);
			// 재고가 0일 경우 403 상태코드를 반환한다
			if(productInfo.getProdStock() == 0) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return;
			}
			
			// 저장할 상품의 정보를 꺼내온다
			String shopName = productInfo.getProdShopName();
			String name = productInfo.getProdName();
			int price = productInfo.getProdPrice();
			int quantity = Integer.parseInt(request.getParameter("purchaseQuantity"));
			
			// 구매 수량이 0이하일 경우 409 상태코드 반환
			if(quantity <= 0) {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
				return;
			}
			int cost = price * quantity;
			String size = productInfo.getProdSize();
			String color = productInfo.getProdColor();
			String message = request.getParameter("message");
			String img = productInfo.getProdImg();
			LocalDateTime purchaseDate = LocalDateTime.now();
			
			dao.decreaseStock(prodIdx, quantity);
			
			PurchaseInfo purchaseInfo = new PurchaseInfo(userIdx, shopName, name, price, quantity, cost, size, color, message, img, purchaseDate);
			
			PurchaseInfoDao purchaseDao = new PurchaseInfoDao();
			purchaseDao.insertPurchaseInfo(purchaseInfo);
			
			session.setAttribute("purchaseInfo", purchaseInfo);
			
		} else {
			// 장바구니에서 구매하기 버튼을 눌렀을 때
			int cartIdx = Integer.parseInt(request.getParameter("cartIdx"));
			
			CartInfoDao cartDao = new CartInfoDao();
			CartInfo cartInfo = cartDao.selectCartIdx(cartIdx);
			
			int userIdx = cartInfo.getMember_userIdx();
			int prodIdx = cartInfo.getProduct_prodIdx();
			
			ProductInfoDao prodDao = new ProductInfoDao();
			ProductInfo productInfo = prodDao.selectProductIdx(prodIdx);
			
			String shopName = productInfo.getProdShopName();
			String name = productInfo.getProdName();
			int price = productInfo.getProdPrice();
			int quantity = Integer.parseInt(request.getParameter("purchaseQuantity"));
			String size = productInfo.getProdSize();
			String color = productInfo.getProdColor();
			int cost = price * quantity;
			String message = request.getParameter("message");
			String img = productInfo.getProdImg();
			LocalDateTime purchaseDate = LocalDateTime.now();
			
			PurchaseInfo purchaseInfo = new PurchaseInfo(userIdx, shopName, name, price, quantity, cost, size, color, message, img, purchaseDate);
			
			PurchaseInfoDao purchaseDao = new PurchaseInfoDao();
			purchaseDao.insertPurchaseInfo(purchaseInfo);
			
			cartDao.deleteCartIdx(cartIdx);
			
			HttpSession session = request.getSession();
			session.setAttribute("purchaseInfo", purchaseInfo);
			
			response.sendRedirect("http://localhost/temperShop/purchase/purchase_form.jsp");
			
		}
		
	}

}
