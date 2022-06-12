<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />
	<script type="text/javascript" src="https://code,jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="https://unpkg.com/swiper/js/swiper.min.js"></script>
		<!-- Demo styles -->
	<style>
	

	html, body {
		height: 100%;
		background-color: #da532c;
	}
	
	#outSideArea {
		margin-top: 40px;
		justify-content: center;
		width: 100%;
		position: relative;
		display: contents;
	}
	
	
	
	
	
	.swiper-3d, .swiper-3d.swiper-css-mode .swiper-wrapper { perspective: 800px;}

	#solidSlide {
		background: #eee;
		font-size: 14px;
		color: #000;
		margin-top: 50px;
		width: 80%;
		content-visibility: auto;
		background-color: #da532c;
		transform: translate(10%, 0%);
	}

.swiper-slide {width: 35%; margin-right: 10px; height: 600px; box-shadow: 0 2px 10px 0px}

.swiper-slide.slide01 {background: url("http://ticketimage.interpark.com/PlayDictionary/DATA/PlayDic/PlayDicUpload/040001/22/03/0400012203_173418_01.644.gif"); background-repeat: no-repeat; background-size : cover;}

.swiper-slide.slide02 {background: url("http://ticketimage.interpark.com/PlayDictionary/DATA/PlayDic/PlayDicUpload/040001/22/04/0400012204_174031_01.025.gif"); background-repeat: no-repeat; background-size : cover;}

.swiper-slide.slide03 {background: url("http://ticketimage.interpark.com/PlayDictionary/DATA/PlayDic/PlayDicUpload/040001/22/02/0400012202_172196_01.105.gif"); background-repeat: no-repeat; background-size : cover;}

.swiper-slide.slide04 {background: url("http://ticketimage.interpark.com/PlayDictionary/DATA/PlayDic/PlayDicUpload/040001/22/04/0400012204_173715_01.719.gif"); background-repeat: no-repeat; background-size : cover;}

.swiper-slide.slide05 {background-color: #FFCE5E;}

.swiper-slide.slide06 {background-color: #F9F871;}

.swiper-slide.slide07 {background-color: #BE5EC2;}

.swiper-slide.slide08 {background-color: #F862A7;}

.swiper-slide.slide09 {background-color: #FF7B87;}

.swiper-slide.slide10 {background: url("http://ticketimage.interpark.com/PlayDictionary/DATA/PlayDic/PlayDicUpload/040001/21/12/0400012112_170817_01.243.gif"); background-repeat: no-repeat; background-size : cover;}

.swiper-slide.slide11 {background: url("http://ticketimage.interpark.com/PlayDictionary/DATA/PlayDic/PlayDicUpload/040001/22/01/0400012201_171946_01.030.gif"); background-repeat: no-repeat; background-size : cover;}

.swiper-slide.slide12 {background: url("http://ticketimage.interpark.com/PlayDictionary/DATA/PlayDic/PlayDicUpload/040001/22/04/0400012204_173980_01.205.gif"); background-repeat: no-repeat; background-size : cover;}

.swiper-slide:nth-child(6) {background: #96cc7d;}

.swiper-slide:nth-child(7) {background: #cc7dae;}
</style>
</head>

<body>
	<div id="outSideArea">



		<div id="solidSlide">
		<div class="swiper-container mySwiper">
			<div class="swiper-wrapper">
				<div class="swiper-slide slide01"></div>
				<div class="swiper-slide slide02"></div>
				<div class="swiper-slide slide03"></div>
				<div class="swiper-slide slide04"></div>
				<div class="swiper-slide slide05"></div>
				<div class="swiper-slide slide06"></div>
				<div class="swiper-slide slide07"></div>
				<div class="swiper-slide slide08"></div>
				<div class="swiper-slide slide09"></div>
				<div class="swiper-slide slide10"></div>
				<div class="swiper-slide slide11"></div>
				<div class="swiper-slide slide12"></div>
			</div>
		</div>
	</div>

	<!-- Swiper JS -->
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

	<!-- Initialize Swiper -->
	<script>

		const swiper = new Swiper('.swiper-container', {
			loop : true,
			centeredSlides : true,
			slidesPerView : 'auto',
			slideToClickedSlide : true,
			effect : 'coverflow',
			coverflowEffect : {
				rotate : -5,
				slideShadows : false,
				stretch : 100,
			},
		});

		$(document).ready(function() {

		});
	</script>
</body>
</html>