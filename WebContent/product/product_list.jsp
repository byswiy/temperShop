<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	// 페이지네이션에 사용할 end 속성의 값 계산
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/product_list.css">
    <title>Document</title>
</head>
<body>
    
    <%@ include file="../includes/header_nav.jsp" %>
    
    <main class="container">
      
      <%@ include file="../includes/header.jsp" %>

      <h3 class="filter fst-italic">Filter</h3>

      <a href="">home</a>

      <span>></span>

      <select class="form-select prodType" aria-label="Default select example">
          <option selected>구분</option>
          <option value="top">Top</option>
          <option value="bottom">Bottom</option>
          <option value="dress">Dress</option>
      </select>

      <span>></span>
      
      <select class="form-select prodType" aria-label="Default select example">
        <option selected>종류</option>
        <option value="1">Top</option>
        <option value="2">Bottom</option>
        <option value="3">Dress</option>
    </select>

    <span>></span>

      <select class="form-select prodSize" aria-label="Default select example">
        <option selected>사이즈</option>
        <option value="1">S</option>
        <option value="2">M</option>
        <option value="3">L</option>
      </select>

      <select class="form-select prodColor" aria-label="Default select example">
        <option selected>색상</option>
        <option value="1">Red</option>
        <option value="2">Yellow</option>
        <option value="4">Green</option>
        <option value="5">Blue</option>
        <option value="6">White</option>
        <option value="7">Black</option>
      </select>

      <select class="form-select prodPrice" aria-label="Default select example">
        <option selected>가격</option>
        <option value="1">낮은 순</option>
        <option value="2">높은 순</option>
      </select>

      <hr>
		
	  <!-- 상품 목록 구성 -->	
	  <c:forEach var="products" items="${productList }">
		  <div class="card" style="max-width: 24%;">
	        <a href="##"><img src="http://localhost/temperShop/images/product/${products.prodImg }" class="card-img-top" alt="..." style="height: 310px;"></a>
	        <div class="card-body">
	          <a href=""><h6 class="card-title">${products.prodShopName }</h6></a>
	          <p class="card-text">
	            <span>상품 명 : ${products.prodName }</span><br>
	            <strong><span>상품 가격 : ${products.prodPrice }원</span><br></strong><br>
	            <a href="http://localhost/temperShop/product/detail?prodIdx=${products.prodIdx }"><button type="button" class="btn btn-secondary" id="detail_btn">상세정보</button></a>
	          </p>
	        </div>
	      </div>
	  </c:forEach>
	  
	  <nav aria-label="Page navigation example">
	  	<ul class="pagination justify-content-center">
	  		<c:forEach begin="1" end="${end }" var="number">
				<li class="page-item"><a class="page-link" href="http://localhost/temperShop/product/list?pageNumber=${number }">${number }</a></li>
			</c:forEach>
		</ul>
	  </nav>
      </main>
      <hr>
    
    <footer class="blog-footer">
      <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
      <p>
        <a href="#">Back to top</a>
      </p>
    </footer>
    </body>
    
    <script src="../js/jquery-3.6.0.min.js"></script>
    <script>
    	$("#detail_btn").on("click", function() {
    		location.href="/temperShop/product/product_detail.jsp";
    	});
    </script>
</html>