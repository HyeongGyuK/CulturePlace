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
			$('#board_submit').click(function(){
				if($('#board_title').val() == '' || $('#board_content').val() == ''){
					alert('입력이 안된 사항이 있습니다.');
				}
			});
			
			$('#board_write').hover(function(){
				$(this).css({"background-color": "rgb(104, 105, 172, 0.15)"});
			}, function(){
				$(this).css({"background-color": "#FFFFFF"});
			});
			
			$('#board_submit').hover(function(){
				$(this).css({"background-color":"rgb(104, 105, 172, 0.3)"});
			}, function(){
				$(this).css({"background-color":"#FFFFFF"});
			});
			
			$('#boardBackBtn').hover(function(){
				$(this).css({"background-color":"rgb(104, 105, 172, 0.3)"});
			}, function(){
				$(this).css({"background-color":"#FFFFFF"});
			});
			
		});
		
		$('#board_content').val().replace(/\n/g, "<br>");
		
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
					공지사항
				</h2>
			</div>
			<div id="title">
				<h3>
					글쓰기
				</h3>
			</div>
			<form action="" method="post">
				<input type="text" id="board_title" name="board_title" class="form-control" placeholder="제목을 입력해주세요." required>
				<div class="form-group">
					<textarea class="form-control" rows="10" id="board_content" name="board_content" placeholder="내용을 입력해주세요." required></textarea>
				</div>
				<input type="hidden" id="board_nickname" name="nickname" value="">
				<div align="right">
					<a href="/BoardFree/board_free_main" id="boardBackBtn" class="btn btn-primary" style="background-color:#FFFFFF; color: #6667AB; border: 1px solid #6667AB">뒤로가기</a>&nbsp;&nbsp;
					<button type="submit" class="btn btn-primary pull-right" id="board_submit" style="background-color:#FFFFFF; color: #6667AB; border: 1px solid #6667AB">제출하기</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>