<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>
<link href="https://webfontworld.github.io/suseong/SuseongBatang.css"
	rel="stylesheet">


<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'SuseongBatang';
}

html {
	position: relative;
	min-height: 100%;
	margin: 0;
	padding-bottom: 100px;
}

.common_header {
	position: fixed;
	top: 0;
	left: 0;
	height: 150px;
	width: 100%;
	border: 1px solid;
	z-index: 999;
	background-color: #000;
}

.common_container_wrap {
	margin-top: 150px;
}

/* 컨테이너 보이기 */
.common_header div,ul,li{
	display: inline-block;
}


#common_logo_image {
	margin-top: -35px;
}

/* 로고 위치 조정 */
.common_logo {
	/*             border: 1px solid red; */
	
}

@media all and (max-width:1165px) {
	.common_navbar_menu>ul {
		display: none;
	}
}

.common_navbar_menu {
	font-size: 35px;
	margin-left: 9%;
	/*             border: 1px solid red; */
}

.common_navbar_menu li {
	margin-left: 80px
}

.common_navbar_menu p {
	color: #fff;
}

.common_navbar_login {
	color: #fff;
	float: right;
	font-size: 20px;
}

.common_navbar_login>ul>li {
	margin-left: 20px;
}



.common_footer {
	position: absolute;
	bottom: 0;
	left: 0;
	height: 100px;
	width: 100%;
	/*             border: 1px solid red; */
	background-color: #000;
}

.footer_text {
	font-size: 20px;
	font-weight: bold;
	color: #fff;
	text-align: center;
	margin-top: 35px;
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
	padding: 10px 15px;
	border-radius: 100%;
}

.btn_gotop:hover .glyphicon {
	color: white;
}

.btn_gotop:hover {
	background-color: #000;
}

.chatbot_icon {
	display: block;
	position: fixed;
	bottom: 85px;
	right: 30px;
	z-index: 999;
}

.chatbot_icon_img {
	width: 50px;
	transition-duration: 0.3s;
}

.chatbot_icon_img:hover {
	transform: scale(1.15);
	transition: all 0.3s
}
</style>

<script type="text/javascript">
	//top 버튼 쿼리
	$(document).ready(function() {
		$(window).scroll(function() {
			if ($(this).scrollTop() > 100) {
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

	//chatbot 쿼리
</script>


</head>

<body>

	<div class="common_header">
		<div class="common_navbar_logo">
			<ul>
				<li class="common_logo"><img id="common_logo_image"
					src="/Culture/images/Intro/header/logo.png"></li>
			</ul>
		</div>
		<div class="common_navbar_menu">
			<ul>
				<li>
					<p>Culutre DB</p>
				</li>
				<li>
					<p>Community</p>
				</li>
			</ul>
		</div>
		<div class="common_navbar_login">
			<ul>
				<li>
					<p>로그인</p>
				</li>
				<li>
					<p>회원가입</p>
				</li>
			</ul>
		</div>
	</div>

	<!---------------------------------- 컨테이너 영역 ---------------------------------->
	<div class="common_container_wrap">
		<div class="common_container">
			<!-- <h1>컨테이너 영역입니다.</h1>
			<h1>일정 스크롤이상 내려가면 탑버튼이 보입니다. (챗봇아이콘 아래)</h1>
			<h1>아직 미완성입니다. (메뉴 호버출력 / 로그인 회원가입 추가)</h1>
			<h1>헤더의 높이는 150px입니다. 컨테이너가 가려지지 않기위해서는 margin-top:150px 넣으세요</h1> -->
		</div>
	</div> 
	<!---------------------------------- 컨테이너 영역 ---------------------------------->

	<div class="common_footer">
		<p class="footer_text">made by 1조 주병훈 김한나 권순헌 최근혁 김형규 민유성
		<p>
	</div>

	<!-- chat bot 아이콘 -->
	<a href="#" class="chatbot_icon"> <span class="chatbot_icon">
			<img class="chatbot_icon_img" src="/Culture/images/Intro/header/chatbot.png">
	</span>
	</a>

	<!-- top 버튼-->
	<a href="#" class="btn_gotop btn-lg"><span
		class="glyphicon glyphicon-chevron-up"></span> </a>


</body>
</html>
    