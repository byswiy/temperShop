package product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductInfoDao;
import exception.BadParameterException;
import vo.ProductInfo;

@WebServlet("/product/detail")
public class ProductDetailController extends HttpServlet {
	protected void dopost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// request에 저장했던 상품의 정보를 꺼내와서 사용하도록 한다
			ProductInfo productInfo = (ProductInfo) request.getAttribute("productList");
			
			// 상품 구매 수량을 꺼내온다
			int prodQuantity = Integer.parseInt(request.getParameter("prodQuantity"));
			productInfo.setProdQuantity(prodQuantity);
			
			// 상품 구매 수량까지 추가된 상품 정보를 세션에 저장하도록 한다
			HttpSession session = request.getSession();
			session.setAttribute("productInfoList", productInfo);
			
    		// 상품 정보를 json 형태로 반환
    		String data = "{\"prodIdx\":\"(1)\",\"prodName\":\"(2)\",\"prodPrice\":\"(3)\",\"prodStock\":(4),\"prodQuantity\":(5),"
    				     + "\"prodSize\":(6),\"prodColor\":\"(7)\",\"prodCategory\":\"(8)\",\"prodImg\":\"(9)\"}";
    		
    		data = data.replace("(1)", String.valueOf(productInfo.getProdIdx()));
    		data = data.replace("(2)", productInfo.getProdName());
    		data = data.replace("(3)", String.valueOf(productInfo.getProdPrice()));
    		data = data.replace("(4)", productInfo.getProdStock() + "");
    		data = data.replace("(5)", productInfo.getProdQuantity() + "");
    		data = data.replace("(6)", productInfo.getProdSize());
    		data = data.replace("(7)", productInfo.getProdColor());
    		data = data.replace("(8)", productInfo.getProdCategory());
    		data = data.replace("(9)", productInfo.getProdImg());
    		
    		response.setContentType("application/json;charset=UTF-8");
    		
    		PrintWriter out = response.getWriter();
    		out.print(data);
    		out.close(); 
    		
		} catch(BadParameterException e) {
			// 상품 조회에 실패했을 경우 400 상태코드 반환
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
