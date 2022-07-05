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
<link rel="stylesheet" href="../css/sign_up.css">
<title>Document</title>
</head>
<body>
	<main class="form-signin">
		<h1 class="mb-3" style="margin-left: 215px;">회원가입</h1>
		<form>
			<div class="container">
				<!-- 좌우측의 공간 확보 -->
				<div class="form-group" id="divId">
					<label for="inputId" class="col-lg-2 control-label">아이디</label>
					<div class="col-lg-10">
						<input type="text" class="form-control onlyAlphabetAndNumber" id="id" name="id"
							data-rule-required="true" placeholder="영소문자와 숫자를 혼합하여 8~18자로 입력해주세요." maxlength="30">
					</div>
				</div>
				<div class="form-group" id="divPassword">
					<label for="inputPassword" class="col-lg-2 control-label">비밀번호</label>
					<div class="col-lg-10">
						<input type="password" class="form-control" id="password" name="password"
							data-rule-required="true" placeholder="영대/소문자와 숫자를 혼합하여 8~18자로 입력해주세요." maxlength="30">
					</div>
				</div>
				<div class="form-group" id="divPasswordCheck">
					<label for="inputPasswordCheck" class="col-lg-2 control-label">비밀번호 확인</label>
					<div class="col-lg-10">
						<input type="password" class="form-control" id="passwordCheck" name="passwordCheck" data-rule-required="true"
							maxlength="30">
					</div>
				</div>
				<div class="form-group" id="divName">
					<label for="inputName" class="col-lg-2 control-label">이름</label>
					<div class="col-lg-10">
						<input type="text" class="form-control onlyHangul" id="name" name="name" data-rule-required="true"
							maxlength="15">
					</div>
				</div>

				<div class="form-group" id="divEmail">
					<label for="inputEmail" class="col-lg-2 control-label">이메일</label>
					<div class="col-lg-10">
						<input type="email" class="form-control" id="email" name="email" data-rule-required="true" maxlength="40">
					</div>
				</div>
				<div class="form-group" id="divPhoneNumber">
					<label for="inputPhoneNumber" class="col-lg-2 control-label">휴대폰 번호</label>
					<div class="col-lg-10">
						<input type="tel" class="form-control onlyNumber" id="phoneNumber" name="phoneNumber" data-rule-required="true"
							placeholder="-를 포함해서 숫자를 입력해주세요." maxlength="13">
					</div>
				</div>
				<div class="form-group" id="divAddr">
					<label for="inputAddr" class="col control-label"> 주소 <input type="button"
						onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
					</label>

					<div class="col-lg-10">
						<input type="text" class="form-control addr" id="postal_code" name="postal_code" data-rule-required="true"
							maxlength="11">
						<input type="text" class="form-control addr" id="addr" name="addr" data-rule-required="true" maxlength="11">
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input class="w-100 btn btn-lg btn-primary" type="submit" id="sign_up_btn" value="회원가입"
							style="margin-top: 20px;">
					</div>
				</div>
			</div>
		</form>
	</main>

	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="../js/jquery-3.6.0.min.js"></script>
	<script src="../js/validator.js"></script>
	<script>
		//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
		function sample4_execDaumPostcode() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var roadAddr = data.roadAddress; // 도로명 주소 변수
							var extraRoadAddr = ''; // 참고 항목 변수

							// 법정동명이 있을 경우 추가한다. (법정리는 제외)
							// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
							if (data.bname !== ''
									&& /[동|로|가]$/g.test(data.bname)) {
								extraRoadAddr += data.bname;
							}
							// 건물명이 있고, 공동주택일 경우 추가한다.
							if (data.buildingName !== ''
									&& data.apartment === 'Y') {
								extraRoadAddr += (extraRoadAddr !== '' ? ', '
										+ data.buildingName : data.buildingName);
							}
							// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
							if (extraRoadAddr !== '') {
								extraRoadAddr = ' (' + extraRoadAddr + ')';
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('postal_code').value = data.zonecode;
							document.getElementById("addr").value = roadAddr;
						}
					}).open();
		}
		
		
		$("#sign_up_btn").on("click", function(event) {
			event.preventDefault();
			
			let id = $("#id").val();
	  		let pw = $("#password").val();
	  		let pwChk = $("#passwordCheck").val();
	  		let name = $("#name").val();
	  		let tel = $("#phoneNumber").val();
	  		let postalCode = $("#postal_code").val();
	  		let addr = $("#addr").val();
	  		let email = $("#email").val();
	  		
	  		if(idValidator(id)) {
	  			alert("아이디를 확인하세요.");
	  			return false;
	  		} else if(pwValidator(pw)) {
	  			alert("비밀번호를 확인하세요.");
	  			return false;
	  		} else if(pw != pwChk) {
	  			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
	  			return false;
	  		} else if(nameValidator(name)) {
	  			alert("이름를 확인하세요.");
	  			return false;
	  		} else if(telValidator(tel)) {
	  			alert("연락처를 확인하세요.");
	  			return false;
	  		} else if(addrValidator(addr)) {
	  			alert("주소를 확인하세요.");
	  			return false;
	  		} else if(emailValidator(email)) {
	  			alert("이메일를 확인하세요.");
	  			return false;
	  		}
	  		
	  		$.ajax({
	  			url: "/temperShop/member/join",
	  			type: "POST",
	  			data: "id=" + id + "&pw=" + pw + "&pwChk=" + pwChk + "&name=" + name + "&tel=" + tel + "&postalCode=" + postalCode + "&addr=" + addr + "&email=" + email,
	  			success: function() {
	  				// 회원가입을 성공했을 때
	  				alert("회원가입에 성공했습니다! 로그인 페이지로 이동합니다.");
	  				location.href = "/temperShop/login/login.jsp";
	  			},
	  			error : function(response) {
	  				// 회원가입에 실패했을 때
	  				if(response.status == 400) {
  					alert("가입 정보를 올바르게 입력해주세요");
  				} else if(response.status == 409) {
  					// 아이디, 연락처, 이메일이 이미 사용 중이라면 409 상태코드를 보낻다
  					alert("아이디, 연락처, 이메일 중 이미 사용 중인 정보가 있습니다")
  				}
	  			}
	  		});
		});
	</script>
</body>
</html>