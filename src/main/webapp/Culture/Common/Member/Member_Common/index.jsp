<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="./common.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		
		<style type="text/css">
			/* .mySlides{position: absolute; z-index: -1;}			 */
/*  			body{background-image: url('./../images/mainImg01.jpg');} */
			.row{margin: 0;}
			#mainLogo{margin-top: 15px; width: 200px; height: 200px;}
			#mainLogo:hover{transform: rotate(-10deg);}
			#mainLogo2{margin-top: 15px; width: 350px; height: 50px;}

			.right_menu_div{position: relative; display: inline-block; vertical-align: baseline; top: 50%; margin-right: 100px;}
			.right_menu{color: #fff; font-size:16px;}
			
			#logoImg{display: inline_block; text-align: center;}
			.main_header{display: block; position: relative; text-align: center;}
			
			.navbarClass{
				color: #FFFFFF;
				font-size: 20px;
				margin-right: 140px;
			}

			.navbar-collapse{
				float:none;
			    display:inline-block;
			    vertical-align: top;
			    padding-left: 0;
			    padding-right: 0;
			}
			
			.right_menu_div{position: absolute; right: 0;}
			
			#logomungu{text-align: center;  margin-top: 200px;}
			#navDiv {
				border-top: 1px solid #000000;
				border-bottom: 1px solid #000000;
				background-color: #551527;
			}
			
			.navbar-nav > li > a:hover,
			.navbar-nav > li > a:focus {
			    color: #FFFFFF;
			    background-color: rgb(83, 61, 40);
			}
			
		</style>
		<style type="text/css">
			.container-fluid{margin: 0;padding: 0;}
			.carousel{width: 100%}
			.slide{position: relative; z-index: 1;}
			.bg{position: absolute; width: 100%; z-index: 2;}
		</style>
		
		<script type="text/javascript">
			$(document).ready(function(){
				if(${requestScope.messagelogin!=null}){
					alert('${requestScope.messagelogin}');
				}
			});
		</script>
	</head>

	<body>
		<div class="container-fluid bg">
			<div class="row">
				<div class="main_header">
	
					<a id="logoImg" href="#">
						<img id="mainLogo" src="<%=contextPath%>/images/logo/Bbanglogo_white.png">
						<img id="mainLogo2" src="<%=contextPath%>/images/logo/logomungu_white.png">
					</a>
					<nav>
						<div class="right_menu_div">
						<c:if test="${whologin==0 }">
							<a class="right_menu" href="<%=noForm%>meLogin"><span
									class="glyphicon glyphicon-log-in"></span> 로그인 </a>
									&nbsp;&nbsp;
							<a class="right_menu" href="<%=noForm%>meInsert"><span
									class="glyphicon glyphicon-user"></span> 회원 가입</a>
						</c:if>
						<c:if test="${whologin==1 }">
							<a class="right_menu" href="<%=noForm%>prList"><span
									class="glyphicon glyphicon-pencil"></span> 마이페이지 </a>
									&nbsp;&nbsp;
							<a class="right_menu" href="<%=noForm%>mallList"><i
									class="fa fa-shopping-cart"></i> 장바구니 </a>
									&nbsp;&nbsp;
							<a class="right_menu" href="<%=noForm%>meLogout"><span
									class="glyphicon glyphicon-log-out"></span> 로그 아웃 </a>
						</c:if>
						<c:if test="${whologin==2 }">
							<a class="right_menu" href="<%=noForm%>adDetail"><span
									class="glyphicon glyphicon-pencil"></span> 관리자 페이지 </a>
									&nbsp;&nbsp;
							<a class="right_menu" href="<%=noForm%>meLogout"><span
									class="glyphicon glyphicon-log-out"></span> 로그 아웃 </a>
						</c:if>
						</div>
					</nav>
				</div>
				<div id="navDiv" class="navbar">
					<div class="container-fluid text-center dropdown">
						<ul class="nav navbar-nav navbar-collapse" id="abc">
							<li class="active nav-item"><a class="navbarClass" href="#">매장 소개</a></li>
							<li class="nav-item">
								<a class="navbarClass dropdown-toggle-product" data-toggle="dropdown" href="#">제품 소개</a>
								<ul class="dropdown-menu">
									<li><a href="<%=noForm %>brBest">Best 메뉴</a></li>
									<li class="divider"></li>
									<li><a href="<%=noForm %>brList">제품 목록</a></li>
								</ul>
							</li>
							<li class="nav-item"><a class="navbarClass" href="<%=noForm%>odclList">Class</a></li>
							<li class="nav-item">
								<a class="navbarClass dropdown-toggle-board" data-toggle="dropdown" href="<%=noForm %>boardFreeMain">Community</a>
								<ul class="dropdown-menu">
									<li><a href="<%=noForm %>boardFreeMain">자유 게시판</a></li>
									<li class="divider"></li>
									<li><a href="<%=noForm %>boardQnaMain">Q&A</a></li>
									<li class="divider"></li>
									<li><a href="<%=noForm %>boardReviewMain">수강 후기</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
				<li data-target="#myCarousel" data-slide-to="5"></li>
			</ol>
			<div class="carousel-inner">
				<div class="item active">
					<img src="<%=contextPath%>/images/mainImg/mainImg01.jpg" alt="main01" style="width: 100%;">
				</div>
				<div class="item">
					<img src="<%=contextPath%>/images/mainImg/mainImg02.jpg" alt="main02" style="width: 100%;">
				</div>
				<div class="item">
					<img src="<%=contextPath%>/images/mainImg/mainImg03.jpg" alt="main03" style="width: 100%;">
				</div>
				<div class="item">
					<img src="<%=contextPath%>/images/mainImg/mainImg04.jpg" alt="main04" style="width: 100%;">
				</div>
				<div class="item">
					<img src="<%=contextPath%>/images/mainImg/mainImg05.jpg" alt="main05" style="width: 100%;">
				</div>
				<div class="item">
					<img src="<%=contextPath%>/images/mainImg/mainImg06.jpg" alt="main06" style="width: 100%;">
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
				<span class="sr-only">Previous</span>
			</a>

			<a class="right carousel-control" href="#myCarousel" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
	</body>
</html>