<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap')
	;

* {
	padding: 0;
	margin: 0;
}

.pri-01 {
	height: 50px;
	text-align: left;
	padding-left: 40px;
	font-size: 30px;
	background-color: yellow;
	
}

.pri-02 {
	border: solid black 1px;
	width: 100%;
	height: 500px;
	justify-content: center;
	display: inline-flex;
}

.Cldiv01 {
	width: 40%;
	border: solid black 1px;
}

.box1 {

	width: 45%;
	height: 500px;
	display: inline-block;
	height: 500px;
	padding-top: 100px;
	
}

.box1_01 {
	width: 150px;
	height: 200px;
	border: solid black 1px;
	float: right;
	padding-top: 100px;
}

.box2 {

	width: 45%;
	height: 500px;
	display: inline-block;
	padding-left: 30px;
	
	
}

#tID01 {
	border: 1px solid black;
	height: 300px;
	
}

.form-name {
	
}

.form-horizontal {
	float: left;
	padding-top: 95px;
}

.btn btn-default{
	
}
#footer1{
	height: 50px;
	padding-left: 40px;
	font-size: 30px;
	background-color: yellow;
}
</style>
<script type="text/javascript">

		$(document).ready(function() {
			$('#fakeaddress').attr('disabled', true); // 주소 읽기 전용으로 설정
			$('.radio-inline').addClass('radio-inline') ; // 라디오 버튼 스타일 지정
			
			$("#inputdate").datepicker({dateFormat:"yy/mm/dd"}); // 날짜 선택기
			
			$('option[value="${requestScope.bean.category}"]').attr('selected', true); //select 박스 사용시
		
		});
		
		
		//이미지 preview 구역
		function setThumbnail(event){
			var reader = new FileReader();
			
			reader.onload = function(event){
			var img = document.createElement("img");
			
			img.setAttribute("src", event.target.result);
			document.querySelector("div#image_container").innerHTML = ''; //appendChild으로 이미지 삽입하기 전에 div#image_container을 비워줘야 한다.
			document.querySelector("div#image_container").appendChild(img);
				
			};
			reader.readAsDataURL(event.target.files[0]);
		};
					 
		
		
	</script>
</head>
<body>
	<div class="prinsert-main">
		<div class="prinsert-header">
			<div class="pri-00">
				<div class="pri-01">
					<p>연극 상세정보</p>
				</div>
				<div class="box1">
					<div class="box1_01">연극 포스터
					</div>
				</div>


				<div class="box2">
					<form class="form-horizontal" action="<%=yesForm%>" method="post">
						<input type="hidden" name="command" value="boInsert">
						<input type="hidden" name="writer"
							value="${sessionScope.loginfo.cId}">

						<table id="tID01">
							<tr>
								<td class="form-name2">상세정보</td>
								<td><textarea class="form-control2" id="content"
										name="content" cols="54" rows="5"></textarea><br> <%-- <input type="text" class="form-control2" id="name" name="name">--%></td>
							</tr>

							<tr>
								<td class="form-name">출연자 : </td>
								<td><input type="password" class="form-control"
									id="actor" name="actor"></td>
							</tr>
							<tr>
								<td class="form-name">상영 기간</td>
								<td><input type="text" class="form-control" id="ing"
									name="ing"></td>
							</tr>
					
							<tr>
								<td class="form-name">찾아오시는길</td>
								<td><input type="text" class="form-control" id="find_road" disabled="disabled"
									name="find_road" value="aaaaaaaaaaaaa"></td>
							</tr>

							<!-- 
							<tr>
								<td colspan="2">
									<button id="submit" type="submit" class="btn btn-default">길찾기</button>
								
								</td>
							</tr>
							 -->
							 
						</table>
					</form>
				</div>
			</div>
		</div>
		<footer id="footer1">
		푸터
		</footer>
</body>
</html>