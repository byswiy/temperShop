package product;

import java.io.IOException;
import java.util.Arrays;

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
			}
			// 수정할 상품의 정보를 세션에서 꺼내온다 -> 수정하기 전에 보여줄 데이터
			HttpSession session = request.getSession();
			ProductInfo productInfoList = (ProductInfo) session.getAttribute("productList");
			
			int prodIdx = Integer.parseInt(request.getParameter("prodIdx"));
			
			// 수정할 데이터를 꺼내온다
			int prodPrice =  Integer.parseInt(request.getParameter("prodPrice"));
			int prodStock =  Integer.parseInt(request.getParameter("prodStock"));
			String prodSize = request.getParameter("prodSize");
			String prodColor = request.getParameter("prodColor");
			
			// 전달 받은 값 검증
			ProductValidator validator = new ProductValidator();
			if(!validator.updateValidator(prodPrice, prodStock, prodSize, prodColor)) {
				throw new BadParameterException();
			}
			
			ProductInfo productInfo = new ProductInfo();
			productInfo.setProdIdx(prodIdx);
			productInfo.setProdPrice(prodPrice);
			productInfo.setProdStock(prodStock);
			productInfo.setProdSize(prodSize);
			productInfo.setProdColor(prodColor);
			
			
			ProductInfoDao dao = new ProductInfoDao();
			boolean result = dao.updateProductInfo(productInfo);
			
			if(result) {
				response.setStatus(HttpServletResponse.SC_OK);
			}
			
		} catch (BadParameterException e) {
			// 파라미터 검증에 예외가 생겼을 때 400 상태코드 반환 
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
