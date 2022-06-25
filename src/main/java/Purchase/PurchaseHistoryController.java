package Purchase;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberInfoDao;
import dao.ProductInfoDao;
import vo.MemberInfo;
import vo.ProductInfo;
import vo.PurchaseInfo;
import vo.PurchaseListInfo;

@WebServlet("/purchase/history")
public class PurchaseHistoryController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PurchaseInfo purchaseInfo = (PurchaseInfo) session.getAttribute("purchaseInfo");
		
		int member_userIdx = purchaseInfo.getMember_userIdx();
		int product_prodIdx = purchaseInfo.getProduct_prodIdx();
		
		// 회원 정보
		MemberInfoDao memberDao = new MemberInfoDao();
		MemberInfo memberInfo = memberDao.selectByUserIdx(member_userIdx);
		
		// 상품 정보
		ProductInfoDao productDao = new ProductInfoDao();
		ProductInfo productInfo = productDao.selectProductIdx(product_prodIdx);
		
		// 구매 내역에 필요한 데이터를 꺼내온다
		String purchaseId = memberInfo.getId();
		String purchaseName = productInfo.getProdName();
		int purchasePrice = productInfo.getProdPrice();
		int purchaseQuantity = productInfo.getProdQuantity();
		String purchaseSize = productInfo.getProdSize();
		String purchaseColor = productInfo.getProdColor();
		LocalDateTime purchaseDate = purchaseInfo.getPurchaseDate();
		
		PurchaseListInfo purchaseListInfo = new PurchaseListInfo(purchaseId, purchaseName, purchasePrice, purchaseQuantity, purchaseSize, purchaseColor, purchaseDate);
		
		session.setAttribute("purchaseListInfo", purchaseListInfo);
		
		
	}

}
