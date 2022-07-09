<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/product_detail.css">
    <title>Document</title>
</head>
<body>
    
    <%@ include file="../includes/header_nav.jsp" %>
    
    <main class="container">
      
      <%@ include file="../includes/header.jsp" %>

      <hr>

      <div class="container px-4 py-5">
        <div class="row align-items-center g-5">
          <div class="col-10 col-sm-8 col-lg-6">
          	<c:set var="imgFile" value="${productInfo.prodImg }" />
            <img src="http://localhost/temperShop/images/product/${imgFile }" id="prodImg" class="d-block mx-lg-auto img-fluid" alt="Bootstrap Themes" width="450" height="250" loading="lazy">
          </div>
          <div class="col-lg-6">
            <h4 class="fw-bold lh-1 mb-3" id="prodShopName">${productInfo.prodShopName }</h4>
            <h3 class="fw-bold lh-1 mb-3" id="prodName">${productInfo.prodName }</h3>
            <p class="lead" id="prodPrice">가격 : ${productInfo.prodPrice }</p>
            <p class="lead" id="prodSize">사이즈 : ${productInfo.prodSize }</p>
            <p class="lead" id="prodColor">색상 : ${productInfo.prodColor }</p>
            <label for="prodQuantity" >구매 수량 :
              <input type="number" id="prodQuantity" name="prodQuantity" style="margin-bottom: 30px;">
            </label>
            
            <%-- 로그인이 되어있어 있지 않다면 --%>
           	<c:if test="${loginUserInfo eq null }">
           		<br>
           		<a href="/temperShop/login/login.jsp"><button type="button" class="btn btn-primary btn-lg px-4 me-md-2">구매 하기</button></a>
           		<a href="/temperShop/login/login.jsp"><button type="button" class="btn btn-primary btn-lg px-4 me-md-2">장바구니</button></a>
           	</c:if>
           	
           	<%-- 로그인이 되어있다면 --%>
			<c:if test="${loginUserInfo ne null }">
				<br>
				<button type="button" class="btn btn-primary btn-lg px-4 " id="buy_btn">구매 하기</button>
				<button type="button" class="btn btn-primary btn-lg px-4 " id="cart_btn">장바구니</button>
				<c:if test="${loginUserInfo.id eq 'admin00'}">
					<button type="button" class="btn btn-secondary btn-lg px-4 me-md-2" id="update_btn">상품 수정</button>
           			<button type="button" class="btn btn-danger btn-lg px-4 me-md-2" id="delete_btn">상품 삭제</button>
				</c:if>
			</c:if>
          </div>
        </div>
      </div>
      <hr>
    </main>
    
    <footer class="blog-footer">
      <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
      <p>
        <a href="#">Back to top</a>
      </p>
    </footer>
    </body>

    <script src="../js/jquery-3.6.0.min.js"></script>
    <script>
    	// 상품 구매 페이지로 이동
    	$("#buy_btn").on("click", function() {
    		let prodQuantity = $("#prodQuantity").val();
    		
    		$.ajax({
    			url: "/temperShop/purchase",
    			type: "POST",
    			data: "prodIdx="+${productInfo.prodIdx}+"&prodQuantity="+prodQuantity,
    			success: function() {
    				location.href= "/temperShop/purchase/purchase_form.jsp";
    			},
    			error: function() {
    				
    			}
    		});
    		
    	});
    </script>
    <script>
    	let prodIdx = ${param.prodIdx};
    
    	// 상품 삭제 페이지로 이동
    	$("#delete_btn").on("click", function() {
    		
    		$.ajax({
    			url: "/temperShop/product/delete",
    			type: "POST",
    			data: "prodIdx=" + prodIdx,
    			success: function() {
    				alert("상품을 삭제했습니다.");
    				
    				location.href = "/temperShop/product/list";
    			},
    			error: function() {
    				
    			}
    		});
    	});
    	
    	// 상품 수정 페이지로 이동
    	$("#update_btn").on("click", function() {
    		location.href = "/temperShop/product/product_update.jsp?prodIdx=" + prodIdx;
    	});
    </script>
</html>