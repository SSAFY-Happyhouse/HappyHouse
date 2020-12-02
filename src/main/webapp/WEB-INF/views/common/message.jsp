<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Insert title here</title>
		<meta charset="utf-8">
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
			<br><br><br>
			<center>${msg}</center>
			<br><br><br>
			<%@ include file="../common/footer.jsp" %>
		</div>
	</body>
</html>