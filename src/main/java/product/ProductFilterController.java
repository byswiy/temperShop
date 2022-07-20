package product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FilterDao;
import dao.ProductInfoDao;
import vo.ProductInfo;

// 상품 구분 -> 상품 종류 -> 상품 사이즈에 따른 필터
@WebServlet("/product/filter")
public class ProductFilterController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int pageNumber = 1;
		
		if(request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		
		String prodType = request.getParameter("prodType");
		String prodCategory = request.getParameter("prodCategory");
		String prodSize = request.getParameter("prodSize");
		
		// 페이지의 갯수를 가져올 Dao
		FilterDao filterDao = new FilterDao();
		
		// 페이지 조회에 실패했을 경우
		int startIndex = (pageNumber - 1) * 12;
		
		if(prodSize != null) {
			int amountProdSize = filterDao.getProdSizeyAmount(prodType,prodCategory, prodSize);
			
			if(startIndex >= amountProdSize) {
				// 없는 페이지 번호로 접근해서 상품 목록을 조회하지 못했을 때 204 상태코드 반환
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
				return;
			}
			request.setAttribute("amount", amountProdSize);
			
		} else if(prodCategory != null) {
			int amountProdCategory = filterDao.getProdCategoryAmount(prodType,prodCategory);
			
			if(startIndex >= amountProdCategory) {
				// 없는 페이지 번호로 접근해서 상품 목록을 조회하지 못했을 때 204 상태코드 반환
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
				return;
			}
			request.setAttribute("amount", amountProdCategory);
			
		} else {
			int amountProdType = filterDao.getProdTypeAmount(prodType);
			
			if(startIndex >= amountProdType) {
				// 없는 페이지 번호로 접근해서 상품 목록을 조회하지 못했을 때 204 상태코드 반환
				response.setStatus(HttpServletResponse.SC_NO_CONTENT);
//				return;
			}
			request.setAttribute("amount", amountProdType);
		}
		
		filterDao = new FilterDao();
		List<ProductInfo> productInfoList = filterDao.selectAll(pageNumber, prodType, prodCategory, prodSize);
		
		if(prodSize != null) {
			request.setAttribute("productList", productInfoList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/product/product_list.jsp");
			rd.forward(request, response);
		} else if(prodCategory != null) {
			request.setAttribute("productList", productInfoList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/product/product_list.jsp");
			rd.forward(request, response);
		} else if(prodType != null) {
			request.setAttribute("productList", productInfoList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/product/product_list.jsp");
			rd.forward(request, response);
		} 
		
	}
}
