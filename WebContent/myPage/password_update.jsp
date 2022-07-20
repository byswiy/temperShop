<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/password_update.css">
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

        <div class="modal modal-signin position-static d-block" tabindex="-1" role="dialog" id="modalSignin">
          <div role="document">
            <div class="modal-content rounded-5 shadow">
              <div class="modal-header p-5 pb-4 border-bottom-0">
                <!-- <h5 class="modal-title">Modal title</h5> -->
                <h2 class="fw-bold mb-0" style="margin-left: 64px;">비밀번호 변경</h2>
              </div>
        
              <div class="modal-body">
                <form class="" style="margin-left: 101px;">
                <div class="form-group">
                    <label for="inputPasswordCheck" class="col-lg-2 control-label">현재 비밀번호</label>
                    <div class="col-lg-10">
                        <input type="password" class="form-control" id="oldPw" name="oldPw" data-rule-required="true"
                        	   placeholder="현재 비밀번호" maxlength="30">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPasswordCheck" class="col-lg-2 control-label">변경할 비밀번호</label>
                    <div class="col-lg-10">
                        <input type="password" class="form-control" id="newPw" name="newPw" data-rule-required="true"
                        	   placeholder="비밀번호는 8~18자 사이로 영대소문자와 숫자를 혼합하여 입력해주세요" maxlength="30">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPasswordCheck" class="col-lg-2 control-label">비밀번호 확인</label>
                    <div class="col-lg-10">
                        <input type="password" class="form-control" id="newPwChk" name="newPwChk" data-rule-required="true" placeholder="비밀번호 확인" maxlength="30">
                    </div>
                </div>
                <div class="form-group">
                  <button type="submit" class="btn btn-primary" id="pw_update">변경하기</button>
                </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>

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
 		// 비밀번호 수정
 		$("#pw_update").on("click", function(event) {
 			// ajax를 통해서 상품 수정 요청이 들어가도록 한다
 			event.preventDefault();
 			
 			let oldPw = $("#oldPw").val();
 			let $newPw = $("#newPw");
 			let $newPwChk = $("#newPwChk");
 			
 			let	newPw = $newPw.val();
 			let newPwChk = $newPwChk.val();
 			
 			$.ajax({
 				url: "/temperShop/member/update_pw",
 				type: "POST",
 				data: "oldPw="+oldPw+"&newPw="+newPw+"&newPwChk="+newPwChk,
 				success: function() {
 					// 비밀번호가 수정되었을 경우
 					alert("비밀번호가 수정됐습니다 쇼핑몰 페이지로 이동합니다");
 					location.href="/temperShop/product/list?pageNumber=1";
 				},
 				error: function(response) {
 	  				// 파라미터 규칙에 맞지 않다면 400 상태 코드를 보낸다
 	  				if(response.status == 400) {
 	  					alert("비밀번호 확인이 일치하지 않습니다 다시 입력해주세요");
 	  				} else if(response.status == 409) {
 	  					// 변경하려는 비밀번호와 현재 비밀번호가 일치하면 409 상태코드를 보낻다
 	  					alert("현재 비밀번호와 동일한 비밀번호 입니다")
 	  				}
 	  				
 	  			}
 			});
 			
 		});
    </script>
</html>