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
			$('#topline').text('자유 게시판 글 수정');
			$('#board_content').val().replace(/\n/g, "<br>");
			
		</script>
		<style type="text/css">
			#template{
			display: flex; width: 100%;
			justify-content: center; margin: 150px 0px 150px 0px;
			}
			#container{
				 width: 60%;
			}
			#title{
				border-bottom: 4px solid gray;
				width:100%;
			}
			#board{border-collapse: collapse; width:100%;}
			#boardDateReadHit{
				height: 40px;
				border-bottom: 1px solid gray;
				font-size: 12px; font-weight: bold;
			}
			#boardUpdateInfo{
				width: 100%; list-style: none;
				padding-left: 0; vertica
			}
			#boardUpdateInfo li{
				display: flex; line-height: 50px; border-bottom: 1px solid lightgray;
			}
			#boardUpdateInfo span:first-child{
				text-align: center; line-height: 50px; font-size: 18px; font-weight: bold; white-space:nowrap;
			}
			#boardUpdateInfo span:last-child{
				width: 90%; vertical-align: middle;
			}
		</style>
	</head>
	
	<body>
		<div id="template">
			<div id="container">
				<form action="" method="post">
					<input type="hidden" name="boardNum" value="${requestScope.boardInfo.boardNum }">
					<div id="title">
						<h2 style="font-weight: bold;">
							공지사항
						</h2>
					</div>
					<div id="title">
						<h3>
							수정
						</h3>
					</div>
					<table id="board">
						<tr id="boardDateReadHit"">
							<td style="width: 60%"></td>
							<td style="width: 10%; text-align: center;">작성일자</td>
							<td style="width: 10%; text-align: center;">${requestScope.boardInfo.regDate }</td>
							<td style="width: 10%; text-align: center;">조회수</td>
							<td width="10%">
								${requestScope.boardInfo.viewCnt }
								<input type="hidden" name="viewCnt" value="${requestScope.boardInfo.viewCnt }">
							</td>
						</tr>
					</table>
					<table class="table table-striped">
						<thead>
							<ul id="boardUpdateInfo">
								<li>
									<span>작성자&nbsp;:</span><span>&nbsp;&nbsp;${requestScope.boardInfo.writer}</span>
									<input type="hidden" name="writer" value="${requestScope.boardInfo.writer}">
								</li>
								<li>
									<span>제목&nbsp;&nbsp;&nbsp;&nbsp;:</span>
									<input style="margin-top: 8px;" type="text" class="form-control" name="title" value="${requestScope.boardInfo.title }"></li>
							</ul>
						</thead>
						<tbody>
							<tr>
								<%
									pageContext.setAttribute("crcn", "\r\n");
									pageContext.setAttribute("br", "<br/>");
								%>
								<td colspan="6">
									<div class="form-group">
										<textarea class="form-control" rows="10" id="board_content"
											name="board_content" placeholder="내용을 입력해주세요" required>${requestScope.boardInfo.content }</textarea>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<div align="right">
						<a href="/BoardFree/board_notice_detail" id="boardBackBtn" class="btn btn-primary" style="background-color:#FFFFFF; color: #6667AB; border: 1px solid #6667AB">뒤로가기</a>&nbsp;&nbsp;
						<button type="submit" class="btn btn-primary pull-right" id="board_submit" style="background-color:#FFFFFF; color: #6667AB; border: 1px solid #6667AB">수정하기</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>