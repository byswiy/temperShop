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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if(request.getParameter("prodIdx") == null) {
				throw new BadParameterException();
        	}
    		
			int prodIdx = Integer.parseInt(request.getParameter("prodIdx"));
			
			// 상품 구매 수량을 꺼내온다
			int prodQuantity = Integer.parseInt(request.getParameter("prodQuantity"));
			
			ProductInfoDao dao = new ProductInfoDao();
    		ProductInfo productInfo = dao.selectProductIdx(prodIdx);
    		productInfo.setProdQuantity(prodQuantity);
    		
    		HttpSession session = request.getSession();
    		session.setAttribute("productList", productInfo);
			
    		// 상품 정보를 json 형태로 반환
    		String data = "{\"prodIdx\":\"(1)\",\"prodName\":\"(2)\",\"prodPrice\":\"(3)\",\"prodStock\":(4),\"prodQuantity\":(5),"
    				     + "\"prodSize\":(6),\"prodColor\":\"(7)\",\"prodCategory\":\"(8)\",\"prodImg\":\"(9)\"}";
    		
    		data = data.replace("(1)", String.valueOf(productInfo.getProdIdx()));
    		data = data.replace("(2)", productInfo.getProdName());
    		data = data.replace("(3)", String.valueOf(productInfo.getProdPrice()));
    		data = data.replace("(4)", String.valueOf(productInfo.getProdQuantity()));
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
