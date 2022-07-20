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

	<%@ include file="../includes/header_nav.jsp"%>>

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
				<li><a href="/temperShop/myPage/member_delete.jsp" class="nav-link link-dark"> <i
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
						<h2 class="fw-bold mb-0">회원정보 수정</h2>
					</div>

					<div class="modal-body p-5">
						<form class="">
							<div class="form-group" id="divId">
								<label for="inputId" class="col-lg-2 control-label">아이디</label>
								<div class="col-lg-10">
									<input type="text" class="form-control onlyAlphabetAndNumber" id="id" name="id"
										data-rule-required="true" placeholder="30자이내의 알파벳, 언더스코어(_), 숫자만 입력 가능합니다."
										maxlength="30" value="${loginUserInfo.id }" disabled>
								</div>
							</div>
							<div class="form-group" id="divName">
								<label for="inputName" class="col-lg-2 control-label">이름</label>
								<div class="col-lg-10">
										<input type="text" class="form-control onlyHangul" id="name" name="name"
											data-rule-required="true" placeholder="한글만 입력 가능합니다." maxlength="15" value="${loginUserInfo.name }">
								</div>
							</div>

							<div class="form-group" id="divEmail">
								<label for="inputEmail" class="col-lg-2 control-label">이메일</label>
								<div class="col-lg-10">
									<input type="email" class="form-control" id="email" name="email"
										data-rule-required="true" placeholder="이메일" maxlength="40" value="${loginUserInfo.email }">
								</div>
							</div>
							<div class="form-group" id="divPhoneNumber">
								<label for="inputPhoneNumber" class="col-lg-2 control-label">휴대폰 번호</label>
								<div class="col-lg-10">
									<input type="tel" class="form-control onlyNumber" id="tel" name="tel"
										data-rule-required="true" placeholder="-를 포함해서 숫자를 입력해주세요." maxlength="13" value="${loginUserInfo.tel }">
								</div>
							</div>
							<div class="form-group" id="divAddr">
								<label for="inputAddr" class="control-label"> 주소 <input type="button"
									onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
								</label>

								<div style="width: 84%;">
									<input type="text" class="form-control addr" id="sample4_postcode"
										name="sample4_postcode" data-rule-required="true" placeholder="우편변호" maxlength="11" value="${loginUserInfo.postalCode }">
									<input type="text" class="form-control addr" id="sample4_roadAddress"
										name="sample4_roadAddress" data-rule-required="true" placeholder="도로명주소" maxlength="11" value="${loginUserInfo.addr }">
									<span id="guide" style="color: #999; display: none"></span>
								</div>
							</div>
							<div class="form-group" style="margin-left: 23%;">
								<button type="submit" class="btn btn-primary" id="update_btn">회원정보 수정</button>
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
 	// 회원정보 수정
	$("#update_btn").on("click", function(event) {
		// ajax를 통해서 상품 수정 요청이 들어가도록 한다
		event.preventDefault();
		
		let $id = $("#id");
		let $name = $("#name");
		let $tel = $("#tel");
		let $postalCode = $("#sample4_postcode");
		let $addr = $("#sample4_roadAddress");
		let $email = $("#email");
		
		let id = $id.val();
		let name = $name.val();
		let tel = $tel.val();
		let postalCode = $postalCode.val();
		let addr = $addr.val();
		let email = $email.val();
		
		$.ajax({
			url: "/temperShop/member/update",
			type: "POST",
			data: "userIdx="+${loginUserInfo.userIdx}+"&name="+name+"&tel="+tel+"&postalCode="+postalCode+"&addr="+addr+
			     "&email="+email,
			success: function() {
				// 상품 정보가 수정되었을 경우
				alert("회원 정보가 수정됐습니다 쇼핑몰 페이지로 이동합니다");
				location.href="/temperShop/product/list?pageNumber=1";
			},
			error: function(response) {
  				// 파라미터 규칙에 맞지 않다면 400 상태 코드를 보낸다
  				if(response.status == 400) {
  					alert("수정 정보를 올바르게 입력해주세요");
  				} else if(response.status == 409) {
  					// 아이디, 연락처, 이메일이 이미 사용 중이라면 409 상태코드를 보낻다
  					alert("아이디, 연락처, 이메일 중 이미 사용 중인 정보가 있습니다")
  				}
  				
  			}
		});
		
	});
    </script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
     //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
     function sample4_execDaumPostcode() {
         new daum.Postcode({
             oncomplete: function(data) {
             // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

             // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
             // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
             var roadAddr = data.roadAddress; // 도로명 주소 변수
             var extraRoadAddr = ''; // 참고 항목 변수

             // 법정동명이 있을 경우 추가한다. (법정리는 제외)
             // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
             if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                 extraRoadAddr += data.bname;
             }
             // 건물명이 있고, 공동주택일 경우 추가한다.
             if(data.buildingName !== '' && data.apartment === 'Y'){
                extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
             }
             // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
             if(extraRoadAddr !== ''){
                 extraRoadAddr = ' (' + extraRoadAddr + ')';
             }

             // 우편번호와 주소 정보를 해당 필드에 넣는다.
             document.getElementById('sample4_postcode').value = data.zonecode;
             document.getElementById("sample4_roadAddress").value = roadAddr;
             }
         }).open();
     }
 </script>
 </body>
</html>