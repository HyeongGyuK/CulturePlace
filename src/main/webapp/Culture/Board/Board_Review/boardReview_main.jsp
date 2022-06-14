<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../../Intro/header/nav.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
 	// contextPath : 해당 애플리케이션의 이름(=컨덱스트 이름)
 	String contextPath = request.getContextPath();
 
 	// 서블릿 매핑 이름
 	String mapping = "/Culture";
 	// url 패턴
 
 	// 폼 태그에서 사용할 공용 변수
 	String yesForm = contextPath+mapping;

 	// 폼이 없는 <a>,<img> 태그에서 사용할 공용 변수
 	String noForm=contextPath+mapping+"?command=";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here 육각 product_page/ProductMain</title>
	<script>
		$(document).ready(function(){
		
			$('#writeBtn').hover(function(){
				$(this).css({"background-color": "black","color":"#FFFFFF"});
			}, function(){
				$(this).css({"background-color": "black", "color":"black", "border":"1px solid black});
			});
			
		});
	
	</script>
	<style>
		/* @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap'); */
		*{padding:0; margin:0;}
		body{font-family: 'Noto Sans KR', sans-serif;}
	
		.list-tab{width:1184px; margin-top:72px; margin-left:auto; margin-right:auto; text-align:center;}
	  	.list-tab li:hover p{color:white; background-color:black; border-radius:20px;}
	  	.ul01{width:1184px }
	    .ul01 li{list-style:none; display:inline-block; width:143.63px; height:56px; line-height:56px; background-color:#f5f5f6;
	    	  	 border-radius:20px;}
   	    .ul01 p{font-size:16px; font-weight:700; color:black;}
   	    .list-data{width:1184px; height:1025px; margin-top:72px; margin-left:auto; margin-right:auto;}
		.ul02 li{list-style:none; float:left; 
				 width:376px; height:481.6px; margin-bottom:61px; margin-left:14px; }
		.li02{margin-left:28px; margin-right:28px; }
		
		.lidiv{width:370px; height:410px; background-color:#f5f5f6; border-radius:20px;}
		.image-div{width:376px; height:250px;}
		.image{width:300px; height:350px; margin-top:30px; margin-left:35px; 
		transition: all 0.2s linear;
		}
		.aforimg:hover img{transform: scale(1.05);}
		
		.clean-div{width:376px; height:60px;}
		.clean-list{width:75px; height:30px; margin-top:20px; margin-left:20px;}
		

		.ul02 h6{font-size:18px; margin-top:16px; cursor: pointer; }
		
		
	
		
		#btnBox{width:1184px; height:150px; margin:auto;}
		
		
		#rec_update{float:left; border:1px solid black;}
		
		.title_likeit{border:1px solid black; box-sizing:border-box; height:20px;}
		
	</style>
</head>
<body>
	<header></header>
	
		<div class="list-banner"></div>
		<div class="list-tab" id="tabbox">
			<ul class="ul01">
				<a href=""><li><p><span>연극</span></p></li></a>
				<a href=""><li><p><span>뮤지컬</span></p></li></a>
				<a href=""><li><p><span>콘서트</span></p></li></a>
				<a href=""><li><p><span>클래식/오페라</span></p></li></a>
				<a href=""><li><p><span>국악</span></p></li></a>
				<a href=""><li><p><span>무용</span></p></li></a>
			</ul>
		</div>
		<div class="list-data" id="photobox">
			<ul class="ul02">
				<li>
					<div class="lidiv"><!-- 이미지 -->
						<div class="image-div">
							<a class="aforimg" href="/board/detail"><img class="image" src="/Culture/images/Board/BoardReviewImg/ticket1.jpg"></a>
							<c:forEach var="bean.image" items="${requestScope.lists }" varStatus="status"></c:forEach>
						</div>
					</div>
					
					<div> <!-- 제목,좋아요 -->
						<div style="float: left;"><h6><a href="/board/detail">제목<c:forEach var="bean.title" items="${requestScope.lists }" varStatus="status"></c:forEach></a> 
								</h6></div>
						<div style="height:47.8px;  float: right;">
							<a href=""><img alt="likeit" src="/Culture/images/Board/BoardReviewImg/likeit.png" style="width: 25px; height: 25px; margin-right:15px; margin-top:10px;"></a>
						</div>			
					</div>
					
				</li>
	
	
				<li>
					<div class="lidiv">
						<div class="image-div">
							<a class="aforimg" href="boardReviewDetail"><img class ="image" src="/Culture/images/Board/BoardReviewImg/ticket2.jpg"></a>
							<c:forEach var="bean.image" items="${requestScope.lists }" varStatus="status"></c:forEach>
						</div>
					</div>
					<h6>제목<c:forEach var="bean.title" items="${requestScope.lists }" varStatus="status"></c:forEach></h6>
				</li>
				
				
				<li>
					<div class="lidiv">
						<div class="image-div">
							<a class="aforimg" href="boardReviewDetail"><img class ="image" src="/Culture/images/Board/BoardReviewImg/ticket3.jpg"></a>
							<c:forEach var="bean.image" items="${requestScope.lists }" varStatus="status"></c:forEach>
						</div>
					</div>
					<h6>제목<c:forEach var="bean.title" items="${requestScope.lists }" varStatus="status"></c:forEach></h6>
				</li>
				
				
				<li>
					<div class="lidiv">
						<div class="image-div">
							<a class="aforimg" href="boardReviewDetail"><img class ="image" src="/Culture/images/Board/BoardReviewImg/ticket4.jpg"></a>
							<c:forEach var="bean.image" items="${requestScope.lists }" varStatus="status"></c:forEach>
						</div>
					</div>
					<h6>제목<c:forEach var="bean.title" items="${requestScope.lists }" varStatus="status"></c:forEach></h6>
				</li>
				
				<li>
					<div class="lidiv">
						<div class="image-div">
							<a class="aforimg" href="boardReviewDetail"><img class ="image" src="/Culture/images/Board/BoardReviewImg/ticket1.jpg"></a>
							<c:forEach var="bean.image" items="${requestScope.lists }" varStatus="status"></c:forEach>
						</div>
					</div>
					<h6>제목<c:forEach var="bean.title" items="${requestScope.lists }" varStatus="status"></c:forEach></h6>
				</li>
				
				<li>
					<div class="lidiv">
						<div class="image-div">
							<a class="aforimg" href="boardReviewDetail"><img class ="image" src="/Culture/images/Board/BoardReviewImg/ticket2.jpg"></a>
							<c:forEach var="bean.image" items="${requestScope.lists }" varStatus="status"></c:forEach>
						</div>
					</div>
					<h6>제목<c:forEach var="bean.title" items="${requestScope.lists }" varStatus="status"></c:forEach></h6>
				</li>
			</ul>
	
		</div>
		
		
		<div id="btnBox">
				<a href="/board/insert"
				class="btn btn-primary pull-right"
				style="background-color: #FFFFFF; color: black; border: 1px solid black; box-sizing: border-box; font-size:18px; margin-top:-50px;"><b>글쓰기</b></a>
				
		</div>
	
	
	
</body>

</html>