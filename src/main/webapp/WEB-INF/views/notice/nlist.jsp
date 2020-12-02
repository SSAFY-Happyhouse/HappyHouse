<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<style type="text/css">
body {
	margin: 0;
	font-family: 'Noto Sans KR', sans-serif;
	color: #0d0d0d;
}

.container-custom {
	width: 100%;
}

.content-notice {
	width: 1200px;
	margin: 0 auto;
	display: flex;
	flex-direction: column;
	align-items:center;
}

.table-custom {
	width: 100%;
	border-collapse: collapse;
	table-layout: fixed;
	
}			

td {
	text-align: center;
	font-size: 14px;
}

tr.exline td {
	border-bottom: solid 1px #dfdfdf;
	height: 48px;
}

th {
	border-top: solid 1px #858585;
	border-bottom: solid 1px #858585;
	height: 48px;
	color: #3b3b3b;
	font-size: 14px;
	text-align: center;
	background: #7ccfec;
}
</style>
</head>
<body>
	<%@ include file="../common/header.jsp" %>
	<div class="container-custom">
		<div class="content-notice">
		<br><br>
			<h2><strong>공지사항</strong></h2>
			<button style="margin-left: auto;" type="button" class="btn btn-primary" onclick="location.href='${root}/write.do'">글쓰기</button>
			<br>
			<c:if test="${notices != null}">
				<table class="table-custom">
					<tr>
						<th width="20%">제목</th>
						<th width="20%">작성자</th>
						<th width="20%">등록일</th>
						<th width="20%">조회수</th>
						<th width="20%">상세보기</th>
					</tr>
					<c:forEach var="notice" items="${notices}">
						<tr class="exline">
							<td>${notice.subject}</td>
							<td>${notice.userid}</td>
							<td>${notice.regtime}</td>
							<td>${notice.count}</td>
							<td><a href="read.do?num=${notice.num}">상세보기</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<br><br><br><br>
		</div>
	</div>
	<%@ include file="../common/footer.jsp" %>
</body>
</html>