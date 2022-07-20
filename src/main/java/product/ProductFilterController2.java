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

// 상품 색상에 따른 필터
@WebServlet("/product/filter2")
public class ProductFilterController2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNumber = 1;
		
		if(request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		
		String prodColor = request.getParameter("prodColor");
		
		// 페이지의 갯수를 가져올 Dao
		FilterDao filterDao = new FilterDao();
		int amountProdColor = filterDao.getProdColor(prodColor);
		
		// 페이지 조회에 실패했을 경우
		int startIndex = (pageNumber - 1) * 12;
		if(startIndex >= amountProdColor) {
			// 없는 페이지 번호로 접근해서 상품 목록을 조회하지 못했을 때 204 상태코드 반환
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			return;
		}
		
		
		
		List<ProductInfo> productInfoList = filterDao.selectColor(pageNumber, prodColor);
		
		if(prodColor != null) {
			request.setAttribute("amount", amountProdColor);
			request.setAttribute("productList", productInfoList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/product/product_list.jsp");
			rd.forward(request, response);
		}
		
	}
}
