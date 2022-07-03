<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedHashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Culture/Intro/header/nav.jsp"%>
<%-- <jsp:include page="/Culture/Intro/header/nav.html"/> --%>
<%-- <jsp:include page="CulturePlace/Common/nav.hmtl"></jsp:include> --%>

<%@ include file="./slide/slide.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="topFiveCraw" class="com.culture.controller.crawling.crawling_theater.topTheaterCrawController"/>
<%
	topFiveCraw.getTheaterTopFiveList();
	LinkedHashMap<String, String> theaterTopFiveCodeNImg = topFiveCraw.getTheaterTopFiveCodeNImg();
	LinkedHashMap<String, String> theaterTopFiveCodeNTitle = topFiveCraw.getTheaterTopFiveCodeNTitle();
	int theaterImgCnt = 0;
	
	List<String> topTheaterList = new ArrayList<String>();
	for(String key : theaterTopFiveCodeNTitle.values()){
		topTheaterList.add(key);
	}
	
	LinkedHashMap<String, String> musicalTopFiveCodeNImg = topFiveCraw.getMusicalTopFiveCodeNImg();
	LinkedHashMap<String, String> musicalTopFiveCodeNTitle = topFiveCraw.getMusicalTopFiveCodeNTitle();
	int musicalImgCnt = 0;
	
	List<String> topMusicalList = new ArrayList<String>();
	for(String key : musicalTopFiveCodeNTitle.values()){
		topMusicalList.add(key);
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/CulturePlace/CulturePlaceMain/main/main.css">
<link rel="stylesheet" href="/CulturePlace/CulturePlaceMain/main/imageReview.css">
</head>
<body>
	<div class="header_text">
		<div class="top">
			<h2>연극 예매 Top 5</h2>
            <a href="#" class="more_detail"> 더보기</a>
		</div>
	</div>
	
	<div class="list_wrap">
		<ul style="width: 98%">
			<c:forEach var="topFiveTheaterImg" items="<%=theaterTopFiveCodeNImg %>" varStatus="status">
				<li class="item item1">
					<a href="/culturePlace/detailPage?playCode=${topFiveTheaterImg.key }&imgUrl=${topFiveTheaterImg.value}&theaterTopFiveTitle=<%=topTheaterList.get(theaterImgCnt) %>">
						<div class="image" style="background-image: url('${topFiveTheaterImg.value}');"></div>
                        <p class="item_p">바로가기</p>
					</a>
					<div class="cont">
						<strong><%=topTheaterList.get(theaterImgCnt) %></strong>
					</div>
				</li>
				<%theaterImgCnt += 1; %>
			</c:forEach>
		</ul>
	</div>
	
	<div class="header_text">
		<div class="top">
			<h2>뮤지컬 예매 Top 5</h2>
			<a href="#" class="more_detail"> 더보기</a>
		</div>
	</div>
	
	<div class="list_wrap">
		<ul style="width: 98%">
			<c:forEach var="topFiveMusicalImg" items="<%=musicalTopFiveCodeNImg %>" varStatus="status">
				<li class="item item1">
					<a href="/culturePlace/detailPage?playCode=${topFiveMusicalImg.key }&imgUrl=${topFiveMusicalImg.value}&theaterTopFiveTitle=<%=topMusicalList.get(musicalImgCnt) %>">
						<div class="image" style="background-image: url('${topFiveMusicalImg.value}');">사진</div>
						<p class="item_p">바로가기</p>
					</a>
					<div class="cont">
						<strong><%=topMusicalList.get(musicalImgCnt) %></strong>
					</div>
				</li>
				<%musicalImgCnt += 1; %>
			</c:forEach>
		</ul>
	</div>
	
	<!-- 이미지 리뷰 부분 -->
	<!-- absolute 사용 -->
	<h2 class="review_h2">이미지 리뷰</h2>
	
	
	
	<div class="review-all" style="width: 1116px; height: 1150px; margin-left: 240px;">
		<div class="review-item" style="width: 356px; height: 360.88px; position: absolute; left:340px; top:1950px; border: 1px solid black;">
			<a href="#"><span class="image1"></span></a>
		</div>
		<div class="review-item" style="width: 356px; height: 238.69px; position: absolute; left:720px; top:1950px; border: 1px solid black;">
			<a href="#"><span class="image2"></span></a>
		</div>
		<div class="review-item" style="width: 356px; height: 200.25px; position: absolute; left:1100px; top:1950px; border: 1px solid black;">
			<a href="#"><span class="image3"></span></a>
		</div>
		<div class="review-item" style="width: 356px; height: 235.38px; position: absolute; left:1100px; top:2180.25px; border: 1px solid black;">
			<a href="#"><span class="image4"></span></a>
		</div>
		<div class="review-item" style="width: 356px; height: 532.16px; position: absolute; left:720px; top:2218.688px; border: 1px solid black;">
			<a href="#"><span class="image5"></span></a>
		</div>
		<div class="review-item" style="width: 356px; height: 529.38px; position: absolute; left:340px; top:2340.875px; border: 1px solid black;">
			<a href="#"><span class="image6"></span></a>
		</div>
		<div class="review-item" style="width: 356px; height: 231.06px; position: absolute; left:1100px; top:2445.625px; border: 1px solid black;">
			<a href="#"><span class="image7"></span></a>
		</div>
		<div class="review-item" style="width: 356px; height: 237.16px; position: absolute; left:1100px; top:2706.687px; border: 1px solid black;">
			<a href="#"><span class="image8"></span></a>
		</div>
		<div class="review-item" style="width: 356px; height: 236.47px; position: absolute; left:720px; top:2780.844px; border: 1px solid black;">
			<a href="#"><span class="image9"></span></a>
		</div>
	</div>
	
	
	<!-- 이미지 리뷰 종료 -->
</body>

</html>