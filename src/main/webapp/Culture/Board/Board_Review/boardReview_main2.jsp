<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../Board_Common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here 육각 product_page/ProductMain</title>
	<script src="https://kit.fontawesome.com/33825a4a6a.js" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
		
			$('#writeBtn').hover(function(){
				$(this).css({"background-color": "#6255f6","color":"#FFFFFF"});
			}, function(){
				$(this).css({"background-color": "#FFFFFF", "color":"#6255f6", "border":"1px solid #6255f6"});
			});
			
		});
		
		
		
		var check_status = false;
		var like_cnt = $("#like-cnt");
		var like_parent = $(".like-container");

		var burst = new mojs.Burst({
		  parent: like_parent,
		  radius:   { 20: 60 },
		  count: 15,
		  angle:{0:30},
		  children: {
		    delay: 250,
		    duration: 700,
		    radius:{10: 0},
		    fill:   [ 'red' ],
		    easing:     mojs.easing.bezier(.08,.69,.39,.97)
		  }
		});

		$("#like-cnt").click(function(){
		  var t1 = new TimelineLite();
		  var t2 = new TimelineLite();
		  if(!check_status){
		    t1.set(like_cnt, {scale:0});
		    t1.set('.like-btn', {scale: 0});
		    t1.to(like_cnt, 0.6, {scale:1, background: '#ddca7e',ease: Expo.easeOut});
		    t2.to('.like-btn', 0.65, {scale: 1, ease: Elastic.easeOut.config(1, 0.3)}, '+=0.2');
		    check_status=true;
		    burst.replay();
		  }
		  else{
		    t1.to(like_cnt, 1, {scale:1})
		      .to(like_cnt, 1, {scale:1, background: 'rgba(255,255,255,0.3)', ease: Power4.easeOut});
		    t1.timeScale(7);
		    check_status=false;
		  }
		  
		})
	
	</script>
	<style>
		/* @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap'); */
		*{padding:0; margin:0;}
		body{font-family: 'Noto Sans KR', sans-serif;}
	
		.list-tab{width:1184px; margin-top:72px; margin-left:auto; margin-right:auto; text-align:center;}
	  	.list-tab li:hover p{color:#74eb8b; background-color:#6255f6; border-radius:20px;}
	  	.ul01{width:1184px }
	    .ul01 li{list-style:none; display:inline-block; width:143.63px; height:56px; line-height:56px; background-color:#f5f5f6;
	    	  	 border-radius:20px;}
   	    .ul01 p{font-size:16px; font-weight:700; color:#6255f6;}
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
		
		
		
		
		
		.like-container{filter: url('#filter');
		  position: absolute; 
		  left: 50%; 
		  top: 50%; 
		  transform: translate(50%, -50%);
			}
		.like-cnt{  
		  position: absolute; 
		  cursor: pointer;
		  left: 50%; 
		  top: 100%; 
		  transform: translate(50%, -50%);     background: rgba(255,255,255,0.3);     width: 60px; 
		  height: 60px;  
		  border-radius: 50%;
		  text-align: center;
		  line-height: 75px;
		  z-index: 10;
		}
		.like-btn{
		  color: #fff;
		}
		
		.gp-header{font-family: georgia; font-size: 40px; color: #ddca7e; font-style: italic; text-align: center; margin-top: 31px;}
		::-moz-selection { background: transparent;}
		::selection {background: transparent;}
		
	</style>
</head>
<body>
	<header></header>
	
		<div class="list-banner"></div>
		<div class="list-tab" id="tabbox">
			<ul class="ul01">
				<a href=""><li><p><span>연극</span></p></li></a>
				<a href=""><li><p><span>뮤지컬</span></p></li></a>
				<a href=""><li><p><span>영화</span></p></li></a>
				<a href=""><li><p><span>콘서트</span></p></li></a>
				<a href=""><li><p><span>클래식/오페라</span></p></li></a>
				<a href=""><li><p><span>국악</span></p></li></a>
				<a href=""><li><p><span>무용</span></p></li></a>
			</ul>
		</div>
		<div class="list-data" id="photobox">
			<ul class="ul02">
				<li>
					<div class="lidiv">
						<div class="image-div">
							<a class="aforimg" href="/Culture/Board/BoardReview/boardReview_detail.jsp"><img class="image" src="/Culture/images/Board/BoardReviewImg/ticket1.jpg"></a>
							<c:forEach var="bean.image" items="${requestScope.lists }" varStatus="status"></c:forEach>
						</div>
					</div>



				<div class="like-container">
					<div class="like-cnt unchecked" id="like-cnt">
						<i class="like-btn material-icons">thumb_up</i>
					</div>
				</div>
				


			</li>
	
	
				<li>
					<div class="lidiv">
						<div class="image-div">
							<a class="aforimg" href="<%=noForm%>boardReviewDetail"><img class ="image" src="/Culture/images/Board/BoardReviewImg/ticket2.jpg"></a>
							<c:forEach var="bean.image" items="${requestScope.lists }" varStatus="status"></c:forEach>
						</div>
					</div>
					<h6>제목<c:forEach var="bean.title" items="${requestScope.lists }" varStatus="status"></c:forEach></h6>
				</li>
				
				
				<li>
					<div class="lidiv">
						<div class="image-div">
							<a class="aforimg" href="<%=noForm%>boardReviewDetail"><img class ="image" src="/Culture/images/Board/BoardReviewImg/ticket3.jpg"></a>
							<c:forEach var="bean.image" items="${requestScope.lists }" varStatus="status"></c:forEach>
						</div>
					</div>
					<h6>제목<c:forEach var="bean.title" items="${requestScope.lists }" varStatus="status"></c:forEach></h6>
				</li>
				
				
				<li>
					<div class="lidiv">
						<div class="image-div">
							<a class="aforimg" href="<%=noForm%>boardReviewDetail"><img class ="image" src="/Culture/images/Board/BoardReviewImg/ticket4.jpg"></a>
							<c:forEach var="bean.image" items="${requestScope.lists }" varStatus="status"></c:forEach>
						</div>
					</div>
					<h6>제목<c:forEach var="bean.title" items="${requestScope.lists }" varStatus="status"></c:forEach></h6>
				</li>
				
				<li>
					<div class="lidiv">
						<div class="image-div">
							<a class="aforimg" href="<%=noForm%>boardReviewDetail"><img class ="image" src="/Culture/images/Board/BoardReviewImg/ticket1.jpg"></a>
							<c:forEach var="bean.image" items="${requestScope.lists }" varStatus="status"></c:forEach>
						</div>
					</div>
					<h6>제목<c:forEach var="bean.title" items="${requestScope.lists }" varStatus="status"></c:forEach></h6>
				</li>
				
				<li>
					<div class="lidiv">
						<div class="image-div">
							<a class="aforimg" href="<%=noForm%>boardReviewDetail"><img class ="image" src="/Culture/images/Board/BoardReviewImg/ticket2.jpg"></a>
							<c:forEach var="bean.image" items="${requestScope.lists }" varStatus="status"></c:forEach>
						</div>
					</div>
					<h6>제목<c:forEach var="bean.title" items="${requestScope.lists }" varStatus="status"></c:forEach></h6>
				</li>
			</ul>
	
		</div>
		
		
		<div id="btnBox">
				<a href="/Culture/Board/BoardReview/boardReview_insert.jsp"
				class="btn btn-primary pull-right"
				style="background-color: #FFFFFF; color: #6255f6; border: 1px solid #6255f6; box-sizing: border-box; font-size:18px; margin-top:-50px;"><b>글쓰기</b></a>
				
		</div>
	
	
	
</body>

</html>