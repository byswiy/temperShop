package buy;

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
import vo.BuyInfo;
import vo.MemberInfo;
import vo.ProductInfo;

@WebServlet("/ProductBuyControlller")
public class ProductBuyControlller extends HttpServlet {
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
		
		BuyInfo buyInfo = new BuyInfo(userIdx, prodIdx, cost, LocalDateTime.now());
		
		BuyInfoDao buyListDao = new BuyInfoDao();
		boolean result = buyListDao.insertBuyInfo(buyInfo);
		
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
