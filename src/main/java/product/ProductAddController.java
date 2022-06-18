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
			String prodName = mr.getParameter("prodName");
			int prodStock = Integer.parseInt(mr.getParameter("prodStock"));
			int prodPrice = Integer.parseInt(mr.getParameter("prodPrice"));
			String prodSize = mr.getParameter("prodSize");
			String prodColor = mr.getParameter("prodColor");
			String prodImg = mr.getFilesystemName("prodImg");
			LocalDateTime regDate = LocalDateTime.now();
			String prodCategory = mr.getParameter("prodCategory");
			
			// 1-1 전달 받은 값 검증
			ProductValidator validator = new ProductValidator();

			// 2. 전달받은 값을 하나의 상품정보로 합친다
			ProductInfo productInfo = new ProductInfo(prodName, prodPrice, prodStock, prodSize, prodColor, prodImg, regDate, prodCategory);		
			
			// 3. DB에 새로운 상품을 저장한다
			ProductInfoDao dao = new ProductInfoDao();
			dao.insertProduct(productInfo);
			
		} catch(BadParameterException e) {
			//
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
	}

}
