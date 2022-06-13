<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/Culture/Intro/header/nav.jsp"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

div{
	/*border: 1px solid black;*/
}
	.posterImg{
		width:400px;
		height:400px;
		float:left;
		margin-left: 10px;
		text-align: center;
		padding-top: 10px;
	}
	.detail_info{
		width:700px;
		float:left;
	}
	.detail_page{
		width:1000px;
		padding: 10px;
		top:10px;
		left:50%;
		margin: auto;
		overflow: hidden;
		display: flex;
		padding-top: 20px;
	}
	.plot{
		width:1000px;
		line-height: 200%;
	}
	.detail_page{
		width:1000px;
		padding: 10px;
		top:10px;
		left:50%;
		margin: auto;
		overflow: hidden;
		display: flex;
		padding-top: 20px;
	}
	.maps{
		clear:both;
		width:1000px;
		padding: 10px;
		top:10px;
		left:50%;
		margin: auto;
		overflow: hidden;
		display: flex;
		padding-top: 20px;
	}
	.map_header{
		float: none;
		width:17%;
		height: 60px;
		margin-left: 45%;
		border: 1px hidden;
		
	}
	.real_map{
	width: 1000px;
	
	}
	.load_info{
		width:1000px;
		padding: 10px;
		left:50%;
		margin: auto;
		overflow: hidden;
		display: flex;
		border-top: 2px solid black;
		border-bottom: 2px solid black;
	}
	.detail_info > h3{
		padding-bottom: 20px;
	}
	.h3_div{
		background-color: white;
		border-bottom: 2px solid black;
	}
	.h3_div > h3{
		color:black;;
		margin-left: 45%
	}
	
	.detail_page .posterImg{
	width:400px;
	height:400px;
	background-color: white;
	background-repeat: no-repeat;
	background-position: 50% 50%;
	background-size: contain;
	font-size: 0px;
	border-bottom: 1px solid c0c0c0;
}

h3 p{
margin: 0;
    padding: 0;
    border: 0;
    font-size: inherit;
    /* font: inherit; */
    font-style: normal;
    vertical-align: baseline;
    
}
#cont_h3{
	border-top: 2px solid black;
}
.detail_page dt{
	font-size: 15px;
    color: #333;
    font-weight: bold;
    float: left;
    line-height: 35px;
}
.detail_page dd{
	font-size: 15px;
    color: #333;
    clear: right;
    margin: 0 0 3px 86px;
    line-height: 35px;
    position: relative;
}
a{
	text-decoration: none;
    outline: none;
    
}
.detail_page .rn-product-peole{
	font-size: 15px;
    color: #333;
}
.titel_header{
	width: 1000px;
    margin: 0 auto;
    position: relative;
    overflow: hidden;
}
.titel_header .titel_name{
	word-break: break-all;
    font-size: 35px;
    color: #333;
    line-height: 40px;
    font-weight: bold;
    letter-spacing: -0.003em;
    font-family: 'Noto Sans KR','NanumBarunGothic','맑은 고딕','Malgun Gothic',sans-serif;
    margin-bottom: 25px;
}
.large_title{
	margin-top: 25px;
    position: relative;
    border-bottom: 2px solid #333;
}
#cont_dd{
margin: 0 0 3px 40px;
}
/* .rn-product-peole:before {
    		content: '';
    		position: absolute; /*부모 요소에는 position: relative를 주어야 함*/
    		background-color: black;
    		border:1px hidden;
    		height: 1px;
			
			
    		width: 0; /*초기에 보이지 않도록*/
    		bottom: 0; /*a태그 아래에 위치*/
    		transition: 0.7s; /*애니메이션 동작 실행 시간 정의*/
		} */
.rn-product-peole:hover:before {
    		border:1px solid;
    		width: 8%;
    		
		}
		
.casting_info{
	width:1000px;
	padding: 10px;
	top:10px;
	left:50%;
	margin: auto;
	overflow: hidden;
	display: flex;
	padding-top: 20px;
}

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
	<div class="titel_header">
		<div class="large_title">
			<p class="titel_name">
				${detailList.title }
			</p>
		</div>
	</div>
	<div class="detail_page">
		<div class="posterImg" style="background-image: url('${detailList.img}');">
				사진 위치	
		</div>
		<div class="detail_info">
				<dl>
					<dt>등급</dt>
					<dd>&nbsp;${detailList.spectatorRating }</dd>
					<dt>관람시간</dt>
					<dd>&nbsp;${detailList.visitingHour }</dd>
					<dt>상영일자</dt>
					<dd>${detailList.date }</dd>
					<dt>장소</dt>
					<dd>${detailList.place }</dd>
					<dt>주소</dt>
					<dd id="address">${detailList.address }</dd>
				</dl>
		</div>
	</div>
	<div class="detail_page">
		<div class="plot">
		<div class="h3_div" id="cont_h3">
				<h3>세부 내용</h3>
		</div>	
				<dl>	
				<dd id="cont_dd">
					${detailList.introduction }
				</dd>
				</dl>
		</div>	
	</div>
	<div class="casting_info">
		<div >
			<h3>출연진</h3>
		</div>
		<div>
		${detailList.casting }
		</div>
	</div>
	<div class="load_info">
			<div class="map_header">
			<h3>찾아오시는 길</h3>
			</div>
	</div>
	<div class="maps">
		<div class="real_map">
			<div id="map" style="width:100%;height:350px;"></div> 

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1f06253b02115596a16a528502e47ea2&libraries=services"></script>
<script>


const geocoder = new kakao.maps.services.Geocoder()


//변경 이전 주소(지도 안뜨는 주소)   
var be_tit=["서울특별시 중구 필동 3가 26번지", "서울특별시 중구 장충동2가 14-67번지"]
   
//변경 이후 주소(도로명 주소)   
var af_tit = ["서울특별시 중구 필동로1길 30", "서울특별시 중구 장충단로 59"]
   
var title = document.getElementById("address").innerText;

if(title == be_tit[0] == true){
   title = af_tit[0]
} else if(title == be_tit[1] == true){
   title = af_tit[1]
}

console.log(title);

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
	         content: '<div id="map_mark">' + title + ' <br><div onclick="gotoMap()" style="cursor: pointer; margin-left:35%; margin-top:10px;"><a href="#" class="find_load" style="color:white" target="_blank">길찾기</a></div></div>'
	      })
	      infowindow.open(map, marker)
	   }
	})
	
	function gotoMap() {
	window.location.href= "https://map.kakao.com/?sName=한국소프트웨어인재개발원&eName="+title;
}
	


</script>
		</div>
	</div>
	
</body>
</html>