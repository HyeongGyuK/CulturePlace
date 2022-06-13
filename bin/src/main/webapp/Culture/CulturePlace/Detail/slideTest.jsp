<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../common/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
<style type="text/css">




.sidenav {
	height: 900px; width: 0;
	z-index: 1; background-color: #FFE4C4;
	overflow-x: hidden; padding-top: 60px;
	transition: 0.5s;
    text-align: -webkit-center;
}

#searchSpace, #searchButton ,#searchSelector{
	height: 40px; border-style: none;
	margin: 0; background-color: #FFC0CB;
	vertical-align: middle;
}

#searchSelector{width:80px; border-style: none; font-size: 18px; appearance:none; outline: none;}
#searchSelector option{outline: none;}
#searchSpace{width: 235px; outline: none; font-size: 18px;}
#searchButton{width: 50px; font-size: 18px;}


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


#leftSlide{
	box-sizing: border-box;
	float: left;
}

#closeButton, #openButton{
	font-size: 35px; cursor: pointer;
	width: 50px; height:50px;
	box-sizing: border-box;
	float: left; background-color: #FFE4C4;
	text-align: center; margin-top: 30px;
}

</style>


</head>
<body>
	<div id="background" style="height:2000px;">
		<div style="display: inline-flex; position: fixed;">
			<div id="leftSlide" class="sidenav">
				<div id="searchArea" style="text-align: center; justify-content: center; width: 400px; border-radius: 20px; background-color: #FFC0CB; height: 45px;">
					<select id="searchSelector">
						<option/> -- 검색 --
						<option/> 연극
						<option/> 뮤지컬
					</select>
					<input id="searchSpace" type="text"></input>
					<button id="searchButton" type="button">검색</button>
				</div>
				<c:forEach items="" begin="" step="">
					<ul style="background-color: white; width:300px;">
						<li>웃는 남자</li>
						<li>웃는 남자</li>
						<li>웃는 남자</li>
						<li>웃는 남자</li>
						<li>웃는 남자</li>
						<li>웃는 남자</li>
						<li>웃는 남자</li>
					</ul>
				</c:forEach>		
			</div>
			<div id="openButton" onclick="openNav()">&#9776;</div>
			<div id="closeButton" onclick="closeNav()">&times;</div>
		</div>
	</div>
</body>

<script type="text/javascript">	
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
	
	if ($('#leftSlide' ).css("width") == "0") {
		$('.leftArea').css({"z-index":"0"});
	} else {
		$('.leftArea').css({"z-index":"1"});
	}
	
	
	
</script>


</html>