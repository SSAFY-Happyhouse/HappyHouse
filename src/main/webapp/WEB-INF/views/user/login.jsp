<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<c:if test="${cookie.ssafy_id.value ne null}">
	<c:set var="saveid" value="${cookie.ssafy_id.value}"/>
	<c:set var="idck" value=" checked=\"checked\""/>
</c:if>
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
		<style type="text/css">
			body {
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
<script type="text/javascript">
function login() {
	if(document.getElementById("userid").value == "") {
		alert("아이디 입력!!!");
		return;
	} else if(document.getElementById("userpwd").value == "") {
		alert("비밀번호 입력!!!");
		return;
	} else {
		document.getElementById("loginform").action = "${root}/loginProcess.do";
		document.getElementById("loginform").submit();
	}
}
</script>
</head>
<body>

<div class="container-custom">
<%@ include file="../common/header.jsp" %>
<div class="container" align="center">
	<div class="col-lg-6" align="center">
	<br><br>
	<h2><strong>로그인</strong></h2>
		<form id="loginform" method="post" action="">
		<input type="hidden" name="act" id="act" value="login">
		<br>
			<div class="form-group" align="left">
				<label for="">아이디</label>
				<input type="text" class="form-control" id="userid" name="userid" placeholder="" value="${saveid}">
			</div>
			<div class="form-group" align="left">
				<label for="">비밀번호</label>
				<input type="password" class="form-control" id="userpwd" name="userpwd" placeholder="" onkeydown="javascript:if(event.keyCode == 13) {login();}">
			</div>
			<div class="form-group form-check" align="right">
			    <label class="form-check-label">
			      <input class="form-check-input" type="checkbox" id="idsave" name="idsave" value="saveok"${idck}> 아이디저장
			    </label>
			</div>
			<div class="form-group" align="center">
				<button type="button" class="btn btn-warning" onclick="javascript:login();">로그인</button>
			</div>
		</form>
		<br><br>
	</div>
	</div>
<%@ include file="../common/footer.jsp" %>
</div>
