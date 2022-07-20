package product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FilterDao;
import dao.ProductInfoDao;
import vo.ProductInfo;

// 상품 가격에 따른 필터
@WebServlet("/product/filter3")
public class ProductFilterController3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNumber = 1;
		
		if(request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		
		// 페이지의 갯수를 가져올 Dao
		ProductInfoDao dao = new ProductInfoDao();
		int amountPage = dao.getCount();
		
		// 페이지 조회에 실패했을 경우
		int startIndex = (pageNumber - 1) * 12;
		if(startIndex >= amountPage) {
			// 없는 페이지 번호로 접근해서 상품 목록을 조회하지 못했을 때 204 상태코드 반환
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			return;
		}
		
		int price = Integer.parseInt(request.getParameter("prodPrice"));
		
		FilterDao filterDao = new FilterDao();
		List<ProductInfo> productInfoList = filterDao.selectPrice(pageNumber, price);
		
		if(price == 1 || price == 2) {
			request.setAttribute("amount", amountPage);
			request.setAttribute("productList", productInfoList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/product/product_list.jsp");
			rd.forward(request, response);
		}
		
	}
}
