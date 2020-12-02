<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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

aside {
	width: 376px;
	margin: 40px 0;
	padding: 24px;
	border-radius: 6px;
	border: solid 1px #dfdfdf;
	box-shadow: 0 3px 7px 0 rgba(0, 0, 0, 0.02);
}

aside .title {
	margin-top: 48px;
	font-size: 18px;
	font-weight: bold;
}

aside img {
	width: 280px;
	height: 280px;
	object-fit: cover;
	display: block;
	margin: 0 auto;
}

aside .text {
	margin-top: 32px;
	font-size: 16px;
}

section {
	margin: 40px 0 40px 32px;
	width: 792px;
}

section .subject {
	margin-bottom: 25px;
	font-size: 18px;
	font-weight: bold;
}

section .articles {
	margin-bottom: 80px;
}

section .article {
	margin-bottom: 16px;
	width: 100%;
	height: 84px;
	border-bottom: solid 1px #dfdfdf;
	cursor: pointer;
}

section .title {
	font-size: 16px;
	font-weight: bold;
}

section .text {
	margin-top: 4px;
	font-size: 12px;
	color: #5e5e5e;
}

section table {
	width: 100%;
	border-collapse: collapse;
}

section td {
	text-align: center;
	font-size: 14px;
}

section td:first-child {
	text-align: left;
}

section tr.exline td {
	border-bottom: solid 1px #dfdfdf;
	height: 48px;
	cursor: pointer;
}

section th {
	border-top: solid 2px #858585;
	border-bottom: solid 1px #858585;
	height: 48px;
	color: #4b4b4b;
	font-size: 14px;
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

</style>
</head>
<body>
	<%@ include file="common/header.jsp"%>
	<div class="container-custom">
		<div class="content-notice">
		<center>
			<script>
					$(document).ready(
							function() {
								$.get("${pageContext.request.contextPath}/index", {
									command : "sido"
								}, function(data, status) {
									$.each(data, function(index, vo) {
										$("#sido").append(
												"<option value='"+vo.sido_code+"'>"
														+ vo.sido_name
														+ "</option>");
									});//each
								}//function
								, "json");//get
							});//ready
				$(document).ready(function(){
					$("#sido").change(function() {
						$.get("${pageContext.request.contextPath}/index"
								,{command:"gugun", sido:$("#sido").val()}
								,function(data, status){
									$("#gugun").empty();
									$("#gugun").append('<option value="0">선택</option>');
									$.each(data, function(index, vo) {
										$("#gugun").append("<option value='"+vo.gugun_code+"'>"+vo.gugun_name+"</option>");
									});//each
								}//function
								, "json"
						);//get
					});//change
					$("#gugun").change(function() {
						$.get("${pageContext.request.contextPath}/index"
								,{command:"dong", gugun:$("#gugun").val()}
								,function(data, status){
									$("#dong").empty();
									$("#dong").append('<option value="0">선택</option>');
									$.each(data, function(index, vo) {
										$("#dong").append("<option value='"+vo.dong+"'>"+vo.dong+"</option>");
									});//each
								}//function
								, "json"
						);//get
					});//change
					$("#dong").change(function() {
						$("tbody").empty();
						initMap();
						$.get("${pageContext.request.contextPath}/index"
								,{command:"apt", dong:$("#dong").val()}
								,function(data, status){
									$.each(data, function(index, vo) {
										let str = "<tr class=exline>"
										+ "<td>" + vo.no + "</td>"
										+ "<td>" + vo.dong + "</td>"
										+ "<td>" + vo.AptName + "</td>"
										+ "<td>" + vo.jibun + "</td>"
										+ "<td>" + vo.code
										+ "</td><td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
										
										$("tbody").append(str);
										
										//$("#searchResult").empty();
										//$("#searchResult").append(vo.dong+" "+vo.AptName+" "+vo.jibun+"<br>");
									});//each
									geocode(data);
								}//function
								, "json"
						);//get
					});//change
				});//ready
				function geocode(jsonData) {
					
					let idx = 0;
					$.each(jsonData, function(index, vo) {
						let tmpLat;
						let tmpLng;
						$.get("https://maps.googleapis.com/maps/api/geocode/json"
								,{	key:''
									, address:vo.dong+"+"+vo.AptName+"+"+vo.jibun
								}
								, function(data, status) {
									//alert(data.results[0].geometry.location.lat);
									tmpLat = data.results[0].geometry.location.lat;
									tmpLng = data.results[0].geometry.location.lng;
									$("#lat_"+index).text(tmpLat);
									$("#lng_"+index).text(tmpLng);
									addMarker(tmpLat, tmpLng, vo.AptName);
								}
								, "json"
						);//get
					});//each
				}
			</script>
			시도 : <select id="sido">
				<option value="0">선택</option>
			</select>
			 구군 : <select id="gugun">
				<option value="0">선택</option>
			</select>
			읍면동 : <select id="dong">
				<option value="0">선택</option>
			</select>
			<br>
			<br>
			<div id="map" style="width: 80%; height: 400px; margin: auto;"></div>
		<script src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
		<script async defer src="https://maps.googleapis.com/maps/api/js?key=&callback=initMap"></script>
		<script>
			var multi = {lat: 37.5665734, lng: 126.978179};
			var map;
			function initMap() {
				map = new google.maps.Map(document.getElementById('map'), {
					center: multi, zoom: 12
				});
				var marker = new google.maps.Marker({position: multi, map: map});
			}
			function addMarker(tmpLat, tmpLng, aptName) {
				
				var marker = new google.maps.Marker({
					position: new google.maps.LatLng(parseFloat(tmpLat),parseFloat(tmpLng)),
					label: aptName,
					title: aptName
				});
				marker.addListener('click', function() {
					map.setZoom(17);
					map.setCenter(marker.getPosition());
				});
				marker.setMap(map);
			}
			</script>
			<br>
			<table class="table-custom">
					<thead>
						<th width="10%">번호</th>
						<th width="10%">법정동</th>
						<th width="10%">아파트이름</th>
						<th width="10%">지번</th>
						<th width="10%">지역코드</th>
						<th width="10%">위도</th>
						<th width="10%">경도</th>
					</thead>
					<tbody>
					</tbody>
				</table>
		</center>
	</div>
	</div>
	<br>
	<br>
		<%@ include file="common/footer.jsp"%>
</body>
</html>