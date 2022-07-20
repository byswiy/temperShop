<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
${review.purchase_idx }
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/purchase_history.css">
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
    </main>
      <hr>
      <div class="container d-flex">
        <div class="d-flex flex-column flex-shrink-0 p-3 bg-light" id="side_bar" style="width: 350px;">
          <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none">
            <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
            <span class="fs-4">마이페이지</span>
          </a>
          <hr>
          <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
              <a href="/temperShop/product/list?pageNumber=1" class="nav-link link-dark" aria-current="page">
                <i class="bi bi-shop"></i>&nbsp;
                home
              </a>
            </li>
            <li>
              <a href="/temperShop/cart/list?userIdx=${loginUserInfo.userIdx }" class="nav-link link-dark">
                <i class="bi bi-person-lines-fill"></i>&nbsp;
                장바구니
              </a>
            </li>
            <li>
              <a href="/temperShop/purchase/history?userIdx=${loginUserInfo.userIdx }" class="nav-link link-dark">
                <i class="bi bi-bag-check"></i>&nbsp;
                구매 내역
              </a>
            </li>
            <li>
              <a href="/temperShop/myPage/member_update.jsp" class="nav-link link-dark">
                <i class="bi bi-person-lines-fill"></i>&nbsp;
                회원 정보 수정
              </a>
            </li>
            <li>
              <a href="/temperShop/myPage/password_update.jsp" class="nav-link link-dark">
                <i class="bi bi-person-lines-fill"></i>&nbsp;
                비밀번호 수정
              </a>
            </li>
            <li>
              <a href="/temperShop/myPage/member_delete.jsp" class="nav-link link-dark">
                <i class="bi bi-person-x"></i>&nbsp;
                회원 탈퇴
              </a>
            </li>
          </ul>
        </div>
		
		<main>
			<div class="main_history">구매 내역</div>
			
			<hr>
			
			<table class="table" style="width: 100%;">
			  <thead>
			    <tr>
                <th scope="col">상품 이미지</th>
                <th scope="col">상품 명</th>
                <th scope="col">상품 가격</th>
                <th scope="col">구매 수량</th>
                <th scope="col">구매 가격</th>
                </tr>
			  </thead>
			  <tbody>
			  	<c:if test="${purchaseList ne null }">
	          	<c:forEach var="purchase" items="${purchaseList }">
		          	<tr>
		              <th scope="row"><img src="http://localhost/temperShop/images/product/${purchase.purchaseImg }" style="width: 145px;"></th>
		              <td> 
		              	<span style="vertical-align: middle;">${purchase.purchaseName }</span><br><br>
		              	<c:if test="${purchase.message ne null}">
			              	<span>배송 메세지</span><br>
			              	<span>:${purchase.message }</span>
		              	</c:if>
		              	
		              </td>
		              <td>${purchase.purchasePrice }</td>
		              <td>${purchase.purchaseQuantity }</td>
		              <td>${purchase.purchaseCost }</td>
		              <th style="text-align: end; vertical-align: middle;">
			              	<a href="/temperShop/review/info?purchaseIdx=${purchase.purchaseIdx }"><button type="submit" style="width: 86px; background-color: white;" id="add_btn">후기 작성</button></a>
					          <form action="/temperShop/purchase/cancel?purchaseIdx=${purchase.purchaseIdx }&userIdx=${purchase.userIdx}" method="post">
					              <button type="submit" style="width: 86px; background-color: white;" id="cancel_btn">구매 취소</button>
					           </form>
		              </th>
		            </tr>
	          	</c:forEach>
          	</c:if>
          	<c:if test="${purchaseList eq '[]' }">
          		<tr>
          		  <th scope="row">구매 내역이 없습니다</th>
	            </tr>
          	</c:if>
			  </tbody>
			  </table>
		</main>
      </div>

      <hr>

      <footer class="blog-footer">
        <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
        <p>
          <a href="#">Back to top</a>
        </p>
      </footer>
      
      <script src="../js/jquery-3.6.0.min.js"></script>
      <script>
    </script>
    </body>
</html>