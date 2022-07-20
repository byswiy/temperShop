<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/terms.css">
    <title>Document</title>
</head>
<body class="text-center">
    <main class="form-signin">
      <form action="/temperShop/sign_up/sign_up.jsp">
        <h1 class="h1 mb-3 fw-normal">이용약관</h1>
    
    	<!-- 이용약관 -->
        <div class="checkbox_group">
            <p class="allprivate">
                <input type="checkbox" id="check_all" >
                <label for="check_all">
                    temperShop 이용약관, 개인정보 수집 및 이용에 모두 동의합니다.
                </label>
            </p>
            <p class="private">
            	<input type="checkbox" id="check_1" class="normal">	
            	<label for="check_1">
                    개인정보 처리방침 동의(필수)
                </label> 
                <div class="terms_box" tabindex="0" id="divService">
                    <div class="article">
                        <h6 class="article__title">여러분을 환영합니다.</h6>
                        <p class="article__text">
                            temperShop 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다.
                            본 약관은 다양한 temperShop 서비스의 이용과 관련하여 temperShop 서비스를 제공하는 temperShop 주식회사(이하 ‘temperShop’)와
                            이를 이용하는 temperShop 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며,
                            아울러 여러분의 temperShop 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
                        </p>
                        <p class="article__text">
                            temperShop 서비스를 이용하시거나 temperShop 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로,
                            잠시 시간을 내시어 주의 깊게 살펴봐 주시기 바랍니다.
                        </p>
                    </div>
                    <div class="article">
                        <h6 class="article__title">다양한 temperShop 서비스를 즐겨보세요.</h6>
                        <p class="article__text">
                            temperShop는 기본적으로 여러분 모두에게 동일한 내용의 서비스를 제공합니다.
                            다만, '청소년보호법' 등 관련 법령이나 기타 개별 서비스 제공에서의 특별한 필요에 의해서 연령 또는 일정한 등급을 기준으로 이용자를 구분하여 제공하는 서비스의 내용, 이용 시간, 이용 횟수 등을 다르게 하는 등 일부 이용을 제한하는 경우가 있습니다.
                            자세한 내용은 역시 각 서비스 상의 안내, 공지사항, 고객센터 도움말 등에서 확인하실 수 있습니다.
                        </p>
                        <p class="article__text">
                            temperShop 서비스에는 기본적으로 본 약관이 적용됩니다만 temperShop가 다양한 서비스를 제공하는 과정에서 부득이 본 약관 외 별도의 약관, 운영정책 등을 적용하는 경우(예, temperShop페이, V LIVE 등)가 있습니다.
                            그리고 temperShop 계열사가 제공하는 특정 서비스의 경우에도(예, LINE, SNOW등) 해당 운영 회사가 정한 고유의 약관, 운영정책 등이 적용될 수 있습니다.
                            이러한 내용은 각각의 해당 서비스 초기 화면에서 확인해 주시기 바랍니다.
                        </p>
                    </div>
                </div>
            </p>
            <p class="service">
            	<input type="checkbox" id="check_2" class="normal">
            	<label for="check_2">서비스 이용약관 동의(필수)</label>
                <div class="terms_box" tabindex="0" id="divService">
                    <div class="article">
                        <h6 class="article__title">여러분을 환영합니다.</h6>
                        <p class="article__text">
                            temperShop 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다.
                            본 약관은 다양한 temperShop 서비스의 이용과 관련하여 temperShop 서비스를 제공하는 temperShop 주식회사(이하 ‘temperShop’)와
                            이를 이용하는 temperShop 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며,
                            아울러 여러분의 temperShop 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
                        </p>
                        <p class="article__text">
                            temperShop 서비스를 이용하시거나 temperShop 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 관련 운영 정책을 확인하거나 동의하게 되므로,
                            잠시 시간을 내시어 주의 깊게 살펴봐 주시기 바랍니다.
                        </p>
                    </div>
                    <div class="article">
                        <h6 class="article__title">다양한 temperShop 서비스를 즐겨보세요.</h6>
                        <p class="article__text">
                            temperShop는 기본적으로 여러분 모두에게 동일한 내용의 서비스를 제공합니다.
                            다만, '청소년보호법' 등 관련 법령이나 기타 개별 서비스 제공에서의 특별한 필요에 의해서 연령 또는 일정한 등급을 기준으로 이용자를 구분하여 제공하는 서비스의 내용, 이용 시간, 이용 횟수 등을 다르게 하는 등 일부 이용을 제한하는 경우가 있습니다.
                            자세한 내용은 역시 각 서비스 상의 안내, 공지사항, 고객센터 도움말 등에서 확인하실 수 있습니다.
                        </p>
                        <p class="article__text">
                            temperShop 서비스에는 기본적으로 본 약관이 적용됩니다만 temperShop가 다양한 서비스를 제공하는 과정에서 부득이 본 약관 외 별도의 약관, 운영정책 등을 적용하는 경우(예, temperShop페이, V LIVE 등)가 있습니다.
                            그리고 temperShop 계열사가 제공하는 특정 서비스의 경우에도(예, LINE, SNOW등) 해당 운영 회사가 정한 고유의 약관, 운영정책 등이 적용될 수 있습니다.
                            이러한 내용은 각각의 해당 서비스 초기 화면에서 확인해 주시기 바랍니다.
                        </p>
                    </div>
                </div>
            </p>
          </div>
        <input class="w-100 btn btn-lg btn-secondary" type="submit" value="회원가입 다음단계">
      </form>
    </main>
    
    <script src="../js/jquery-3.6.0.min.js"></script>
	<script>
  		// 체크박스 전체 선택
  		$(".checkbox_group").on("click", "#check_all", function () {
  		    $(this).parents(".checkbox_group").find('input').prop("checked", $(this).is(":checked"));
  		});

  		// 체크박스 개별 선택
  		$(".checkbox_group").on("click", ".normal", function() {
  		    var is_checked = true;

  		    $(".checkbox_group .normal").each(function(){
  		        is_checked = is_checked && $(this).is(":checked");
  		    });

  		    $("#check_all").prop("checked", is_checked);
  		});
  		
  		$("input[type=submit]").on("click", function(){
  			let check_1 = $("#check_1").prop("checked");
  			let check_2 = $("#check_2").prop("checked");
  		
  			if(!check_1 || !check_2) {
  				alert("이용 약관 동의와 개인 정보 수집 및 이용동의가 체크되야합니다.");
  				return false;
  			}
  			
  		}); 
  		
	</script>
</body>
</html>