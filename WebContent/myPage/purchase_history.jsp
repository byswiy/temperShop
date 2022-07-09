<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
${purchaseInfo }
${purchaseListInfo }
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
              <a href="/temperShop/myPage/cart.jsp" class="nav-link link-dark">
                <i class="bi bi-person-lines-fill"></i>&nbsp;
                장바구니
              </a>
            </li>
            <li>
              <a href="/temperShop/myPage/purchase_history.jsp" class="nav-link link-dark">
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

        <table class="table">
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
          	<c:forEach var="purchase" items="${purchaseListInfo }">
	          	<tr>
	              <th scope="row">${purchase.purchaseImg }</th>
	              <td>${purchase.purchaseName }</td>
	              <td>${purchase.purchasePrice }</td>
	              <td>${purchase.purchaseQuantity }</td>
	              <td>${purchaseInfo.cost }</td>
	              <th scope="row">
	                <button type="button" class="btn btn-danger" style="width: 65px;">삭제</button>
	              </th>
	            </tr>
          	</c:forEach>
          </tbody>
        </table>
      </div>

      <nav aria-label="Page navigation example" style="margin-left: 20%;">
        <ul class="pagination justify-content-center">
          <li class="page-item disabled">
            <a class="page-link">Previous</a>
          </li>
          <li class="page-item"><a class="page-link" href="#">1</a></li>
          <li class="page-item"><a class="page-link" href="#">2</a></li>
          <li class="page-item"><a class="page-link" href="#">3</a></li>
          <li class="page-item"><a class="page-link" href="#">4</a></li>
          <li class="page-item"><a class="page-link" href="#">5</a></li>
          <li class="page-item">
            <a class="page-link" href="#">Next</a>
          </li>
        </ul>
      </nav>

      <hr>

      <footer class="blog-footer">
        <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
        <p>
          <a href="#">Back to top</a>
        </p>
      </footer>
      
    </body>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script>
    	$.ajax({
    		url: "/temperShop/purchase/history",
    		type: "get",
    		data: "member_userIdx="+${purchaseInfo.member_userIdx},
    		success: function() {
    			location.href="/temperShop/myPage/purchase_history.jsp?member_userIdx="+${purchaseInfo.member_userIdx};
    		},
    		error: function() {
    			
    		}
    		
    	})
    </script>
</html>