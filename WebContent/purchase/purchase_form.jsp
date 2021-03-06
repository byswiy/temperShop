<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko"><head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, 그리고 Bootstrap 기여자들">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Checkout example · Bootstrap v5.1</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="canonical" href="https://getbootstrap.kr/docs/5.1/examples/checkout/">
    <link rel="apple-touch-icon" href="/docs/5.1/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
    <link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
    <link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
    <link rel="manifest" href="/docs/5.1/assets/img/favicons/manifest.json">
    <link rel="mask-icon" href="/docs/5.1/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
    <link rel="icon" href="/docs/5.1/assets/img/favicons/favicon.ico">
    <meta name="theme-color" content="#7952b3">
    <link href="purchase.css" rel="stylesheet">
    
  </head>
  <body class="bg-light">
    
<div class="container">
  <main>
    <div class="py-5 text-center">
      <h1>구매</h1>
    </div>

    <div class="row g-5">
      <div class="col-md-5 col-lg-4 order-md-last">
        <h4 class="d-flex justify-content-between align-items-center mb-3">
          <span class="text-primary">Your cart</span>
          <span class="badge bg-primary rounded-pill">3</span>
        </h4>
        <ul class="list-group mb-3">
          <li class="list-group-item d-flex justify-content-between lh-sm">
            <div>
              <h6 class="my-0">Product name</h6>
              <small class="text-muted">Brief description</small>
            </div>
            <span class="text-muted">$12</span>
          </li>
          <li class="list-group-item d-flex justify-content-between lh-sm">
            <div>
              <h6 class="my-0">Second product</h6>
              <small class="text-muted">Brief description</small>
            </div>
            <span class="text-muted">$8</span>
          </li>
          <li class="list-group-item d-flex justify-content-between lh-sm">
            <div>
              <h6 class="my-0">Third item</h6>
              <small class="text-muted">Brief description</small>
            </div>
            <span class="text-muted">$5</span>
          </li>
          <li class="list-group-item d-flex justify-content-between bg-light">
            <div class="text-success">
              <h6 class="my-0">Promo code</h6>
              <small>EXAMPLECODE</small>
            </div>
            <span class="text-success">−$5</span>
          </li>
          <li class="list-group-item d-flex justify-content-between">
            <span>Total (USD)</span>
            <strong>$20</strong>
          </li>
        </ul>
      </div>
      <div class="col-md-7 col-lg-8">
        <h3 class="mb-3">배송 정보</h3><hr>
        <h4 style="display: inline-block;">주문자 정보</h4>&nbsp;&nbsp;
        <button type="button" style="border: 0.5px solid black;" id="update_btn">정보 변경</button>
        
        <form class="needs-validation" action="" method="post">
          <div class="row g-3">
            <div class="col-12">
              <label for="name" class="form-label">이름</label>
              <input type="text" class="form-control" id="name" name="name" value="${loginUserInfo.name }" required>
            </div>

            <div class="col-12">
                <label for="tel" class="form-label">휴대폰 번호</label>
                <input type="text" class="form-control" id="tel" name="tel" value="${loginUserInfo.tel }" required>
              </div>

            <div class="col-12">
              <label for="email" class="form-label">이메일</label>
              <input type="email" class="form-control" id="email" name="email" value="${loginUserInfo.email }" required>
            </div>

            <div class="col-12">
              <label for="postalCode" class="form-label">우편번호</label>
              <input type="text" class="form-control" id="postalCode" name="postalCode" value="${loginUserInfo.postalCode }" required>
            </div>

            <div class="col-12">
              <label for="address" class="form-label">주소</label>
              <input type="text" class="form-control" id="address" name="address" value="${loginUserInfo.addr }" required>
            </div>

            <div class="col-12">
                <label for="message" class="form-label">배송 메세지
                	<input type="text" class="form-control" id="message" name="message" placeholder="ex. 부재시 경비실에 맡겨주세요" style="display: inline-block;">
                </label><br>
                
                <small>* 배송 메세지가 필요하다면 입력해주세요</small>
                
              </div>
          </div>

          <hr class="my-4">

          <div class="form-check">
            <input type="checkbox" class="form-check-input" id="check">
            <label class="form-check-label" for="same-address">[동의] 실제 구매된 가격은 00시 전에 환불됨을 알려드립니다</label>
          </div>

          <hr class="my-4">

          <h4 class="mb-3">결제</h4>
          <h5 class="mb-3" style="display: inline-block;">결제 금액 : </h5>
          <input id="cost" name="cost" type="text" class="form-cost" value="${purchaseInfo.purchaseCost }">

          <div class="my-3">
            <div class="form-check">
              <input id="credit" name="paymentMethod" type="radio" class="form-check-input">
              <label class="form-check-label" for="credit">Credit card</label>
            </div>
		  </div>
		  
          <hr class="my-4">

          <button class="btn btn-secondary btn-lg" type="submit" id="list_btn">목록페이지로 돌아가기</button>
          <button class="w-50 btn btn-primary btn-lg" type="submit" id="pay_btn">결제하기</button>
        </form>
      </div>
    </div>
  </main>
</div>


    <script src="../js/jquery-3.6.0.min.js"></script>
	<script>
		$("#update_btn").on("click", function(){
			alert("정보수정을 위해 회원정보 수정 페이지로 이동합니다.")
			location.href="/temperShop/myPage/member_update.jsp";
		});
		
	</script>
	<script>
		$("#list_btn").on("click", function(){
			$.ajax({
				url: "/temperShop/purchase/cancel_list?",
				type: "post",
				data: "purchaseDate=${purchaseInfo.purchaseDate}",
				success: function() {
					alert("구매를 취소하고 목록으로 돌아갑니다");
					location.href="/temperShop/product/list?pageNumber=1";
				},
				error: function(response) {
					if(response.status == 409) {
						alert("오류 발생");
					}
				}
			});
		});
		
	</script>
	<script> 
		// 배송메세지가 null이 아니라면 메세지 수정 컨트롤러로 이동할 수 있도록 한다
		$("#pay_btn").on("click", function(event){
				
			let check = $("#check").prop("checked");
			
			if(!check) {
 				alert("동의박스에 체크 해주세요.");
 				return false;
	 		}
			
			event.preventDefault();
			
			let $message = $("#message");
			let message = $message.val();
			console.log(message);
			
			if(message != "") {	
				$.ajax({
					url: "/temperShop/update/message",
					type: "post",
					data: "message="+message+"&purchaseDate=${purchaseInfo.purchaseDate}",
					success: function() {
						location.href="/temperShop/purchase/purchase.jsp";
					}
				})
			} else {
				location.href="/temperShop/purchase/purchase.jsp";
			}
		})
		
		$("#list_btn").on("click", function() {
			location.href="/temperShop/product/list?pageNumber=1";
		})
	</script>
</body></html>