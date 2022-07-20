<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/product_list.css">
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

      <h3 class="filter fst-italic">Filter</h3>

      <a href="/temperShop/product/list?pageNumber=1">home</a>

      <span>></span>

       <select class="form-select" id="prodType" name="prodType">
         <option>구분</option>
         <option value="top">Top</option>
         <option value="bottom">Bottom</option>
         <option value="dress">Dress</option>
       </select>

      <span>></span>
      
      <select class="form-select" id="prodCategory" name="prodCategory" disabled>
      	<option>종류</option>
        <option value="민소매">민소매</option>
        <option value="반팔">반팔</option>
        <option value="얇은 셔츠">얇은 셔츠</option>
        <option value="얇은 가디건">얇은 가디건</option>
        <option value="얇은 니트">얇은 니트</option>
      </select>
      
    <span>></span>
<!-- style="visibility: hidden;" -->
      <select class="form-select" id="prodSize" name="prodSize" disabled>
        <option>사이즈</option>
        <option value="s">S</option>
        <option value="m">M</option>
        <option value="l">L</option>
      </select>

      <select class="form-select" id="prodColor" name="prodColor" style="margin-left: 480px;">
        <option >색상</option>
        <option value="red">Red</option>
        <option value="yellow">Yellow</option>
        <option value="green">Green</option>
        <option value="blue">Blue</option>
        <option value="white">White</option>
        <option value="black">Black</option>
      </select>

      <select class="form-select" id="prodPrice" name="prodPrice">
        <option >가격</option>
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
	            <a href="http://localhost/temperShop/product/detail?prodIdx=${products.prodIdx }&pageNumber=${param.pageNumber}"><button type="button" class="btn btn-secondary" id="detail_btn">상세정보</button></a>
	          </p>
	        </div>
	      </div>
	  </c:forEach>
	  
	  <nav aria-label="Page navigation example">
	  	<ul class="pagination justify-content-center">
<%-- 	  		<c:if test="${param.prodType ne null }"> --%>
<%-- 				<c:forEach begin="1" end="${end }" var="number"> --%>
<%-- 					<li class="page-item"><a class="page-link" href="http://localhost/temperShop/product/filter?prodType=${param.prodType }&pageNumber=${number }">${number }</a></li> --%>
<%-- 				</c:forEach>		 --%>
<%-- 			</c:if> --%>
<%-- 			<c:if test="${param.prodType ne null }"> --%>
<%-- 				<c:forEach begin="1" end="${end }" var="number"> --%>
<%-- 					<li class="page-item"><a class="page-link" href="http://localhost/temperShop/product/filter?prodType=${param.prodType }&pageNumber=${number }">${number }</a></li> --%>
<%-- 				</c:forEach>		 --%>
<%-- 			</c:if> --%>
<%-- 			<c:if test="${param.prodType ne null }"> --%>
<%-- 				<c:forEach begin="1" end="${end }" var="number"> --%>
<%-- 					<li class="page-item"><a class="page-link" href="http://localhost/temperShop/product/filter?prodType=${param.prodType }&pageNumber=${number }">${number }</a></li> --%>
<%-- 				</c:forEach>		 --%>
<%-- 			</c:if> --%>
				
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
    	let end = ${end};
    	
    	$("#detail_btn").on("click", function() {
    		location.href="/temperShop/product/product_detail.jsp";
    	});
    </script>
    <script>
    if(${param.prodType eq '구분'}) {
    	$("#prodType").val("구분").prop("selected", true);
    	location.href="/temperShop/product/list?pageNumber=1";
    } else  if(${param.prodType eq 'top'}) {
    	$("#prodType").val("top").prop("selected", true);
    	$('#prodCategory').removeAttr("disabled");
    	$("#prodCategory").html("<select class=\"form-select\" id=\"prodCategory\" name=\"prodCategory\">" +
    			"<option>종류</option>" +
                "<option value=\"민소매\">민소매</option>" +
                "<option value=\"반팔\">반팔</option>" +
                "<option value=\"얇은 셔츠\">얇은 셔츠</option>" +
                "<option value=\"얇은 가디건\">얇은 가디건</option>" +
                "<option value=\"얇은 니트\">얇은 니트</option>" +
                "</select>"
                );
    } else  if(${param.prodType eq 'bottom'}) {
    	$("#prodType").val("bottom").prop("selected", true);
    	$('#prodCategory').removeAttr("disabled");
    	$("#prodCategory").html("<select class=\"form-select\" id=\"prodCategory\" name=\"prodCategory\">" +
    			"<option>종류</option>" +
                "<option value=\"반바지\">반바지</option>" +
                "<option value=\"면바지\">면바지</option>" +
                "<option value=\"청바지\">청바지</option>" +
                "</select>"
                );
    } else  if(${param.prodType eq 'dress'}) {
    	$("#prodType").val("dress").prop("selected", true);
    	$('#prodCategory').removeAttr("disabled");
    	$("#prodCategory").html("<select class=\"form-select\" id=\"prodCategory\" name=\"prodCategory\">" +
    			"<option>종류</option>" +
                "<option value=\"원피스\">원피스</option>" +
                "<option value=\"스커트\">스커트</option>" +
                "</select>"
                );
    }
    
    // 상품의 구분에 따른 필터 
    $("select[name=prodType]").change(function(){
    	let selectProdType = $(this).val();
    	
        $.ajax({
        	url: "/temperShop/product/filter",
        	type: "get",
        	data: "prodType="+selectProdType,
        	success: function() {
        		location.href="/temperShop/product/filter?prodType="+selectProdType;
        	},
        	error: function(response) {
        		if(response.status == 204) {
  					alert("구매 수량은 1개 이상으로 입력해주세요");
				}
        		console.log(response);
        	}
        });
        
    });
    
    // 상품 종류에 따른 필터
    $("select[name=prodCategory]").change(function(){
        let selectProdCategory = $(this).val();
        console.log(selectProdCategory);
        
        $.ajax({
        	url: "/temperShop/product/filter",
        	type: "get",
        	data: "prodType=${param.prodType}&prodCategory="+selectProdCategory,
        	success: function() {
        		location.href="/temperShop/product/filter?prodType=${param.prodType}&prodCategory="+selectProdCategory;
        	},
        	error: function() {
        		
        	}
        });
 	});
    
    if(${param.prodType eq 'top'}) {
    	if(${param.prodCategory eq '민소매'}) {
    		$('#prodSize').removeAttr("disabled");
    		$("#prodCategory").val("민소매").prop("selected", true);
        } else  if(${param.prodCategory eq '반팔'}) {
        	$('#prodSize').removeAttr("disabled");
        	$("#prodCategory").val("반팔").prop("selected", true);
        } else  if(${param.prodCategory eq '얇은 셔츠'}) {
        	$('#prodSize').removeAttr("disabled");
        	$("#prodCategory").val("얇은 셔츠").prop("selected", true);
        } else  if(${param.prodCategory eq '얇은 가디건'}) {
        	$('#prodSize').removeAttr("disabled");
        	$("#prodCategory").val("얇은 가디건").prop("selected", true);
        } else  if(${param.prodCategory eq '얇은 니트'}) {
        	$('#prodSize').removeAttr("disabled");
        	$("#prodCategory").val("얇은 니트").prop("selected", true);
        }
    } else if(${param.prodType eq 'bottom'}) {
    	if(${param.prodCategory eq '반바지'}) {
    		$('#prodSize').removeAttr("disabled");
        	$("#prodCategory").val("반바지").prop("selected", true);
        } else  if(${param.prodCategory eq '면바지'}) {
        	$('#prodSize').removeAttr("disabled");
        	$("#prodCategory").val("면바지").prop("selected", true);
        } else  if(${param.prodCategory eq '청바지'}) {
        	$('#prodSize').removeAttr("disabled");
        	$("#prodCategory").val("청바지").prop("selected", true);
        }
    } else if(${param.prodType eq 'dress'}) {
    	if(${param.prodCategory eq '원피스'}) {
    		$('#prodSize').removeAttr("disabled");
        	$("#prodCategory").val("원피스").prop("selected", true);
        } else  if(${param.prodCategory eq '스커트'}) {
        	$('#prodSize').removeAttr("disabled");
        	$("#prodCategory").val("스커트").prop("selected", true);
        }
    }
     
    
    // 상품 사이즈에 따른 필터
    $("select[name=prodSize]").change(function(){
        let selectProdSize = $(this).val();
        
        $.ajax({
        	url: "/temperShop/product/filter",
        	type: "get",
        	data: "prodType=${param.prodType}&prodCategory=${param.prodCategory}&prodSize"+selectProdSize,
        	success: function() {
        		location.href="/temperShop/product/filter?prodType=${param.prodType}&prodCategory=${param.prodCategory}&prodSize="+selectProdSize;
        	},
        	error: function() {
        		
        	}
        });
    });
    
    if(${param.prodSize eq 's'}) {
		$("#prodSize").val("s").prop("selected", true);
    } else  if(${param.prodSize eq 'm'}) {
    	$("#prodSize").val("m").prop("selected", true);
    } else  if(${param.prodSize eq 'l'}) {
    	$("#prodSize").val("l").prop("selected", true);
    }

    
    // 상품 색상에 따른 필터
    $("select[name=prodColor]").change(function(){
    	let selectProdColor = $(this).val();
        
        location.href="/temperShop/product/filter2?prodColor="+selectProdColor;
    });
    
    if(${param.prodColor eq 'red'}) {
		$("#prodColor").val("red").prop("selected", true);
    } else  if(${param.prodColor eq 'yellow'}) {
    	$("#prodColor").val("yellow").prop("selected", true);
    } else  if(${param.prodColor eq 'green'}) {
    	$("#prodColor").val("green").prop("selected", true);
    } else  if(${param.prodColor eq 'blue'}) {
    	$("#prodColor").val("blue").prop("selected", true);
    } else  if(${param.prodColor eq 'white'}) {
    	$("#prodColor").val("white").prop("selected", true);
    } else  if(${param.prodColor eq 'black'}) {
    	$("#prodColor").val("black").prop("selected", true);
    }
    
    // 상품 가격에 따른 필터
    $("select[name=prodPrice]").change(function(){
    	let selectProdPrice = $(this).val();
       	console.log(selectProdPrice);
        
        location.href="/temperShop/product/filter3?prodPrice="+selectProdPrice;
    });
    
    </script>
</html>