<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
					<%-- 로그인이 되어있지 않다면 --%>
					<c:if test="${loginUserInfo eq null }">
						<li><button class="nav-link px-2 link-dark" type="button" name="login" id="login_btn">login</button></li>
						<li><button class="nav-link px-2 link-dark" type="button" name="sign-up" id="sign-up">sign-up</button></li>
						<li><button class="nav-link px-2 link-dark" type="button" name="cart" id="cart">cart</button></li>
						<li><button class="nav-link px-2 link-dark" type="button" name=review id="review">review</button></li>
					</c:if>

					<%-- 로그인이 되어있다면 --%>
					<c:if test="${loginUserInfo ne null }">
						<li><button class="nav-link px-2 link-dark" type="button" name="logout" id="logout">logout</button></li>
						<li><button class="nav-link px-2 link-dark" type="button" name="cart" id="cart">cart</button></li>
						<li><button class="nav-link px-2 link-dark" type="button" name="myPage" id="myPage">myPage</button></li>
						<li><button class="nav-link px-2 link-dark" type="button" name=review id="review">review</button></li>

						<%-- 로그인한 이용자가 관리자일 경우 상품추가 버튼 생성 --%>
						<c:if test="${loginUserInfo.id eq 'admin00'}">
							<li><button class="nav-link px-2 link-dark" type="button" name="product_add"id="product_add">productAdd</button></li>
						</c:if>
					</c:if>
				</ul>
			</div>
		</div>
	</header>
</div>