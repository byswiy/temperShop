package review;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductInfoDao;
import exception.BadParameterException;
import util.ProductValidator;
import vo.ProductInfo;

@WebServlet("/review/add")
public class ReviewAddController extends HttpServlet {
	private static final int MAXIUM_FILE_SIZE = 5 * 1024 * 1024;  // 5MB
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 1. 전달 받은 값을 꺼낸다 (시작)
			// 첨부파일을 꺼내서 저장
			String path = request.getRealPath("images/product");
			MultipartRequest mr= new MultipartRequest(request, path, MAXIUM_FILE_SIZE, "UTF-8", new DefaultFileRenamePolicy());
			
			String prodName = mr.getParameter("prodName");
			
			if(mr.getParameter("prodPrice") == null || mr.getParameter("prodStock") == null) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
			
			int prodPrice = Integer.parseInt(mr.getParameter("prodPrice"));
			int prodStock = Integer.parseInt(mr.getParameter("prodStock"));
			String prodSize = mr.getParameter("prodColor");
			String prodColor = mr.getParameter("prodColor");
			String prodCategory = mr.getParameter("prodCategory");
			String prodImg = mr.getFilesystemName("prodImg");
			LocalDateTime regDate = LocalDateTime.now();
			
			// 1-1 전달 받은 값 검증
			ProductValidator validator = new ProductValidator();
				
			// 2. 전달받은 값을 하나의 상품정보로 합친다
			ProductInfo productInfo = new ProductInfo();		
			productInfo.setProdName(prodName);
			productInfo.setProdPrice(prodPrice);
			productInfo.setProdStock(prodStock);
			productInfo.setProdSize(prodSize);
			productInfo.setProdColor(prodColor);
			productInfo.setCategory(prodCategory);
			productInfo.setProdImg(prodImg);
			productInfo.setRegDate(regDate);
			
			// 3. DB에 새로운 상품을 저장한다
			ProductInfoDao dao = new ProductInfoDao();
			dao.insertProduct(productInfo);
			
			// 상품 수정에 성공했다면 상품 목록의 첫 페이지로 이동하도록 한다
			response.sendRedirect("##");
		} catch(BadParameterException e) {
			// 상품 추가에 실패했을 경우 400 상태코드 반환
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
