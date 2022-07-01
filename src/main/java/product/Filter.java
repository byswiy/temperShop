package product;

import dao.ProductInfoDao;
import vo.ProductInfo;

public class Filter {
	// 옷과 악세사리를 나누는 type 필터
	public void typeFilter() {
		ProductInfo productInfo = new ProductInfo();
		ProductInfoDao dao = new ProductInfoDao();
		
		productInfo = dao.selectTypeFilter(productInfo);
	
	}
}
