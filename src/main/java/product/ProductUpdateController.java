package product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductInfoDao;
import exception.BadParameterException;
import util.ProductValidator;
import vo.ProductInfo;

@WebServlet("/product/update")
public class ProductUpdateController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			// 상품 수정시 이미지 파일은 수정하지 않는다
			if(request.getParameter("prodIdx") == null || request.getParameter("prodPrice") == null || request.getParameter("prodStock") == null) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
			int prodIdx = Integer.parseInt(request.getParameter("prodIdx"));
			
			// 수정할 데이터를 꺼내온다
			String prodName = request.getParameter("prodName");
			int prodPrice =  Integer.parseInt(request.getParameter("prodPrice"));
			int prodStock =  Integer.parseInt(request.getParameter("prodStock"));
			String prodSize = request.getParameter("prodSize");
			String prodColor = request.getParameter("prodColor");
			String prodCategory = request.getParameter("prodCategory");
			String prodType = request.getParameter("prodType");
			
			// 전달 받은 값 검증
			ProductValidator validator = new ProductValidator();
			if(!validator.prodNameValidator(prodName))									throw new BadParameterException();
			else if(!validator.prodStockOrProdPriceValidator(prodStock, prodPrice))		throw new BadParameterException();
			else if(!validator.prodSizeValidator(prodSize)) 							throw new BadParameterException();
			else if(!validator.prodColorValidator(prodColor)) 							throw new BadParameterException();
			else if(!validator.prodCategoryValidator(prodCategory))						throw new BadParameterException();
			else if(!validator.prodTypeValidator(prodType)) 							throw new BadParameterException();

			
			ProductInfo productInfo = new ProductInfo(prodIdx, prodName, prodPrice, prodStock, prodSize, prodColor, prodCategory, prodType);
			
			
			ProductInfoDao dao = new ProductInfoDao();
			dao.updateProductInfo(productInfo);
			
			
		} catch (BadParameterException e) {
			// 파라미터 검증에 예외가 생겼을 때 400 상태코드 반환 
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
