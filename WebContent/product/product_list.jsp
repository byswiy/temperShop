<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
</head>
<body>
    
    <div class="container">
      <header class="blog-header py-3">
        <div class="row flex-nowrap justify-content-between align-items-center">
          <div class="col-4 pt-1">
            <i class="bi bi-thermometer-sun"></i>
          </div>
          <div class="col-4 text-center">
            <a class="blog-header-logo text-dark" href="#">temperShop</a>
          </div>
          <div class="col-4 d-flex justify-content-end align-items-center">
            <ul class="nav col-12 col-lg-auto mb-2 justify-content-center mb-md-0">
                <li><button class="nav-link px-2 link-dark" type="button" name="login" id="login_btn">login</button></li>
                <li><button class="nav-link px-2 link-dark" type="button" name="sign-up" id="sign-up">sign-up</button></li>
                <li><button class="nav-link px-2 link-dark" type="button" name="cart" id="cart">cart</button></li>
                <li><button class="nav-link px-2 link-dark" type="button" name="myPage" id="myPage">myPage</button></li>
              </ul>
          </div>
        </div>
    </header>
    </div>
    
    <main class="container">
      
      <div class="mb-4 img-wrap">
        <div class="image_wrap">
          <img src="https://search.pstatic.net/sunny/?src=https%3A%2F%2Fmedia.gettyimages.com%2Fvectors%2Fsummer-holiday-vector-id1132163504%3Fk%3D20%26m%3D1132163504%26s%3D612x612%26w%3D0%26h%3Dajh-kLrrYNtYyNIXN50uviXgzRYIWIOPrRTZHkurkc4%3D&type=a340" alt="">
        </div>
        <div class="image_text">
          <p><strong>현재 온도 : </strong></p>
          <p><strong>온도에 맞게 추천된 옷 : </strong></p>
        </div>
      </div>

      <h3 class="filter fst-italic">Filter</h3>

      <a href="">home</a>

      <span>></span>

      <select class="form-select prodType" aria-label="Default select example">
          <option selected>구분</option>
          <option value="1">Top</option>
          <option value="2">Bottom</option>
          <option value="3">Dress</option>
      </select>

      <span>></span>
      
      <select class="form-select prodType" aria-label="Default select example">
        <option selected>종류</option>
        <option value="1">Top</option>
        <option value="2">Bottom</option>
        <option value="3">Dress</option>
    </select>

    <span>></span>

      <select class="form-select prodSize" aria-label="Default select example">
        <option selected>사이즈</option>
        <option value="1">S</option>
        <option value="2">M</option>
        <option value="3">L</option>
      </select>

      <select class="form-select prodColor" aria-label="Default select example">
        <option selected>색상</option>
        <option value="1">Red</option>
        <option value="2">Yellow</option>
        <option value="4">Green</option>
        <option value="5">Blue</option>
        <option value="6">White</option>
        <option value="7">Black</option>
      </select>

      <select class="form-select prodPrice" aria-label="Default select example">
        <option selected>가격</option>
        <option value="1">낮은 순</option>
        <option value="2">높은 순</option>
      </select>

      <hr>

      <div class="card" style="max-width: 24%;">
        <a href="##"><img src="https://search.pstatic.net/common/?src=https%3A%2F%2Fshopping-phinf.pstatic.net%2Fmain_8401410%2F84014102631.jpg&type=a340" width="200" hight="250" class="card-img-top" alt="..."></a>
        <div class="card-body">
          <a href=""><h6 class="card-title">[미쏘]</h6></a>
          <p class="card-text">
            <span>상품 명 : </span><br><br>
            <strong><span>상품 가격 : </span><br></strong>
          </p>
        </div>
      </div>

      <div class="card" style="max-width: 24%;">
        <a href="##"><img src="https://search.pstatic.net/common/?src=https%3A%2F%2Fshopping-phinf.pstatic.net%2Fmain_8401410%2F84014102631.jpg&type=a340" width="200" hight="250" class="card-img-top" alt="..."></a>
        <div class="card-body">
          <a href=""><h6 class="card-title">[미쏘]</h6></a>
          <p class="card-text">
            <span>상품 명 : </span><br><br>
            <strong><span>상품 가격 : </span><br></strong>
          </p>
        </div>
      </div>

      <div class="card" style="max-width: 24%;">
        <a href="##"><img src="https://search.pstatic.net/common/?src=https%3A%2F%2Fshopping-phinf.pstatic.net%2Fmain_8401410%2F84014102631.jpg&type=a340" width="200" hight="250" class="card-img-top" alt="..."></a>
        <div class="card-body">
          <a href=""><h6 class="card-title">[미쏘]</h6></a>
          <p class="card-text">
            <span>상품 명 : </span><br><br>
            <strong><span>상품 가격 : </span><br></strong>
          </p>
        </div>
      </div>

      <div class="card" style="max-width: 24%;">
        <a href="##"><img src="https://search.pstatic.net/common/?src=https%3A%2F%2Fshopping-phinf.pstatic.net%2Fmain_8401410%2F84014102631.jpg&type=a340" width="200" hight="250" class="card-img-top" alt="..."></a>
        <div class="card-body">
          <a href=""><h6 class="card-title">[미쏘]</h6></a>
          <p class="card-text">
            <span>상품 명 : </span><br><br>
            <strong><span>상품 가격 : </span><br></strong>
          </p>
        </div>
      </div>

      <div class="card" style="max-width: 24%;">
        <a href="##"><img src="https://search.pstatic.net/common/?src=https%3A%2F%2Fshopping-phinf.pstatic.net%2Fmain_8401410%2F84014102631.jpg&type=a340" width="200" hight="250" class="card-img-top" alt="..."></a>
        <div class="card-body">
          <a href=""><h6 class="card-title">[미쏘]</h6></a>
          <p class="card-text">
            <span>상품 명 : </span><br><br>
            <strong><span>상품 가격 : </span><br></strong>
          </p>
        </div>
      </div>

      <div class="card" style="max-width: 24%;">
        <a href="##"><img src="https://search.pstatic.net/common/?src=https%3A%2F%2Fshopping-phinf.pstatic.net%2Fmain_8401410%2F84014102631.jpg&type=a340" width="200" hight="250" class="card-img-top" alt="..."></a>
        <div class="card-body">
          <a href=""><h6 class="card-title">[미쏘]</h6></a>
          <p class="card-text">
            <span>상품 명 : </span><br><br>
            <strong><span>상품 가격 : </span><br></strong>
          </p>
        </div>
      </div>

      <div class="card" style="max-width: 24%;">
        <a href="##"><img src="https://search.pstatic.net/common/?src=https%3A%2F%2Fshopping-phinf.pstatic.net%2Fmain_8401410%2F84014102631.jpg&type=a340" width="200" hight="250" class="card-img-top" alt="..."></a>
        <div class="card-body">
          <a href=""><h6 class="card-title">[미쏘]</h6></a>
          <p class="card-text">
            <span>상품 명 : </span><br><br>
            <strong><span>상품 가격 : </span><br></strong>
          </p>
        </div>
      </div>

      <div class="card" style="max-width: 24%;">
        <a href="##"><img src="https://search.pstatic.net/common/?src=https%3A%2F%2Fshopping-phinf.pstatic.net%2Fmain_8401410%2F84014102631.jpg&type=a340" width="200" hight="250" class="card-img-top" alt="..."></a>
        <div class="card-body">
          <a href=""><h6 class="card-title">[미쏘]</h6></a>
          <p class="card-text">
            <span>상품 명 : </span><br><br>
            <strong><span>상품 가격 : </span><br></strong>
          </p>
        </div>
      </div>

      
      <div class="card" style="max-width: 24%;">
        <a href="##"><img src="https://search.pstatic.net/common/?src=https%3A%2F%2Fshopping-phinf.pstatic.net%2Fmain_8401410%2F84014102631.jpg&type=a340" width="200" hight="250" class="card-img-top" alt="..."></a>
        <div class="card-body">
          <a href=""><h6 class="card-title">[미쏘]</h6></a>
          <p class="card-text">
            <span>상품 명 : </span><br><br>
            <strong><span>상품 가격 : </span><br></strong>
          </p>
        </div>
      </div>

      <div class="card" style="max-width: 24%;">
        <a href="##"><img src="https://search.pstatic.net/common/?src=https%3A%2F%2Fshopping-phinf.pstatic.net%2Fmain_8401410%2F84014102631.jpg&type=a340" width="200" hight="250" class="card-img-top" alt="..."></a>
        <div class="card-body">
          <a href=""><h6 class="card-title">[미쏘]</h6></a>
          <p class="card-text">
            <span>상품 명 : </span><br><br>
            <strong><span>상품 가격 : </span><br></strong>
          </p>
        </div>
      </div>

      <div class="card" style="max-width: 24%;">
        <a href="##"><img src="https://search.pstatic.net/common/?src=https%3A%2F%2Fshopping-phinf.pstatic.net%2Fmain_8401410%2F84014102631.jpg&type=a340" width="200" hight="250" class="card-img-top" alt="..."></a>
        <div class="card-body">
          <a href=""><h6 class="card-title">[미쏘]</h6></a>
          <p class="card-text">
            <span>상품 명 : </span><br><br>
            <strong><span>상품 가격 : </span><br></strong>
          </p>
        </div>
      </div>

      <div class="card" style="max-width: 24%;">
        <a href="##"><img src="https://search.pstatic.net/common/?src=https%3A%2F%2Fshopping-phinf.pstatic.net%2Fmain_8401410%2F84014102631.jpg&type=a340" width="200" hight="250" class="card-img-top" alt="..."></a>
        <div class="card-body">
          <a href=""><h6 class="card-title">[미쏘]</h6></a>
          <p class="card-text">
            <span>상품 명 : </span><br><br>
            <strong><span>상품 가격 : </span><br></strong>
          </p>
        </div>
      </div>

      <hr>

      <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
          <li class="page-item disabled">
            <a class="page-link">Previous</a>
          </li>
          <li class="page-item"><a class="page-link" href="#">1</a></li>
          <li class="page-item"><a class="page-link" href="#">2</a></li>
          <li class="page-item"><a class="page-link" href="#">3</a></li>
          <li class="page-item"><a class="page-link" href="#">4</a></li>
          <li class="page-item"><a class="page-link" href="#">5</a></li>
          <li class="page-item">
            <a class="page-link" href="#">Next</a>
          </li>
        </ul>
      </nav>
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
    	$("#login_btn").on("click", function() {
    		location.href="/temperShop/login/login.jsp";
    	})
    </script>
    
</html>