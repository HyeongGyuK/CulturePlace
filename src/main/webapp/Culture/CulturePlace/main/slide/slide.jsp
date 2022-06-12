<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>


<script type="text/javascript">
$(document).ready(function(){
    $('.slider').bxSlider({
    	auto: true,
		speed: 500,
		pause: 4000,
		mode:'fade',
		autoControls: true,
		pager:true,    	
    });
  });
</script>
<link rel="stylesheet" href="/CulturePlace/CulturePlaceMain/main/slide/slide.css">
</head>
<body>
<!-- 슬라이드 추가하고싶으면 밑에있는 img태그 있는 줄 복붙하면 추가가능  -->
<div class="slider">
    <div><img src="/Culture/images/CulturePlaceImg/CulturePlaceMain/slide/slide_cats.jpg" style="width: 100%; height: 600px;"></div>
    <div><img src="/Culture/images/CulturePlaceImg/CulturePlaceMain/slide/slide_smile.jpg" style="width: 100%; height: 600px;"></div>
    <div><img src="/Culture/images/CulturePlaceImg/CulturePlaceMain/slide/slide_wicked.jpg" style="width: 100%; height: 600px;"></div>
  </div>

</body>
</html>