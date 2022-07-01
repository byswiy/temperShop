package product;

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

@WebServlet("/product/add")
public class ProductAddController extends HttpServlet {
	private static final int MAXIUM_FILE_SIZE = 5 * 1024 * 1024;  // 5MB
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 첨부파일(이미지)를 꺼내온다
			String path = request.getRealPath("images/product");
			MultipartRequest mr= new MultipartRequest(request, path, MAXIUM_FILE_SIZE, "UTF-8", new DefaultFileRenamePolicy());
			
			// 상품 정보를 꺼내온다
			String prodShopName = mr.getParameter("prodShopName");
			String prodName = mr.getParameter("prodName");
			
			if(mr.getParameter("prodPrice") == null || mr.getParameter("prodStock") == null) {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				return;
			}
			
			int prodStock = Integer.parseInt(mr.getParameter("prodStock"));
			int prodPrice = Integer.parseInt(mr.getParameter("prodPrice"));
			String prodSize = mr.getParameter("prodSize");
			String prodColor = mr.getParameter("prodColor");
			String prodCategory = mr.getParameter("prodCategory");
			String prodType = mr.getParameter("prodType");
			String prodImg = mr.getFilesystemName("prodImg");
			LocalDateTime regDate = LocalDateTime.now();
			
			// 1-1 전달 받은 값 검증
			ProductValidator validator = new ProductValidator();
			if(!validator.allValidator(prodName, prodPrice, prodStock, prodSize, prodColor, prodCategory)) {
				throw new BadParameterException();
			}

			// 2. 전달받은 값을 하나의 상품정보로 합친다
			ProductInfo productInfo = new ProductInfo(prodShopName, prodName, prodPrice, prodStock, prodSize, prodColor, prodCategory, prodType, prodImg, regDate);		
			
			// 3. DB에 새로운 상품을 저장한다
			ProductInfoDao dao = new ProductInfoDao();
			dao.insertProduct(productInfo);
			
			response.setStatus(HttpServletResponse.SC_OK);
			// 상품 추가에 성공했다면 상품 목록 첫 페이지로 이동하도록 한다
//			response.sendRedirect("##");
		} catch(BadParameterException e) {
			// 상품을 추가하지 못했다면 400 상태코드를 반환한다
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
