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
		if(request.getParameter("cart_cartIdx") == "") {
			// 세션에 담긴 로그인한 사용자의 정보를 가져온다
			HttpSession session = request.getSession();
			MemberInfo loginUserInfo = (MemberInfo) session.getAttribute("loginUserInfo");
			ProductInfo productInfo = (ProductInfo) session.getAttribute("productList");
			
			// 상품 구매 시 필요한 데이터
			int member_userIdx = loginUserInfo.getUserIdx();
			int product_prodIdx = productInfo.getProdIdx();
			
			ProductInfoDao dao = new ProductInfoDao();
			productInfo = dao.selectProductIdx(product_prodIdx);
			// 재고가 0일 경우 403 상태코드를 반환한다
			if(productInfo.getProdStock() == 0) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return;
			}
			
			int cost = productInfo.getProdPrice();
			String message = request.getParameter("message");
			LocalDateTime purchaseDate = LocalDateTime.now();
			
			dao.decreaseStock(product_prodIdx);
			
			PurchaseInfo purchaseInfo = new PurchaseInfo(member_userIdx, product_prodIdx, cost, message, purchaseDate);
			
			PurchaseInfoDao purchaseDao = new PurchaseInfoDao();
			purchaseDao.insertPurchaseInfo(purchaseInfo);
			
			session.setAttribute("purchaseInfo", purchaseInfo);
			
			// 상품 구매에 성공했다면 상태코드 200 반환
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			// 장바구니에서 구매하기 버튼을 눌렀을 때
			int cart_cartIdx = Integer.parseInt(request.getParameter("cart_cartIdx"));
			
			CartInfoDao cartDao = new CartInfoDao();
			CartInfo cartInfo = cartDao.selectCartIdx(cart_cartIdx);
			
			int member_userIdx = cartInfo.getMember_userIdx();
			int product_prodIdx = cartInfo.getProduct_prodIdx();
			
			ProductInfoDao prodDao = new ProductInfoDao();
			ProductInfo productInfo = prodDao.selectProductIdx(product_prodIdx);
			
			int cost = productInfo.getProdPrice();
			String message = request.getParameter("message");
			LocalDateTime purchaseDate = LocalDateTime.now();
			
			// 재고가 0일 경우 403 상태코드를 반환한다
			if(productInfo.getProdStock() == 0) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return;
			}
			
			prodDao.decreaseStock(product_prodIdx);
			
			PurchaseInfo purchaseInfo = new PurchaseInfo(member_userIdx, product_prodIdx, cart_cartIdx, cost, message, purchaseDate);
			
			PurchaseInfoDao purchaseDao = new PurchaseInfoDao();
			purchaseDao.insertPurchaseInfo(purchaseInfo);
			
			HttpSession session = request.getSession();
			session.setAttribute("purchaseInfo", purchaseInfo);
			
			// 상품 구매에 성공했다면 상태코드 200 반환
			response.setStatus(HttpServletResponse.SC_OK);
		}
		
		
	}

}
