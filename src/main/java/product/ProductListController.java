package product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductInfoDao;
import vo.ProductInfo;

@WebServlet("/product/list")
public class ProductListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지 번호를 꺼내올 때 null이 아니라면 pageNumber를 꺼내오도록 한다
		int pageNumber = 1;
		
		if(request.getParameter("pageNumber") != null) {
			pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
		}
		
		// 페이지의 갯수를 가져올 Dao
		ProductInfoDao dao = new ProductInfoDao();
		int amountPage = dao.getCount();
		
		// 페이지 조회에 실패했을 경우
		int startIndex = (pageNumber - 1) * 9;
		if(startIndex >= amountPage) {
			// 없는 페이지 번호로 접근해서 상품 목록을 조회하지 못했을 때 204 상태코드 반환
			response.setStatus(HttpServletResponse.SC_NO_CONTENT);
			return;
		}
		
		// 상품의 데이터를 List로 묶어주고 상품의 목록을 불러온다
		List<ProductInfo> productInfoList = dao.selectAll(pageNumber);
		
		// 요청 정보안에 상품 정보 저장
		request.setAttribute("productList", productInfoList);
		
		// 상품 목록을 보여주는 jsp로 이동하도록 한다
		RequestDispatcher rd = request.getRequestDispatcher("##");
		rd.forward(request, response);
		
	}

}
