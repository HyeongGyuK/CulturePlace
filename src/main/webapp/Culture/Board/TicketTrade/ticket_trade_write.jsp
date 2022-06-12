<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../Intro/header/nav.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		$(document).ready(function(){
			var target = document.getElementById("tradeTypeBox");
			
			$('#board_submit').click(function(){
				if($('#board_title').val() == '' || $('#board_content').val() == ''){
					alert('입력이 안된 사항이 있습니다.');
				}
				
				if(target.options[target.selectedIndex].text == "선택"){
					alert('클래스명을 선택해주세요.');
					return false;
				}else{
					$('#reviewForm').attr('onsubmit', 'return true');
				}
			});
			
			$('#trade_submit').click(function(){
				if($('#trade_title').val() == '' || $('#trade_content').val() == ''){
					alert('입력이 안된 사항이 있습니다.');
				}
			});
			
			$('#trade_write').hover(function(){
				$(this).css({"background-color": "rgb(104, 105, 172, 0.15)"});
			}, function(){
				$(this).css({"background-color": "#FFFFFF"});
			});
			
			$('#trade_submit').hover(function(){
				$(this).css({"background-color":"rgb(104, 105, 172, 0.3)"});
			}, function(){
				$(this).css({"background-color":"#FFFFFF"});
			});
			
			$('#tradeBackBtn').hover(function(){
				$(this).css({"background-color":"rgb(104, 105, 172, 0.3)"});
			}, function(){
				$(this).css({"background-color":"#FFFFFF"});
			});
			
		});
		
		$('#trade_content').val().replace(/\n/g, "<br>");
		
	</script>
	
	<style type="text/css">
		#template{
			display: flex; width: 100%;
			justify-content: center; margin: 150px 0px 150px 0px;
		}
		#container{
			flex-direction: column; width: 60%;
		}
		#title{
			border-bottom: 4px solid gray;
			width:100%;
		}
	</style>
</head>
<body>
	<div id="template">
		<div id="container">
			<div id="title">
				<h2 style="font-weight: bold;">
					티켓 거래 게시판
				</h2>
			</div>
			<div id="title">
				<h3>
					글쓰기
				</h3>
			</div>
			<form action="" method="post">
				<div class="form-group">
				<span>거래 형태</span>
				<select id="tradeTypeBox" name="tradeTypeBox" onchange="className_change()">
					<option value="all">-- 거래전체
					<option value="writer">판매중
					<option value="writer">구매중
				</select>
				<input type="text" id="trade_title" name="trade_title" class="form-control" placeholder="제목을 입력해주세요." required>
				</div>

				<div class="form-group">
					<textarea class="form-control" rows="10" id="trade_content" name="trade_content" placeholder="내용을 입력해주세요." required></textarea>
				</div>
				<input type="hidden" id="trade_nickname" name="nickname" value="">
				<div align="right">
					<a href="/TicketTrade/ticket_trade_main" id="tradeBackBtn" class="btn btn-primary" style="background-color:#FFFFFF; color: #6667AB; border: 1px solid #6667AB">뒤로가기</a>&nbsp;&nbsp;
					<button type="submit" class="btn btn-primary pull-right" id="trade_submit" style="background-color:#FFFFFF; color: #6667AB; border: 1px solid #6667AB">제출하기</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>