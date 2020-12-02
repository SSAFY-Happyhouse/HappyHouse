<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
		<style type="text/css">
			body {
				width: 100% !important;
				margin: 0;
				font-family: 'Noto Sans KR', sans-serif;
				color: #0d0d0d;
			}
			
			.container-custom {
				width: 100%;
			}
			
			.content {
				width: 1200px;
				margin: 0 auto;
				display: flex;
			}	
		</style>
	</head>
	<body>
		<div class="container-custom">
			<%@ include file="../common/header.jsp" %>
			<div class="content">
			<div class="container" align="center">
			<br><br>
	<div class="col-lg-6" align="center">
		<h2><strong>회원정보</strong></h2>
		<form id="memberform" method="post" action="">
		<input type="hidden" name="act" id="act" value="">
		<br>
			<div class="form-group" align="left">
				<label for="name">이름</label>
				<input type="text" class="form-control" id="username" name="username" placeholder="" value="${userinfo.username}" readonly="readonly">
			</div>
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="userid" name="userid" placeholder="" value="${userinfo.userid}" readonly="readonly">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="userpwd" name="userpwd" placeholder="" value="${userinfo.userpwd}" readonly="readonly">
			</div>
			<div class="form-group" align="left">
				<label for="email">이메일</label><br>
				<div id="email" class="custom-control-inline">
				<input type="text" class="form-control" id="emailid" name="emailid" placeholder="" size="25" value="${userinfo.email}" readonly="readonly">
				</div>
			</div>
			<div class="form-group" align="left">
				<label for="tel">전화번호</label><br>
				<div id="tel" class="custom-control-inline">
				<input type="text" class="form-control" id="tel" name="tel" placeholder="" value="${userinfo.tel}" readonly="readonly">
				</div>
			</div>
			<div class="form-group" align="left">
				<label for="">주소</label><br>
				<input type="text" class="form-control" id="address" name="address" placeholder="" value="${userinfo.address}" readonly="readonly">
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-primary" onclick="location.href='${root}/modify.do?userid=${userinfo.userid}'">수정</button>
				<button type="button" class="btn btn-danger" onclick="location.href='${root}/delete.do?userid=${userinfo.userid}'">탈퇴</button>
			</div>
		</form>
	</div>
</div>

			</div>
			<br><br><br>
			<%@ include file="../common/footer.jsp" %>
		</div>
	</body>
</html>