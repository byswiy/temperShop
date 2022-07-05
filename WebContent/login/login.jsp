<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/login.css">
    <title>Document</title>
</head>
<body class="text-center">
    
    <main class="login">
      <form>
        <a href="/temperShop/product/product_list.jsp"><i class="bi bi-shop-window"></i>temperShop</a>

        <h2 class="text">로그인</h2>
    
        <div class="form-floating">
          <input type="email" class="form-control" id="id" name="id" placeholder="name@example.com">
          <label for="floatingInput">아아디</label>
        </div>
        <div class="form-floating">
          <input type="password" class="form-control" id="pw" name="pw" placeholder="Password">
          <label for="floatingPassword">비밀번호</label>
        </div>
    
        <input class="btn btn-lg btn-primary" type="submit" id="login-btn" value="로그인">
      </form>
    </main>
    
    <script src="../js/jquery-3.6.0.min.js"></script>
  	<script>
  	// 로그인 버튼을 눌렀을 때 이동
  	$("#login-btn").on("click", function(event) {
  		event.preventDefault();
  		
  		let $id = $("#id");
  		let $pw = $("#pw");
  	
  		let id = $id.val();
  		let pw = $pw.val();
  	
  		$.ajax({
  			url: "/temperShop/member/login",
  			type: "POST",
  			data: "id="+id+"&pw="+pw,
  			success: function() {
  				// 로그인에 성공했다면 200 상태코드를 반환하고
  				// main(index) 페이지로 돌아간다
  				alert("로그인에 성공했습니다! 쇼핑몰 페이지로 돌아갑니다");
  				location.href = "/temperShop/product/product_list.jsp";
  			},
  			error: function(response) {
  				// 파라미터가 규칙에 맞지 않을 때 400 반환
  				if(response.status == 400) {
  					alert("아이디와 비밀번호를 정확히 입력해주세요");
  				} else if(response.status == 401) {
  					// 아이디나 비밀번호가 일치하지 않을 때 401 반환
  					alert("아이디와 비밀번호를 확인해주세요");
  				}
  			}
  		});
  	});
  	</script>
    </body>
</html>