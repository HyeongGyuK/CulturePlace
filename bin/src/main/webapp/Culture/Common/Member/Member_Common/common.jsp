<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
 	// contextPath : 해당 애플리케이션의 이름(=컨덱스트 이름)
 	String contextPath = request.getContextPath();
 
 	// 서블릿 매핑 이름
 	String mapping = "/Bakery";
 	// url 패턴
 
 	// 폼 태그에서 사용할 공용 변수
 	String yesForm = contextPath+mapping;

 	// 폼이 없는 <a>,<img> 태그에서 사용할 공용 변수
 	String noForm=contextPath+mapping+"?command=";
%>
<c:set var="whologin" value="0" /> 
<!-- empty 는 값이 있는지 없는지 확인할 때 사용 -->
<c:if test="${not empty sessionScope.loginfo}">
	<c:if test="${sessionScope.loginfo.id =='admin'}">
		<c:set var="whologin" value="2"/>
	</c:if>
	<c:if test="${sessionScope.loginfo.id !='admin'}">
		<c:set var="whologin" value="1"/>
	</c:if>
	<c:if test="${sessionScope.loginfo.id ==null}">
		<c:set var="whologin" value="0"/>
	</c:if>
</c:if>
<%
 	int twelve = 12; //for Bootstrap
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Insert title here</title>
		
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
		
		<style type="text/css">
		@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@300&display=swap');
		*{font-family: 'Noto Sans KR',sans-serif;}
			* {
				margin: 0;
				padding: 0;
				scroll-behavior: smooth;
			}
			
			body {
				min-height: 100%;
			}
			
			.row {
				height: 265px;
			}
			
			#mainLogo {
				margin-top: 15px;
				width: 200px;
				height: 200px;
			}
			
			#mainLogo:hover {
				transform: rotate(-10deg);
			}
			
			#mainLogo2 {
				margin-top: 15px;
				width: 350px;
				height: 50px;
			}
			
			.right_menu_div {
				position: relative;
				display: inline-block;
				vertical-align: baseline;
				top: 50%;
				margin-right: 100px;
			}
			
			.right_menu {
				font-size: 16px;
			}
			
			#logoImg {
				display: inline_block;
				text-align: center;
			}
			
			.main_header {
				display: block;
				position: relative;
				text-align: center;
			}
			
			.navbarClass {
				font-size: 20px;
				margin-right: 140px;
				color: #FFFFFF;
			}
			
			.navbar-collapse {
				float: none;
				display: inline-block;
				vertical-align: top;
				padding-left: 0;
				padding-right: 0;
			}
			
			.right_menu_div {
				position: absolute;
				right: 0;
			}
			
			.right_menu:hover{
				text-decoration: none;
			}
			#logomungu {
				text-align: center;
				margin-top: 200px;
			}
			
			#navDiv {
				border-top: 1px solid #000000;
				border-bottom: 1px solid #000000;
				background-color: #551527;
			}
			
			.navbar-nav>li>a:hover, .navbar-nav>li>a:focus {
				color: #FFFFFF;
				background-color: rgb(83, 61, 40);
			}
			
			.btn_gotop {
				display: none;
				position: fixed;
				bottom: 30px;
				right: 30px;
				z-index: 999;
				border: 1px solid #ccc;
				outline: none;
				background-color: white;
				color: #333;
				cursor: pointer;
				padding: 15px 20px;
				border-radius: 100%;
			}
			
			.btn_gotop:hover .glyphicon {
				color: white;
			}
			
			.btn_gotop:hover {
				background-color: #6a1e28;
			}
			
			html {
				position: relative;
				min-height: 100%;
				margin: 0;
				padding-bottom: 100px;
			}
			
			#footer01 {
				background-color: #252525;
				color: #ccc;
				width: 100%;
				height: 300px;
			}
			
			.foot01 {
				list-style: none;
				text-align: center;
			}
			
			.foot01_1 {
				display: inline-block;
			}
			
			#foot01_1_1:before {
				content: ' \2223';
			}
			
			#foot01_1_2:before {
				content: ' \2223';
			}
			
			#footer04 {
				width: 100%;
				height: 50px;
				align: center;
			}
			
			#footer {
				width: 100%;
				height: 100px;
				position: absolute;
				bottom: 0;
				left: 0;
			}
			
			#footer02 {
				padding-top: 13px;
			}
			
			#footer03 {
				text-align: center;
				width: 100px;
				hight: 100px;
			}
			
			#footer03_1 {
				text-align: center;
				width: 150px;
				hight: 150px;
				margin-bottom: 30px;
			}
		</style>
		
		<script type="text/javascript">
			$(document).ready(
					function() {
						$('.dropdown-toggle-board').mouseover(
								function() {
									$('.dropdown-toggle-board').next(
											'.dropdown-menu').show();
								});

						$('.dropdown-toggle-board').mouseout(
								function() {
									t = setTimeout(function() {
										$('.dropdown-toggle-board').next(
												'.dropdown-menu').hide();
									}, 100);

									$('.dropdown-toggle-board').next(
											'.dropdown-menu').on(
											'mouseenter',
											function() {
												$('.dropdown-toggle-board')
														.next('.dropdown-menu')
														.show();
												clearTimeout(t);
											}).on(
											'mouseleave',
											function() {
												$('.dropdown-toggle-board')
														.next('.dropdown-menu')
														.hide();
											})
								});

						$('.dropdown-toggle-product').mouseover(
								function() {
									console.log($('.dropdown-toggle-product')
											.children('.dropdown-menu'));
									$('.dropdown-toggle-product').next(
											'.dropdown-menu').show();
								});

						$('.dropdown-toggle-product').mouseout(
								function() {
									t = setTimeout(function() {
										$('.dropdown-toggle-product').next(
												'.dropdown-menu').hide();
									}, 100);

									$('.dropdown-toggle-product').next(
											'.dropdown-menu').on(
											'mouseenter',
											function() {
												$('.dropdown-toggle-product')
														.next('.dropdown-menu')
														.show();
												clearTimeout(t);
											}).on(
											'mouseleave',
											function() {
												$('.dropdown-toggle-product')
														.next('.dropdown-menu')
														.hide();
											})
								});
		<%-- top 버튼 쿼리 --%>
				$(document).ready(function() {
					$(window).scroll(function() {
						if ($(this).scrollTop() > 200) {
							$('.btn_gotop').show();
						} else {
							$('.btn_gotop').hide();
						}
					});
					$('.btn_gotop').click(function() {
						$('html, body').animate({
							scrollTop : 0
						}, 50);
						return false;
					});
				});
			});
		</script>
	</head>
	
	<body>

		<footer id="footer">
		<div id="footer01" align="center">
			<div id="footer02">
				<img id="footer03" src="<%=contextPath %>/images/logo/Bbanglogo_white.png" alt="(주)문화예술정보">
				<img id="footer03_1" src="<%=contextPath %>/images/logo/logomungu_white.png"
					alt="(주)문화예술정보">
			</div>
			<div id="footer04">
				<ul class="foot01">
					<li class="foot01_1">개인정보취급방침&nbsp;</li>
					<li id="foot01_1_1" class="foot01_1">&nbsp;이용약관&nbsp;</li>
					<li id="foot01_1_2" class="foot01_1">&nbsp;이메일부단수집거부</li>
				</ul>
			</div>
			<div>
				<ul class="foot01">
					<li class="foot01_1">(주)문화예술정보</li>
					<li id="foot01_1_1" class="foot01_1">대표 : 1조</li>
					<li id="foot01_1_2" class="foot01_1">사업자등록번호 : 347-09-00431</li>
				</ul>
			</div>
			<div>
				<ul class="foot01">
					<li class="foot01_1">주소 : 서울시 금천구 가산동 112 (주)문화예술정보</li>
					<li id="foot01_1_1" class="foot01_1">대표번호:010-4154-4954</li>
				</ul>
			</div>
			<div>
				<ul class="foot01">
					<li class="foot01_1">팩스번호 : 02-123-4567</li>
					<li id="foot01_1_1" class="foot01_1">개인정보관리책임자 : 김형규</li>
				</ul>
			</div>
			<P>Copyrightⓒ2022 BBANGCCASSO.ALL Rights Reserved.</P>
			<P>Design by DoenKim</P>
		</div>
	</footer>
		
		<%-- top 버튼 --%>
		<a href="#" class="btn_gotop btn-lg"><span
					class="glyphicon glyphicon-chevron-up"></span>
		</a>
		
	</body>
	
</html>