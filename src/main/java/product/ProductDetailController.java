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
			// 상품의 상세 정보를 가져오기 위해 상품 번호를 가져온다
			if(request.getParameter("prodIdx") == null) {
				throw new BadParameterException();
			}
			
			int prodIdx = Integer.parseInt(request.getParameter("prodIdx"));
			
			// 상품 정보 조회
			ProductInfoDao dao = new ProductInfoDao();
			ProductInfo productInfo = dao.selectProductIdx(prodIdx);
			
			// 존재하지 않는 상품아이디를 입력했을 경우 204 상태 코드 반환
    		if(productInfo == null) {
    			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    			return;
    		}
    		
    		// 상품 정보를 json 형태로 반환
    		String data = "{\"prodName\":\"(1)\",\"prodPrice\":\"(2)\",\"prodStock\":(3),\"prodSize\":(4),\"prodColor\":\"(5)\",\"prodImg\":\"(6)\"}";
    		
    		data = data.replace("(1)", productInfo.getProdName());
    		data = data.replace("(2)", String.valueOf(productInfo.getProdPrice()));
    		data = data.replace("(3)", productInfo.getProdStock() + "");
    		data = data.replace("(4)", productInfo.getProdSize());
    		data = data.replace("(5)", productInfo.getProdColor());
    		data = data.replace("(5)", productInfo.getProdImg());
    		
    		response.setContentType("application/json;charset=UTF-8");
    		
    		PrintWriter out = response.getWriter();
    		out.print(data);
    		out.close(); 
    		
		} catch(BadParameterException e) {
			
		}
	}
}
