<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
		<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
		<style type="text/css">
			body {
				margin: 0;
				font-family: 'Noto Sans KR', sans-serif;
				color: black;
			}
			
			.container-custom {
				width: 100%;
			}
			
			.content {
				width: 1200px;
				margin: 0 auto;
				display: flex;
			}
			
			.logo a {
				color: black;
				text-decoration: none;
			}
			
			.menu a {
				color: black;
				text-decoration: none;
			}
			
			header {
				height: 64px;
				line-height:64px;
				background: #7ccfec;
				display: flex;
			}
			
			header .logo {
				font-size: 22px;
				color: black;
				cursor: pointer;
				font-weight: bold;
				margin-right: 72px;
			}
			
			header .menu {
				padding: 0 6px;
				text-size: 16px;
				color: white;
				cursor: pointer;
			}
			
			header .left {
				margin-right: 32px;
			}
			
			header .right {
				margin-left: 32px;
			}
			
			header .empty {
				flex-grow: 1;
			}			
		</style>
	</head>
	<body>
		<div class="container-custom">
			<header>
				<div class="content">
					
					<div class="logo"><a href="http://localhost:9090/boot/">HAPPYHOUSE</a></div>

					<div class="empty"></div>
					<div class="menu right"><a href="search.do">실거래정보</a></div>
					<div class="menu right"><a href="nlist.do">공지사항</a></div>
					<div class="menu right"><a href="QnA.do">Q & A</a></div>
					<!--<div class="menu right"><a href="googleMap.do">지도 검색</a></div>-->
					
					<c:if test="${userinfo == null}">
					<div class="menu right"><a href="join.do">회원가입</a></div>
					<div class="menu right"><a href="login.do">로그인</a></div>
					</c:if>
					<c:if test="${userinfo != null}">
					<div class="menu right"><a href="logout.do">로그아웃</a></div>
					<div class="menu right"><a href="userInfo.do">회원정보</a></div>
					</c:if>
				</div>
			</header>
		</div>
		<center>
			<img src="images/happyhouse.png" width="600" height="250" class="img-fluid" alt="Responsive image"></<img>
		</center>
		
	</body>
</html>