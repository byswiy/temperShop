package product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
			
			ProductInfoDao dao = new ProductInfoDao();
    		ProductInfo productInfo = dao.selectProductIdx(prodIdx);
    		
    		HttpSession session = request.getSession();
    		session.setAttribute("prodDetail", productInfo);
    		
    		request.setAttribute("productInfo", productInfo);
    		
    		RequestDispatcher rd = request.getRequestDispatcher("/product/product_detail.jsp");
    		rd.forward(request, response);
    		
		} catch(BadParameterException e) {
			// 상품 조회에 실패했을 경우 400 상태코드 반환
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}
}
