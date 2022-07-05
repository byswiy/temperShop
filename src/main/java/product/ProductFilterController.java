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

		
		FilterService filter = new FilterService();
		
		ProductInfo productInfo = new ProductInfo();
		productInfo = filter.typeFilter(prodType);
		
		String selectProdType = productInfo.getProdType();
		
		productInfo = filter.categoryFilter(selectProdType, prodCategory);
		
		String selectProdCategory = productInfo.getCategory();
		
		productInfo = filter.sizeFilter(selectProdType, selectProdCategory, prodSize);
		
	}
}
