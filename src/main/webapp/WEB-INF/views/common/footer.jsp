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
			
			.container-custom {
				width: 100%;
			}
			
			.content {
				width: 1200px;
				margin: 0 auto;
				display: flex;
			}
			
			footer {
				border-top: solid 1px #cccccc;
				clear: both; /* float 속성 무효화 */
				display: flex;
				align-items: center;
				flex-direction: column;
			}
			
			footer .content {
				align-items: center;
				min-height: 52px;
			}

			footer .logo {
				font-size: 18px;
				cursor: pointer;
				font-weight: bold;
				margin-right: 40px;
			}
			
			footer .menu {
				font-size: 12px;
				color: #5e5e5e;
				padding: 0 16px;
				border-right: solid 1px #dfdfdf;
				height: 14px;
				line-height: 14px;
				cursor: pointer;
			}
			
			footer .menu:last-child {
				border: 0px;
			}
			
			footer .rights {
				font-size: 11px;
				color: #5e5e5e;
				border-top: solid 1px #ececec !important;
				margin-bottom: 40px;
				padding-top: 16px;
				line-height: 18px;
				width: 100%;
			}
			
		</style>
	</head>
	<body>
		<div class="container-custom">
			<footer>
				<div class="content">
					<div class="logo">HAPPYHOUSE</div>
					<div class="menu">소개</div>
					<div class="menu">개발자</div>
					<div class="menu">참고</div>
				</div>
				<div class="rights">
					<div class="content text">
						개발자: 이계웅 | 우주호<br>
						도움 : 김채은 <br>
						<br><br>
						ⓒ 2020 HAPPYHOUSE All Rights Reserved.
					</div>
				</div>
			</footer>
		</div>
	</body>
</html>