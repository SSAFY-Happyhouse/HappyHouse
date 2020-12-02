<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

.container {
	width: 100%;
}

.content {
	width: 1200px;
	margin: 0 auto;
	display: flex;
}

.table-custom {
	width: 60%;
	border-collapse: collapse;
	table-layout: fixed;
}			

td {
	text-align: center;
	font-size: 14px;
}

tr.exline td {
	border-top: solid 1px #dfdfdf;
	border-bottom: solid 1px #dfdfdf;
	border-left: solid 1px #dfdfdf;
	border-right: solid 1px #dfdfdf;
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
	<div class="container">
		<%@ include file="../common/header.jsp"%>
		<center>
			<h1>상세 정보</h1>
			<p>
			<TABLE class="table-custom">
				<TR class="exline">
					<TH WIDTH=200>번호</TH>
					<TD width=300 align=center>${b.no}</TD>
					<TH WIDTH=300>법정 동명</TH>
					<TD width=300 align=center>${b.dong}</TD>
				</TR>
				<TR class="exline">
					<TH WIDTH=200>아파트 이름</TH>
					<TD width=300 align=center>${b.aptName}</TD>
					<TH WIDTH=300>법정 동코드</TH>
					<TD width=300 align=center>${b.code}</TD>
				</TR>
				<TR class="exline">
					<TH WIDTH=200>거래 금액</TH>
					<TD width=300 align=center>${b.dealAmount}</TD>
					<TH WIDTH=300>건축 연도</TH>
					<TD width=300 align=center>${b.buildYear}</TD>
				</TR>
				<TR class="exline">
					<TH WIDTH=200>거래 연도</TH>
					<TD width=300 align=center>${b.dealYear}</TD>
					<TH WIDTH=300>거래 월</TH>
					<TD width=300 align=center>${b.dealMonth}</TD>
				</TR>
				<TR class="exline">
					<TH WIDTH=200>거래 일</TH>
					<TD width=300 align=center>${b.dealDay}</TD>
					<TH WIDTH=300>전용면적</TH>
					<TD width=300 align=center>${b.area}</TD>
				</TR>
				<TR class="exline">
					<TH WIDTH=200>층</TH>
					<TD width=300 align=center>${b.floor}</TD>
					<TH WIDTH=300>지번</TH>
					<TD width=300 align=center>${b.lat}${b.lng} ${b.jibun}</TD>
				</TR>
				<TR class="exline">
					<TH WIDTH=200>타입</TH>
					<c:if test="${b.type == 1 }">
						<TD width=300 align=center>아파트 매매</TD>
					</c:if>
					<c:if test="${b.type == 2 }">
						<TD width=300 align=center>아파트 전월세</TD>
					</c:if>
					<c:if test="${b.type == 3 }">
						<TD width=300 align=center>다세대 주택 매매</TD>
					</c:if>
					<c:if test="${b.type == 4 }">
						<TD width=300 align=center>다세대 주택 전월세</TD>
					</c:if>
					<TH WIDTH=300>거래금액</TH>
					<TD width=300 align=center>${b.rentMoney}</TD>
				</TR>				
			</TABLE>
			<!--  <%= application.getContextPath() %>/img/${b.img}-->
			<br>
			<!--<img src="./img/${b.aptName}.jpg" onerror="javascript:this.src='./img/다세대주택.jpg';">-->
			<br> <br>
		</center>
		<%@ include file="../common/footer.jsp"%>
		</div>
</body>
</html>



