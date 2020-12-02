<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap"
	rel="stylesheet">
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
	<div class="container-custom">
		<div class="content-notice">
	<center>
	<c:if test="${list.size() == 0}">
	검색 결과가 없습니다.
	</c:if>
	<c:if test="${list.size() != 0 && list != null}">
		<table class="table-custom">
			<tr>
				<th width=200 >번호</th>
				<th width=200 >동</th>
				<th width=200 >아파트이름</th>
				<th width=200 >거래금액</th>
				<th width=200 >거래종류</th>
			</tr>
				<c:forEach items="${list}" var="b">
					<tr class="exline">
						<td align=center >&nbsp;<font size=2><a href="detail.do?no=${b.no}">${b.no}</a></td>
						<td align=center >&nbsp;<font size=2>${b.dong}</td>
						<td align=center >&nbsp;<font size=2>${b.aptName}</td>
						<td align=center >&nbsp;<font size=2>${b.dealAmount}</td>
						<c:if test="${b.type == 1 }">
							<td align=center >&nbsp;<font size=2>아파트 매매</td>
						</c:if>
						<c:if test="${b.type == 2 }">
							<td align=center >&nbsp;<font size=2>아파트 전월세</td>
						</c:if>
						<c:if test="${b.type == 3 }">
							<td align=center >&nbsp;<font size=2>다세대,주택 매매</td>
						</c:if>
						<c:if test="${b.type == 4 }">
							<td align=center >&nbsp;<font size=2>다세대,주택 전월세</td>
						</c:if>
					</tr>
				</c:forEach>
		</table>
		</c:if>
		<c:if test="${list == null}">
		유형, 동/아파트 이름으로 검색해주세요.
		</c:if>
			</div>
	</div>
		<!-- 
		<br><br><br> <a href="index.do">메인페이지</a>
		<br><br><br>
		 -->
	</center>
</body>
</html>



