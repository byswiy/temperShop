<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	int amount = (int) request.getAttribute("amount");
	int end = (int) Math.ceil(amount / 12.0);

	request.setAttribute("end", end);
	
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" >
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/review_list.css">
    <title>Document</title>
    <style>
    li button {
		border: none;
		background-color: white;
	}
    </style>
</head>
<body>
    
    <%@ include file="../includes/header_nav.jsp" %>
    
    <main class="container">
      
      <%@ include file="../includes/header.jsp" %>

      <hr>
      	<form action="">
	      	<input type="text" placeholder="아이디로 검색하기" id="userId" name="id">
	      	<input type="submit" value="검색" id='id_btn' style="display: inline-block;">
	      	<a href="/temperShop/review/list?reviewPage=1"><input type="button" value="후기 전체보기"></a>
      	</form>
      	
      	
      <table class="table">
        <thead>
          <tr>
            <th scope="col" style="width: 55px;">리뷰 상품 이미지</th>
            <th scope="col">상품 명</th>
            <th scope="col">후기 내용</th>
            <th scope="col">작성자</th>
            <th scope="col">후기 등록일</th>
          </tr>
        </thead>
        <tbody>
          <c:if test="${reviewList eq null}">
          	<tr>
            	<td>가나다</td>
          	</tr>
          </c:if>
          <c:forEach var="review" items="${reviewList }">
		  <tr>
            <th scope="row"><img src="http://localhost/temperShop/images/product/${review.purchaseImg }" style="width: 145px;"></th>
            <td style="width: 227px; vertical-align: middle;">
            	<span>${review.purchaseShopName }</span><br>
            	<span>${review.purchaseName }</span>
            </td>
            <td style="width: 384px; vertical-align: middle;">${review.contents }</td>
            <td style="vertical-align: middle;">${review.member_id }</td>
            <td style="vertical-align: middle;">${review.insertDate }</td>
            <th scope="row" style="vertical-align: middle;">
            	<c:if test="${loginUserInfo.id eq review.member_id }">
            	<form action="/temperShop/review/review_update.jsp?reviewIdx=${review.reviewIdx }&contents=${review.contents}" method="post" style="display: inline-block">
              		<button type="submit" class="btn btn-secondary" style="width: 65px;" id="cancel_btn">수정</button>
              	</form>
              	<form action="/temperShop/review/delete?reviewIdx=${review.reviewIdx }&member_id=${review.member_id}" method="post" style="display: inline-block">
              		<button type="submit" class="btn btn-secondary" style="width: 65px;" id="cancel_btn">삭제</button>
              	</form>
            	</c:if>
            	<c:if test="${loginUserInfo.id eq 'admin00' }">
            		<form action="/temperShop/review/delete?reviewIdx=${review.reviewIdx }&member_id=${review.member_id}" method="post" style="display: inline-block">
              		<button type="submit" class="btn btn-secondary" style="width: 65px;" id="cancel_btn">삭제</button>
              	</form>
            	</c:if>
             </th>
          </tr>
	  `</c:forEach>
	  <c:if test="${reviewList eq null}">
		<td>
            <span>등록된 후기가 없습니다</span>
         </td>
	  </c:if>
        </tbody>
      </table>

      <hr>
      
      <nav aria-label="Page navigation example">
	  	<ul class="pagination justify-content-center">
	  		<c:forEach begin="1" end="${end }" var="number">
				<li class="page-item"><a class="page-link" href="http://localhost/temperShop/review/list?reviewPage=${number }">${number }</a></li>
			</c:forEach>
		</ul>
	  </nav>

       
    </main>
    
    <footer class="blog-footer">
      <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a></p>
      <p>
        <a href="#">Back to top</a>
      </p>
    </footer>
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script>
	    
// 		console.log(id);
    
    	$("#id_btn").on("click", function(event) {
    		event.preventDefault;
    		
    		let id = $("#userId").val();
    		
			$.ajax({
				url: "/temperShop/review/filter",
				type: "get",
				data: "id="+id,
				success: function() {
					location.href="/temperShop/review/filter?id="+id
				},
				error: function() {
					
				},
			});   		
    	});
    </script>
    </body>
</html>