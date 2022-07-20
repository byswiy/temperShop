<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="../css/member_update.css">
<title>Document</title>
 <style>
    li button {
		border: none;
		background-color: white;
	}
    </style>
</head>
<body>

	<%@ include file="../includes/header_nav.jsp"%>

	<main class="container">
		<%@ include file="../includes/header.jsp"%>
	</main>
	<hr>
	<div class="container d-flex">
		<div class="d-flex flex-column flex-shrink-0 p-3 bg-light" id="side_bar" style="width: 350px;">
			<a href="/"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-dark text-decoration-none"> <svg
					class="bi me-2" width="40" height="32">
					<use xlink:href="#bootstrap"></use></svg> <span class="fs-4">마이페이지</span>
			</a>
			<hr>
			<ul class="nav nav-pills flex-column mb-auto">
				<li class="nav-item"><a href="/temperShop/product/list?pageNumber=1"
					class="nav-link link-dark" aria-current="page"> <i class="bi bi-shop"></i>&nbsp; home
				</a></li>
				<li><a href="/temperShop/cart/list?userIdx=${loginUserInfo.userIdx }" class="nav-link link-dark"> <i
						class="bi bi-person-lines-fill"></i>&nbsp; 장바구니
				</a></li>
				<li><a href="/temperShop/purchase/history?userIdx=${loginUserInfo.userIdx }" class="nav-link link-dark"> <i
						class="bi bi-bag-check"></i>&nbsp; 구매 내역
				</a></li>
				<li><a href="/temperShop/myPage/member_update.jsp" class="nav-link link-dark"> <i
						class="bi bi-person-lines-fill"></i>&nbsp; 회원 정보 수정
				</a></li>
				<li><a href="/temperShop/myPage/password_update.jsp" class="nav-link link-dark"> <i
						class="bi bi-person-lines-fill"></i>&nbsp; 비밀번호 수정
				</a></li>
				<li><a href="/temperShop/member/delete" class="nav-link link-dark"> <i
						class="bi bi-person-x"></i>&nbsp; 회원 탈퇴
				</a></li>
			</ul>
		</div>

		<div class="modal modal-signin position-static d-block" tabindex="-1" role="dialog"
			id="modalSignin">
			<div role="document">
				<div class="modal-content rounded-5 shadow">
					<div class="modal-header p-5 pb-4 border-bottom-0">
						<!-- <h5 class="modal-title">Modal title</h5> -->
						<h2 class="fw-bold mb-0">후기 작성</h2>
					</div>

					<div class="modal-body p-5">
						<form class="" method="post">
							<div class="form-group" id="divName">
								<label for="inputName" class="col-lg-2 control-label">쇼핑몰 이름</label>
								<div class="col-lg-10">
										<input type="text" class="form-control onlyHangul" id="name" name="name"
											data-rule-required="true" placeholder="한글만 입력 가능합니다." maxlength="15" value="${reviewInfo.purchaseShopName }">
								</div>
							</div>
							<div class="form-group" id="divName">
								<label for="inputName" class="col-lg-2 control-label">상품 명</label>
								<div class="col-lg-10">
										<input type="text" class="form-control onlyHangul" id="name" name="name"
											data-rule-required="true" placeholder="한글만 입력 가능합니다." value="${reviewInfo.purchaseName }">
								</div>
							</div>
							<div class="form-group" id="divEmail">
								<label for="inputEmail" class="col-lg-2 control-label">후기 내용</label>
								<div class="col-lg-10">
									<textarea id="contents" rows="5" cols="72" class="form-control onlyHangul" style="height: 219px;"></textarea>
								</div>
							</div>
							<div class="form-group" style="margin-left: 23%;">
								<button type="submit" class="btn btn-primary" id="review_btn">후기 작성</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<hr>

	<footer class="blog-footer">
		<p>
			Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a
				href="https://twitter.com/mdo">@mdo</a>.
		</p>
		<p>
			<a href="#">Back to top</a>
		</p>
	</footer>

	<script src="../js/jquery-3.6.0.min.js"></script>
	<script>
		$("#review_btn").on("click", function(event){
			event.preventDefault();
			
			let content = $("#contents").val();
			
			$.ajax({
				url: "/temperShop/review/add",
				type: "post",
				data: "purchaseIdx="+${param.purchaseIdx }+"&contents="+content,
				success: function() {
					alert("후기 작성에 성공했습니다");
					location.href="/temperShop/review/list?reviewPage=1";
				},
				error: function() {
					
				}
			});
		});
	</script>
 </body>
</html>