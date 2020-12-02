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
		<script type="text/javascript">
		$(document).ready(function() {
			$("#registerBtn").click(function() {
				if($("#subject").val() == "") {
					alert("글 제목을 입력해주세요.");
					return;
				} else if($("#content").val() == "") {
					alert("글 내용을 입력해주세요.");
					return;
				} else {
					$("#noticeform").attr("action", "${root}/writeProcess.do").submit();
				}
			});
		});
		</script>
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
	<div class="col-lg-8" align="center">
		<h2><strong>글작성</strong></h2>
		<form id="noticeform" method="post" action="">
		<input type="hidden" name="act" id="act" value="">
		<br>
			<div class="form-group" align="left">
				<label for="name">제목</label>
				<input type="text" class="form-control" id="subject" name="subject" placeholder="">
			</div>
			<div class="form-group" align="left">
				<label for="">내용</label>
				<textarea class="form-control" rows="15" cols="1" id="content" name="content"></textarea>
			</div>
			<br>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-primary" id="registerBtn">확인</button>&nbsp;&nbsp;
				<button type="reset" class="btn btn-warning">초기화</button>
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