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
    		margin-left:2px;
    		
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
		
    	a{
    		text-decoration: none;
    		margin-left: 10px;
    	}
    	
    	a:before {
    		content: '';
    		position: absolute; /*부모 요소에는 position: relative를 주어야 함*/
    		background-color: white;
    		border:1px hidden;
    		height: 1px;

    		width: 0; /*초기에 보이지 않도록*/
    		bottom: 0; /*a태그 아래에 위치*/
    		transition: 0.7s; /*애니메이션 동작 실행 시간 정의*/
		}
		a:hover:before {
    		width: 32%;
		}
		
    </style>
</head>
<body>
<div id="map" style="width:50%;height:430px; margin-left: 200px;"></div> 

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f06253b02115596a16a528502e47ea2"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(37.58637770208235, 127.00148318423548), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption);

// 마커가 표시될 위치입니다 
var markerPosition  = new kakao.maps.LatLng(37.58637770208235, 127.00148318423548); 

// 마커를 생성합니다
var marker = new kakao.maps.Marker({
    position: markerPosition
});

// 마커가 지도 위에 표시되도록 설정합니다
marker.setMap(map);

var iwContent = '<div id="map_mark">혜화동 연극실험실 <br><a href="https://map.kakao.com/link/map/혜화동 연극실험실,37.58637770208235, 127.00148318423548" style="color:white; " target="_blank">큰지도</a> <a href="https://map.kakao.com/link/to/연극실험실 혜화동1번지,37.58637770208235, 127.00148318423548" style="color:white" target="_blank">길찾기</a></div>', // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
    iwPosition = new kakao.maps.LatLng(37.58637770208235, 127.00148318423548); //인포윈도우 표시 위치입니다

// 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({
    position : iwPosition, 
    content : iwContent 
});
  
// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
infowindow.open(map, marker); 
</script>
</body>
</html>