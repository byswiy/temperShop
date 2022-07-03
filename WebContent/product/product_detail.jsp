<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <link rel="stylesheet" href="../css/product_detail.css">
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
                <li><a href="#" class="nav-link px-2 link-dark">login</a></li>
                <li><a href="#" class="nav-link px-2 link-dark">sing-up</a></li>
                <li><a href="#" class="nav-link px-2 link-dark">cart</a></li>
                <li><a href="#" class="nav-link px-2 link-dark">myPage</a></li>
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

      <hr>

      <div class="container px-4 py-5">
        <div class="row align-items-center g-5">
          <div class="col-10 col-sm-8 col-lg-6">
            <img src="https://search.pstatic.net/common/?src=https%3A%2F%2Fshopping-phinf.pstatic.net%2Fmain_8401410%2F84014102631.jpg&type=a340" class="d-block mx-lg-auto img-fluid" alt="Bootstrap Themes" width="700" height="500" loading="lazy">
          </div>
          <div class="col-lg-6">
            <h1 class="display-5 fw-bold lh-1 mb-3">Responsive left-aligned hero with image</h1>
            <p class="lead">Quickly design and customize responsive mobile-first sites with Bootstrap, the world’s most popular front-end open source toolkit, featuring Sass variables and mixins, responsive grid system, extensive prebuilt components, and powerful JavaScript plugins.</p>
            <div class="d-grid gap-2 d-md-flex justify-content-md-start">
              <button type="button" class="btn btn-primary btn-lg px-4 me-md-2">Primary</button>
              <button type="button" class="btn btn-outline-secondary btn-lg px-4">Default</button>
            </div>
          </div>
        </div>
      </div>
      <hr>
    </main>
    
    <footer class="blog-footer">
      <p>Blog template built for <a href="https://getbootstrap.com/">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.</p>
      <p>
        <a href="#">Back to top</a>
      </p>
    </footer>
    </body>
</html>