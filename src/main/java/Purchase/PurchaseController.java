package Purchase;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BuyInfoDao;
import dao.ProductInfoDao;
import vo.PurchaseInfo;
import vo.MemberInfo;
import vo.ProductInfo;

@WebServlet("/purchase")
public class PurchaseController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// 상품 번호를 가져온다
		if(request.getParameter("prodIdx") == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}
		
		// 세션에 담긴 로그인한 사용자의 정보를 가져온다
		HttpSession session = request.getSession();
		MemberInfo loginUserInfo = (MemberInfo) session.getAttribute("loginUserInfo");
		
		// 상품 구매시 필요한 주문자 정보
		String name = loginUserInfo.getName();
		String tel = loginUserInfo.getTel();
		String email = loginUserInfo.getEmail();
		String addr = loginUserInfo.getAddr();
		
		// 상품 구매 시 필요한 데이터
		int userIdx = loginUserInfo.getUserIdx();
		int prodIdx = Integer.parseInt(request.getParameter("prodIdx"));
		int cost = Integer.parseInt(request.getParameter("cost"));
		
		ProductInfoDao dao = new ProductInfoDao();
		ProductInfo productInfo = dao.selectProductIdx(prodIdx);
		// 재고가 0일 경우 403 상태코드를 반환한다
		if(productInfo.getProdStock() == 0) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		
		dao.decreaseStock(prodIdx);
		
		PurchaseInfo buyInfo = new PurchaseInfo(userIdx, prodIdx, cost, LocalDateTime.now());
		
		BuyInfoDao buyListDao = new BuyInfoDao();
		boolean result = buyListDao.insertBuyInfo(buyInfo);
		
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
