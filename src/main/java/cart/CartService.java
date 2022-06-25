package cart;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.CartInfoDao;
import vo.CartInfo;
import vo.CartListInfo;
import vo.ProductInfo;
import vo.ReviewInfo;

public class CartService {
	
	public String loadCartInfo(HttpServletRequest request) {
		CartListInfo cartInfoList = (CartListInfo) request.getAttribute("cartListInfo");
		
		List<CartListInfo> cartList = new ArrayList<>();
		cartList.add(cartInfoList);
		
		CartInfoDao dao = new CartInfoDao();
		int amount = dao.getAmountCart();
		
		String data = "{\"amount\": " + amount + ",";
		data += "\"cartList\":[";
		for(CartListInfo cart : cartList) {
			int member_userIdx = cart.getMember_userIdx();
			String prodName = cart.getProdName();
			int prodPirce = cart.getProdPrice();
			int prodQuantiy = cart.getProdQuantity();
			String prodSize = cart.getProdSize();
			String prodColor = cart.getProdColor();
			String prodImg = cart.getProdImg();
			
			data = data + "{\"member_userIdx\": " + member_userIdx + ",\"prodName\":\"" + prodName + "\",\"prodPirce\": " + prodPirce + ",\"prodQuantiy\": " + prodQuantiy +
					      ",\"prodSize\":\"" + prodSize + "\",\"prodColor\":\"" + prodColor + "\",\"prodImg\":\"" + prodImg + "\"},";
			
		}
		
		data = data.substring(0, data.length()-1);
		data = data + "]}";
		
		return data;
				
	}
}
