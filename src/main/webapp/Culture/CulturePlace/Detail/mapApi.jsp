<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>마커에 인포윈도우 표시하기</title>
    <style type="text/css">
    	
    	#map_mark{
    		border: 1px solid black;
    		padding:5px; 
    		background-color:orange; 
    		border-radius:7px;
    		background-color: #3879e8;
    		color:#ffffff;
    		width: 195px;
    		margin-top:-10px;
    		padding-left: 15px;
    		
    		transition-property: background-color;
    		transition-duration: 0.6s;
    		transition-timing-function: ease-out;
    	}
    	
    	#map_mark:hover {
			/*rgb컬러a알파 0~1까지 화이트 0.3만큼 알파 혹은 반투명*/
			background: rgba(44, 96, 185, 1);
			/* 변형할 것은 배경 1초, 빠른 시작 서서히 감속*/
			transition: background 0.3s ease-out;
		}
		
    	.find_load{
    		text-decoration: none;
    		margin-left: 5px;
    	}
    	
/*     	a:before {
    		content: '';
    		position: absolute; /*부모 요소에는 position: relative를 주어야 함*/
    		background-color: white;
    		border:1px hidden;
    		height: 1px;

    		width: 0; /*초기에 보이지 않도록*/
    		bottom: 0; /*a태그 아래에 위치*/
    		transition: 0.7s; /*애니메이션 동작 실행 시간 정의*/
		} */
		a:hover:before {
    		width: 20%;
		}
		
		
		element.style {
		    cursor: default;
		    position: absolute;
		    background: rgb(255, 255, 255);
		    border: 1px solid rgb(118, 129, 168);
		    z-index: 0;
		    display: block;
		    width: 209px;
		    height: 0px;
		    left: 742px;
		    top: 72px;
		}
    </style>
</head>
<body>
<div id="map" style="width:100%;height:350px;"></div> 

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f06253b02115596a16a528502e47ea2&libraries=services"></script>
<script>


const geocoder = new kakao.maps.services.Geocoder()




var title="서울특별시 종로구 혜화동 179-4"

geocoder.addressSearch(title, (res, stat) => { 
	   if (stat === kakao.maps.services.Status.OK) {
	      const coords = new kakao.maps.LatLng(res[0].y, res[0].x);
	      const marker = new kakao.maps.Marker({
	         map: map,
	         position: coords
	      })
	      
	     
	  	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(res[0].y, res[0].x), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };

		var map = new kakao.maps.Map(mapContainer, mapOption);
		
		// 마커가 표시될 위치입니다 
		var markerPosition  = new kakao.maps.LatLng(res[0].y, res[0].x); 
		
	        
	      const infowindow = new kakao.maps.InfoWindow({ 
	         content: '<div id="map_mark">title <br><div onclick="gotoMap()" style="cursor: pointer; margin-left:35%; margin-top:10px;"><a href="#" class="find_load" style="color:white" target="_blank">길찾기</a></div></div>'
	      })
	      infowindow.open(map, marker)
	   }
	})
	
	function gotoMap() {
	window.location.href= "https://map.kakao.com/?sName=한국소프트웨어인재개발원&eName=서울특별시 종로구 혜화동 179-4";
}
	


</script>
</body>
</html>