<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/product_update.css">
    <title>Document</title>
</head>
<body>
    
    <%@ include file="../includes/header_nav.jsp" %>
    
    <main class="container">
      
      <div class="mb-4 img-wrap">
        <div class="image_wrap">
          <img src="https://search.pstatic.net/sunny/?src=https%3A%2F%2Fmedia.gettyimages.com%2Fvectors%2Fsummer-holiday-vector-id1132163504%3Fk%3D20%26m%3D1132163504%26s%3D612x612%26w%3D0%26h%3Dajh-kLrrYNtYyNIXN50uviXgzRYIWIOPrRTZHkurkc4%3D&type=a340" alt="">
        </div>
      </div>

      <h3 class="filter fst-italic">상품 수정</h3>

      <hr>

      <form action="" method="POST" enctype="multipart/form-data">

        <input type="hidden" name="productId" value="">
        <div class="input-group input-group-lg mb-3" id="product_name_wrapper">
            <span class="input-group-text" id="inputGroup-sizing-lg">상품명</span>
            <input type="text" class="form-control" id="prodName" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" 
                   name="prodName" value="${prodDetail.prodName }">
        </div>

        <div class="input-group input-group-lg mb-3" id="product_shopName_wrapper">
          <span class="input-group-text" id="inputGroup-sizing-lg">쇼핑몰</span>
          <input type="text" class="form-control" id="prodShopName" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" 
                 name="prodShopName" value="${prodDetail.prodShopName }" disabled>
        </div>
        
        <div class="input-group mb-3" id="product_stock_wrapper">
            <span class="input-group-text">재고</span>
            <input type="number" class="form-control" id="prodStock" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm"
                   name="prodStock" value="${prodDetail.prodStock }">
        </div>

        <div class="input-group mb-3" id="product_price_wrapper">
            <span class="input-group-text">가격</span>
            <input type="number" class="form-control" id="prodPrice" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" 
                  name="prodPrice" value="${prodDetail.prodPrice }">
        </div>

        <div class="input-group mb-3" id="product_size_wrapper">
          <span class="input-group-text">사이즈</span>
          <input type="text" class="form-control" id="prodSize" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm"
                 name="prodSize" value="${prodDetail.prodSize }">
        </div>

        <div class="input-group mb-3" id="product_type_wrapper">
          <label class="input-group-text" for="inputGroupSelect01">색상</label>
          <select class="form-select" id="prodColor" name="prodColor">
            <option value="red">Red</option>
            <option value="yellow">Yellow</option>
            <option value="green">Green</option>
            <option value="blue">Blue</option>
            <option value="white">White</option>
            <option value="black">Black</option>
          </select>
        </div>

        <div class="input-group mb-3" id="product_type_wrapper">
          <label class="input-group-text" for="inputGroupSelect01">구분</label>
          <select class="form-select" id="prodType" name="prodType">
            <option value="top">Top</option>
            <option value="bottom">Bottom</option>
            <option value="dress">Dress</option>
          </select>
        </div>

        <div class="input-group mb-3" id="product_category_wrapper">
            <label class="input-group-text" for="inputGroupSelect02">카테고리</label>
            <select class="form-select" id="prodCategory" name="prodCategory">
              <option value="민소매">민소매</option>
              <option value="반팔">반팔</option>
              <option value="얇은 셔츠">얇은 셔츠</option>
              <option value="얇은 가디건">얇은 가디건</option>
              <option value="긴팔">긴팔</option>
              <option value="얇은 니트">얇은 니트</option>
            </select>
        </div>

        <div class="input-group mb-3" id="product_img_wrapper">
            <label class="input-group-text" for="inputGroupFile01">상품 이미지</label>
            <input type="file" class="form-control" id="prodImg" name="prodImg" disabled>
        </div>
        
        <div class="justify-content-md-start">
              <input type="submit" class="btn btn-primary" id="update_btn" value="상품 수정">
        </div>
    </form>


    </main>
    
    <footer class="blog-footer">
      <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
      <p>
        <a href="#">Back to top</a>
      </p>
    </footer>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script>

      $("select[name=prodType]").change(function(){
        let selectProdType = $(this).val();

        if(selectProdType == 'dress') {
          $("#prodCategory").html("<select class=\"form-select\" id=\"prodCategory\" name=\"prodCategory\">" +
                                  "<option value=\"원피스\">원피스</option>" +
                                  "<option value=\"스커트\">스커트</option>" +
                                  "</select>"
                                  );
        } else if(selectProdType == 'bottom') {
          $("#prodCategory").html("<select class=\"form-select\" id=\"prodCategory\" name=\"prodCategory\">" +
                                  "<option value=\"반바지\">반바지</option>" +
                                  "<option value=\"면바지\">면바지</option>" +
                                  "<option value=\"청바지\">청바지</option>" +
                                  "</select>"
                                  );
        } else if(selectProdType == 'top') {
          $("#prodCategory").html("<select class=\"form-select\" id=\"prodCategory\" name=\"prodCategory\">" +
                                  "<option value=\"민소매\">민소매</option>" +
                                  "<option value=\"반팔\">반팔</option>" +
                                  "<option value=\"얇은 셔츠\">얇은 셔츠</option>" +
                                  "<option value=\"얇은 가디건\">얇은 가디건</option>" +
                                  "<option value=\"긴팔\">긴팔</option>" +
                                  "<option value=\"얇은 니트\">얇은 니트</option>" +
                                  "</select>"
                                  );
        }
      });
    </script>
    <script>
	// 상품 수정
	$("#update_btn").on("click", function(event) {
		// ajax를 통해서 상품 수정 요청이 들어가도록 한다
		event.preventDefault();
		
		let $prodName = $("#prodName");
		let $prodStock = $("#prodStock");
		let $prodPrice = $("#prodPrice");
		let $prodSize = $("#prodSize");
		let $prodColor = $("#prodColor");
		let $prodType = $("#prodType");
		let $prodCategory = $("#prodCategory");
		
		let prodName = $prodName.val();
		let prodStock = $prodStock.val();
		let prodPrice = $prodPrice.val();
		let prodSize = $prodSize.val();
		let prodColor = $prodColor.val();
		let prodType = $prodType.val();
		let prodCategory = $prodCategory.val();
		
		$.ajax({
			url: "/temperShop/product/update",
			type: "POST",
			data: "prodIdx="+${prodDetail.prodIdx}+"&prodName="+prodName+"&prodStock="+prodStock+"&prodPrice="+prodPrice+"&prodSize="+prodSize+
			     "&prodColor="+prodColor+"&prodType="+prodType+"&prodCategory="+prodCategory,
			success: function() {
				// 상품 정보가 수정되었을 경우
				alert("상품 정보를 수정했습니다");
				location.href="/temperShop/product/detail?prodIdx="+${prodDetail.prodIdx};
			},
			error: function(response) {
				// 상품 정보가 수정되지 못 했을 경우
				alert("상품 정보를 수정하지 못 했습니다");
				console.log(response);
			}
		});
		
	});
    </script>
    </body>
</html>