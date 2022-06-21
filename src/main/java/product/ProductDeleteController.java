package product;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductInfoDao;
import vo.ProductInfo;

@WebServlet("/product/delete")
public class ProductDeleteController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 삭제할 상품 번호를 가져온다
		ProductInfo productInfo = (ProductInfo) request.getAttribute("productList");
		int prodIdx = productInfo.getProdIdx();
		
		// 이미지 파일 경로도 삭제해준다
		if(productInfo.getProdImg() == null) {
			String img = productInfo.getProdImg();
			String path = request.getRealPath("images/product");
			
			File file = new File(path, "/" + img);
			file.delete();
		}
		
		ProductInfoDao dao = new ProductInfoDao();
		dao.deleteProductInfo(prodIdx);
		
		// 상품 삭제에 성공했다면 200 상태코드 반환
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
