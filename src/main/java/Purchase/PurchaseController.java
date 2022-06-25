package Purchase;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductInfoDao;
import dao.PurchaseInfoDao;
import vo.CartListInfo;
import vo.MemberInfo;
import vo.ProductInfo;
import vo.PurchaseInfo;

@WebServlet("/purchase")
public class PurchaseController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 상품 상세보기에서 구매하기 버튼을 눌렀을 때
		if(request.getParameter("cartIdx") == null) {
			// 세션에 담긴 로그인한 사용자의 정보를 가져온다
			HttpSession session = request.getSession();
			MemberInfo loginUserInfo = (MemberInfo) session.getAttribute("loginUserInfo");
			
			// 상품 구매 시 필요한 데이터
			int member_userIdx = loginUserInfo.getUserIdx();
			int product_prodIdx = Integer.parseInt(request.getParameter("product_prodIdx"));
			int cost = Integer.parseInt(request.getParameter("cost"));
			String message = request.getParameter("message");
			LocalDateTime purchaseDate = LocalDateTime.now();
			
			ProductInfoDao dao = new ProductInfoDao();
			ProductInfo productInfo = dao.selectProductIdx(product_prodIdx);
			// 재고가 0일 경우 403 상태코드를 반환한다
			if(productInfo.getProdStock() == 0) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return;
			}
			
			dao.decreaseStock(product_prodIdx);
			
			PurchaseInfo purchaseInfo = new PurchaseInfo(member_userIdx, product_prodIdx, cost, message, purchaseDate);
			
			PurchaseInfoDao purchaseDao = new PurchaseInfoDao();
			purchaseDao.insertPurchaseInfo(purchaseInfo);
			
			session.setAttribute("purchaseInfo", purchaseInfo);
			
			// 상품 구매에 성공했다면 상태코드 200 반환
			response.setStatus(HttpServletResponse.SC_OK);
		} else {
			// 장바구니에서 구매하기 버튼을 눌렀을 때
			HttpSession session = request.getSession();
			MemberInfo loginUserInfo = (MemberInfo) session.getAttribute("loginUserInfo");
			
			CartListInfo cartListInfo = (CartListInfo) request.getAttribute("cartListInfo");
			
			int cartIdx = cartListInfo.getCartIdx();
			int member_userIdx = cartListInfo.getMember_userIdx();
			int product_prodIdx = cartListInfo.getProdIdx();
			int cost = Integer.parseInt(request.getParameter("cost"));
			String message = request.getParameter("message");
			LocalDateTime purchaseDate = LocalDateTime.now();
			
			ProductInfoDao dao = new ProductInfoDao();
			ProductInfo productInfo = dao.selectProductIdx(product_prodIdx);
			// 재고가 0일 경우 403 상태코드를 반환한다
			if(productInfo.getProdStock() == 0) {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return;
			}
			
			dao.decreaseStock(product_prodIdx);
			
			PurchaseInfo purchaseInfo = new PurchaseInfo(member_userIdx, product_prodIdx, cartIdx, cost, message, purchaseDate);
			
			PurchaseInfoDao purchaseDao = new PurchaseInfoDao();
			purchaseDao.insertPurchaseInfo(purchaseInfo);
			
			session.setAttribute("purchaseInfo", purchaseInfo);
			
			// 상품 구매에 성공했다면 상태코드 200 반환
			response.setStatus(HttpServletResponse.SC_OK);
		}
		
		
	}
	

}
