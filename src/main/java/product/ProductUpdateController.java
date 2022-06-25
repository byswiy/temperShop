package product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductInfoDao;
import exception.BadParameterException;
import util.ProductValidator;
import vo.ProductInfo;

@WebServlet("/product/update")
public class ProductUpdateController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 상품 수정시 이미지 파일은 수정하지 않는다
			if(request.getParameter("prodIdx") == null || request.getParameter("prodPrice") == null || request.getParameter("prodStock") == null) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
			
			// 수정할 상품의 정보를 세션에서 꺼내온다
			HttpSession session = request.getSession();
			ProductInfo productInfoList = (ProductInfo) session.getAttribute("productInfoList");
			
			int prodIdx = productInfoList.getProdIdx();
			int prodPrice = productInfoList.getProdPrice();
			int prodStock = productInfoList.getProdStock();
			String prodSize = productInfoList.getProdSize();
			String prodColor = productInfoList.getProdColor();
			
			// 전달 받은 값 검증
			ProductValidator validator = new ProductValidator();
			
			ProductInfo productInfo = new ProductInfo();
			productInfo.setProdIdx(prodIdx);
			productInfo.setProdPrice(prodPrice);
			productInfo.setProdStock(prodStock);
			productInfo.setProdSize(prodSize);
			productInfo.setProdColor(prodColor);
			
			
			ProductInfoDao dao = new ProductInfoDao();
			dao.updateProductInfo(productInfo);
			
		} catch (BadParameterException e) {
			// 파라미터 검증에 예외가 생겼을 때 400 상태코드 반환 
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
