package Purchase;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberInfoDao;
import dao.ProductInfoDao;
import dao.PurchaseInfoDao;
import vo.MemberInfo;
import vo.ProductInfo;
import vo.PurchaseInfo;
import vo.PurchaseListInfo;

@WebServlet("/purchase/history")
public class PurchaseHistoryController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PurchaseInfoDao dao = new PurchaseInfoDao();
		int amount = dao.getCount();
		
		HttpSession session = request.getSession();
		PurchaseInfo purchaseInfo = (PurchaseInfo) session.getAttribute("purchaseInfo");

		int member_userIdx = Integer.parseInt(request.getParameter("member_userIdx"));
		int product_prodIdx = purchaseInfo.getProduct_prodIdx();

		// 회원 정보
		MemberInfoDao memberDao = new MemberInfoDao();
		MemberInfo memberInfo = memberDao.selectByUserIdx(member_userIdx);

		// 상품 정보
		ProductInfoDao productDao = new ProductInfoDao();
		ProductInfo productInfo = productDao.selectProductIdx(product_prodIdx);
		
		List<PurchaseListInfo> purchaseListInfo = new ArrayList<>();

		// 구매 내역에 필요한 데이터를 꺼내온다
		for(int i=1; i<=amount; i++ ) {
			String purchaseId = memberInfo.getId();
			String purchaseShopName = productInfo.getProdShopName();
			String purchaseName = productInfo.getProdName();
			int purchasePrice = productInfo.getProdPrice();
			int purchaseQuantity = productInfo.getProdQuantity();
			String purchaseSize = productInfo.getProdSize();
			String purchaseColor = productInfo.getProdColor();
			String purchaseType = productInfo.getProdType();
			String purchaseImg = productInfo.getProdImg();
			LocalDateTime purchaseDate = purchaseInfo.getPurchaseDate();
			
			PurchaseListInfo lsit = new PurchaseListInfo(purchaseId, purchaseShopName, purchaseName,
					purchasePrice, purchaseQuantity, purchaseSize, purchaseColor, purchaseType, purchaseImg, purchaseDate);
			
			purchaseListInfo.add(lsit);
		}
		
		session.setAttribute("purchaseListInfo", purchaseListInfo);
	}

}
