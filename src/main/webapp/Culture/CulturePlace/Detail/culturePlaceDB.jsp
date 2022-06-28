<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/Culture/Intro/header/nav.jsp"%>
<%-- <%@ include file="./../../common/common.jsp" %> --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.culture.controller.crawling.crawling_theater.allListTheaterCrawController" contentType="text/html; charset=UTF-8"%>
<jsp:useBean id="allImgUrl" class="com.culture.controller.crawling.crawling_theater.allListTheaterCrawController"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://unpkg.com/swiper/swiper-bundle.min.css" />
<script type="text/javascript"
	src="https://code,jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
	src="https://unpkg.com/swiper/js/swiper.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	
<link rel="stylesheet" href="/CulturePlace/CulturePlaceMain/main/cultureDB.css">
<link rel="stylesheet" href="/CulturePlace/CulturePlaceMain/main/imageReview.css">
<!-- Demo styles -->
<style>
* {
  margin: 0;
  padding: 0;
}

html, body {
	padding-top:50px;
}

.sidenav {
	height: 900px;
	width: 0;
	z-index: 1;
	background-color: #FFE4C4;
	overflow-x: hidden;
	padding-top: 60px;
	transition: 0.5s;
	text-align: -webkit-center;
}

#searchSpace, #searchButton, #searchSelector {
	height: 40px;
	border-style: none;
	margin: 0;
	background-color: #FFC0CB;
	vertical-align: middle;
}

#searchSelector {
	width: 80px;
	border-style: none;
	font-size: 18px;
	appearance: none;
	outline: none;
}

#searchSelector option {
	outline: none;
}

#searchSpace {
	width: 235px;
	outline: none;
	font-size: 18px;
}

#searchButton {
	width: 50px;
	font-size: 18px;
}

.sidenav a {
	padding: 8px 8px 8px 32px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
	transition: 0.3s;
}

.sidenav a:hover {
	color: #f1f1f1;
}

#leftSlide {
	box-sizing: border-box;
	float: left;
}

#closeButton, #openButton {
	font-size: 35px;
	cursor: pointer;
	width: 50px;
	height: 50px;
	box-sizing: border-box;
	float: left;
	background-color: #FFE4C4;
	text-align: center;
	margin-top: 30px;
}

#outSideArea {
	margin-top: 40px;
	justify-content: center;
	width: 100%;
	position: relative;
	display: contents;
}

.swiper-3d, .swiper-3d.swiper-css-mode .swiper-wrapper {
	perspective: 350px;
}


#solidSlide {
/* 	background: #eee; */
	font-size: 14px;
	color: #000;
	margin-top: 50px;
	width: 70%;
	content-visibility: auto;
/* 	background-color: #000; */
	transform: translate(23%, 0%);
	height: 122px;
	padding-top: 11px;
}

#solidSlide h1{
	margin-top:27px;
}

.swiper-slide {
	width: 35%;
	margin-right: 10px;
	height: 100px;
	box-shadow: 0 0px 10px 0px;
	background-position:center;
	background-repeat:no-repeat;
}

/* .swiper-slide-active{ */
/* 	color:black; */
/* } */
/* .swiper-slide-active>h1{ */
/* 	color:white; */
/* } */

.swiper-slide.slide01 {
	background-color: white;
}

.swiper-slide.slide02 {
	background-color: white;
}

.swiper-slide.slide03 {
	background-color: white;
}

.swiper-slide.slide04 {
	background-color: white;
}

.swiper-slide.slide05 {
	background-color: white;
}

.swiper-slide.slide06 {
	background-color: white;
}

.swiper-slide.slide07 {
	background-color: white;
}

.swiper-slide.slide08 {
	background-color: white;
}

.swiper-slide.slide09 {
	background-color: white;
}

.swiper-slide.slide10 {
	background-color: white;
}

.swiper-slide.slide11 {
	background-color: white;
}

.swiper-slide.slide12 {
	background-color: white;
}

.swiper-slide:nth-child(6) {
	background-color: white;
}

.swiper-slide:nth-child(7) {
	background-color: white;
}

.swiper-button-next, .swiper-button-prev{
	display:none;
}

</style>
</head>

<body>
	<div id="outSideArea">

		<div class="leftArea" style="display: inline-flex; position: fixed;">
			<div id="leftSlide" class="sidenav">
				<div id="searchArea"
					style="text-align: center; justify-content: center; width: 400px; border-radius: 20px; background-color: #FFC0CB; height: 45px;">
					<select id="searchSelector">
						<option /> -- 검색 --
						<option /> 연극
						<option /> 뮤지컬
					</select> <input id="searchSpace" type="text"></input>
					<button id="searchButton" type="button">검색</button>
				</div>
				<ul style="background-color: white; width: 300px;">

				</ul>
			</div>
			<div id="openButton" onclick="openNav()">&#9776;</div>
			<div id="closeButton" onclick="closeNav()">&times;</div>
		</div>

		<div id="solidSlide">
			<div class="swiper-container mySwiper">
				<div class="swiper-wrapper">
					<div class="swiper-slide slide01">
					</div>
					<div class="swiper-slide slide02">
					</div>
					<div class="swiper-slide slide03">
					</div>
					<div class="swiper-slide slide04">
					</div>
					<div class="swiper-slide slide05">
					</div>
					<div class="swiper-slide slide06">
					</div>
				</div>
			</div>
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
		</div>
		
		
		<!-- Swiper JS -->
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
	
	
	</div>
	<div id="crawlingList">
	
	</div>
	<!-- Initialize Swiper -->
	<script>
		
	<%-- 왼쪽 사이드 메뉴바 --%>
		$(document).ready(function() {
			$('#openButton').show();
			$('#closeButton').hide();
		});

		$('#openButton').click(function() {
			$('#openButton').hide();
			$('#closeButton').show();

		});

		$('#closeButton').click(function() {
			$('#closeButton').hide();
			$('#openButton').show();
		});

		function openNav() {
			document.getElementById("leftSlide").style.width = "500px";
		}

		function closeNav() {
			document.getElementById("leftSlide").style.width = "0";
		}

		if ($('#leftSlide').css("width") == "0") {
			$('.leftArea').css({
				"z-index" : "0"
			});
		} else {
			$('.leftArea').css({
				"z-index" : "998"
			});
		}
	</script>
	<script>
	<%-- swiper 구간 --%>
	var token = $("meta[name='_csrf']").attr("content");
                var header = $("meta[name='_csrf_header']").attr("content");
	var result = "";
	var swiperIndex = ${playNum};
		const swiper = new Swiper('.swiper-container',{
			initialSlide: swiperIndex,
			loop : true,
			centeredSlides : true,
			slidesPerView : 'auto',
			slideToClickedSlide : true,
			effect : 'coverflow',
			touchRatio: 0,
			coverflowEffect : {
				rotate : -5,
				slideShadows : false,
				stretch : 100,
			},navigation: {
		          nextEl: ".swiper-button-next",
		          prevEl: ".swiper-button-prev"
	        }, on : {
				activeIndexChange: function () {
					result = "";
					if(this.realIndex == 0){
						$.ajax({
							type: "POST",
							url: "/culturePlace/allTheaterList/allList",
							dataType: "text",
							beforeSend : function(xhr){
                                                /* 데이터를 전송하기 전에 헤더에 csrf값을 설정 */
                                                xhr.setRequestHeader(header, token);
                                            },
							data: {
								theaterUrl: "http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000002"
							},
							async:false,
							success: function(data){
// 								alert("bbbbbbbbbbbbbbbbbbbbb");
								result = data;
								var crawlingList = document.getElementById("crawlingList");
								
								while ( crawlingList.hasChildNodes() )
								{
									crawlingList.removeChild( crawlingList.firstChild );       
								}
								$("#crawlingList").append(result);
							},
							error: function(request,status,error){
								alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
							}
						});
						return result;
						
					}else if(this.realIndex == 1){
						result = "";
						$.ajax({
							type: "POST",
							url: "/culturePlace/allTheaterList/allList",
							dataType: "text",
							beforeSend : function(xhr){
                                                /* 데이터를 전송하기 전에 헤더에 csrf값을 설정 */
                                                xhr.setRequestHeader(header, token);
                                            },
							data: {
								theaterUrl: "http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000001"
							},
							async:false,
							success: function(data){
// 								alert("aaaaaaaaaaaaaaaa");
								result = data;
								var crawlingList = document.getElementById("crawlingList");

								while ( crawlingList.hasChildNodes() )
								{
									crawlingList.removeChild( crawlingList.firstChild );       
								}
								
								
								$("#crawlingList").append(data);
							},
							error: function(request,status,error){
								alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
							}
						});
						return result;
					}else if(this.realIndex == 2){
						result = "";
						$.ajax({
							type: "POST",
							url: "/culturePlace/allTheaterList/allList",
							dataType: "text",
							beforeSend : function(xhr){
                                                /* 데이터를 전송하기 전에 헤더에 csrf값을 설정 */
                                                xhr.setRequestHeader(header, token);
                                            },
							data: {
								theaterUrl: "http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000003&sReqSubCategory=&sReqDistrict=&sReqTab=2&sPlayType=2&sStartYear=&sSelectType=1"
							},
							async:false,
							success: function(data){
// 								alert("aaaaaaaaaaaaaaaa");
								result = data;
								var crawlingList = document.getElementById("crawlingList");

								while ( crawlingList.hasChildNodes() )
								{
									crawlingList.removeChild( crawlingList.firstChild );       
								}
								
								
								$("#crawlingList").append(data);
							},
							error: function(request,status,error){
								alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
							}
						});
						return result;
					}else if(this.realIndex == 3){
// 						alert(this.realIndex)
						result = "";
						$.ajax({
							type: "POST",
							url: "/culturePlace/allTheaterList/allList",
							dataType: "text",
							beforeSend : function(xhr){
                                                /* 데이터를 전송하기 전에 헤더에 csrf값을 설정 */
                                                xhr.setRequestHeader(header, token);
                                            },
							data: {
								theaterUrl: "http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000004"
							},
							async:false,
							success: function(data){
								result = data;
								var crawlingList = document.getElementById("crawlingList");

								while ( crawlingList.hasChildNodes() )
								{
									crawlingList.removeChild( crawlingList.firstChild );       
								}
								
								
								$("#crawlingList").append(data);
							},
							error: function(request,status,error){
								alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
							}
						});
						return result;
					}else if(this.realIndex == 4){
// 						alert(this.realIndex)
						result = "";
						$.ajax({
							type: "POST",
							url: "/culturePlace/allTheaterList/allList",
							dataType: "text",
							beforeSend : function(xhr){
                                                /* 데이터를 전송하기 전에 헤더에 csrf값을 설정 */
                                                xhr.setRequestHeader(header, token);
                                            },
							data: {
								theaterUrl: "http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000005"
							},
							async:false,
							success: function(data){
								result = data;
								var crawlingList = document.getElementById("crawlingList");

								while ( crawlingList.hasChildNodes() )
								{
									crawlingList.removeChild( crawlingList.firstChild );       
								}
								
								
								$("#crawlingList").append(data);
							},
							error: function(request,status,error){
								alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
							}
						});
						return result;
					}else if(this.realIndex == 5){
// 						alert(this.realIndex)
						result = "";
						$.ajax({
							type: "POST",
							url: "/culturePlace/allTheaterList/allList",
							dataType: "text",
							beforeSend : function(xhr){
                                                /* 데이터를 전송하기 전에 헤더에 csrf값을 설정 */
                                                xhr.setRequestHeader(header, token);
                                            },
							data: {
								theaterUrl: "http://www.playdb.co.kr/playdb/playdblist.asp?sReqMainCategory=000007"
							},
							async:false,
							success: function(data){
								result = data;
								var crawlingList = document.getElementById("crawlingList");

								while ( crawlingList.hasChildNodes() )
								{
									crawlingList.removeChild( crawlingList.firstChild );       
								}
								
								
								$("#crawlingList").append(data);
							},
							error: function(request,status,error){
								alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
							}
						});
						return result;
					}
			    }
			}
		});
	</script>
</body>
</html>