package Purchase;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cancel_refund")
public class Cancel extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String imp_uid = request.getParameter("imp_uid");
		String reason = request.getParameter("reason");
		
		String access_token = null;
		// 액세스 토큰(access token) 발급 받기
		// 1. 액세스 토큰 발급 기능 요청
		//  - url : https://api.iamport.kr/users/getToken
		//  - method : POST
		//  - header : "Content-Type": "application/json"
		//  - data : imp_key=iamportApiKey&imp_secret=iamportSecret
		// 2. access_token 변수에 액세스 토큰 저장
		
		
		
		String apiKey = "5281340698219713";
		String secretKey = "b8b15790c56d63aa02f7cd17605f81c9eb46325c039a1f6cb44e188a3ab1a11f5ca19b12e1c4815e";
		
		
		
		
	}

}
