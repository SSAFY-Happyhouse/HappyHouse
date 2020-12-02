<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		</style>
	</head>
<body>
<div class="container">
<%@ include file="../common/header.jsp" %>
	<form method='get' action='list.do' id="form">
	<input type="hidden" name="pageNo" value="1" id="pageNo">
			<center>
			<br>
				<h1>실거래가 검색</h1>
				<label><input type="checkbox" name="type" value="0" ${housePageBean.searchType[0] ? 'checked' : ''}> 아파트 매매</label>
      			<label><input type="checkbox" name="type" value="1" ${housePageBean.searchType[1] ? 'checked' : ''}> 아파트 전월세</label>
      			<label><input type="checkbox" name="type" value="2" ${housePageBean.searchType[2] ? 'checked' : ''}> 다세대,주택 매매</label>
      			<label><input type="checkbox" name="type" value="3" ${housePageBean.searchType[3] ? 'checked' : ''}> 다세대,주택 전월세</label>
      			<br>
				<select name="select">
					<option value="동" ${"동" == select ? 'selected' : ''}>동</option>
					<option value="아파트" ${"아파트" == select ? 'selected' : ''}>아파트</option>
				</select> <input type=input name='name' value="${name}"> <input type=submit value=검색>
			</center>
	</form><br><br>
	<jsp:include page="list.jsp"/>
			<br><br>
	<div id="pagination" align="center">
	<c:if test="${!pagination.isFirstPageGroup}">
	<a href="javascript:search(1);">맨처음</a>&nbsp;&nbsp;
	<a href="javascript:search(${pagination.currentGroupFirstPage-pagination.pageGroupSize});">이전</a>&nbsp;&nbsp;
	</c:if>&nbsp;&nbsp;
	<c:if test="${pagination.currentGroupFirstPage != null}">
		<c:forEach var="page" begin="${pagination.currentGroupFirstPage}" end="${pagination.currentGroupLastPage}" step="1">
			<a style="${pagination.currentPage == page ? 'font-weight:bold' : ''}" href="javascript:search(${page});">${page}</a>&nbsp;&nbsp;
		</c:forEach>&nbsp;&nbsp;
	</c:if>
	<c:if test="${pagination.currentGroupFirstPage == null}">
		<a style="font-weight:bold;" href="javascript:search(1);">1</a>&nbsp;&nbsp;
	</c:if>
	<c:if test="${!pagination.isLastPageGroup}">
	&nbsp;&nbsp;<a href="javascript:search(${pagination.currentGroupLastPage+1});">다음</a>
	&nbsp;&nbsp;<a href="javascript:search(${pagination.totalPageCount});">맨끝</a>
	</c:if>
	</div>
	<br><br>
<%@ include file="../common/footer.jsp" %>
</div>
<script type="text/javascript">
function search(pageNo) {
	document.getElementById("pageNo").value = pageNo;
	document.getElementById("form").submit();
}
</script>
<style>
#pagination a {
	color: #444;
	text-decoration:none;
	border: solid 1px #e8e8e8;
	border-radius: 4px;
	padding: 4px 12px;
}
</style>
</body>
</html>