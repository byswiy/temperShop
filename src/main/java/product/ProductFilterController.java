package product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ProductInfo;

@WebServlet("/product/filter")
public class ProductFilterController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodType = request.getParameter("prodType");
		String prodCategory = request.getParameter("prodCategory");
		
		ProductInfo productInfo = new ProductInfo();
		
		Filter filter = new Filter();
		productInfo = filter.typeFilter(prodType);
		
		productInfo = filter.categoryFilter(prodType, prodCategory);
		
		
	}

}
