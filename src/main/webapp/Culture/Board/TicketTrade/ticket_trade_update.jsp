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
				$('#trade_submit').click(function(){
					if($('#trade_title').val() == '' || $('#trade_content').val() == ''){
						alert('입력이 안된 사항이 있습니다.');
					}
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
			#trade{border-collapse: collapse; width:100%;}
			#tradeDateReadHit{
				height: 40px;
				border-bottom: 1px solid gray;
				font-size: 12px; font-weight: bold;
			}
			#tradeUpdateInfo{
				width: 100%; list-style: none;
				padding-left: 0; vertica
			}
			#tradeUpdateInfo li{
				display: flex; line-height: 50px; border-bottom: 1px solid lightgray;
			}
			#tradeUpdateInfo span:first-child{
				text-align: center; line-height: 50px; font-size: 18px; font-weight: bold; white-space:nowrap;
			}
			#tradeUpdateInfo span:last-child{
				width: 90%; vertical-align: middle;
			}
		</style>
	</head>
	
	<body>
		<div id="template">
			<div id="container">
				<form action="" method="post">
					<input type="hidden" name="tradeNum" value="${requestScope.tradeInfo.tradeNum }">
					<div id="title">
						<h2 style="font-weight: bold;">
							티켓 거래 게시판
						</h2>
					</div>
					<div id="title">
						<h3>
							수정
						</h3>
					</div>
					<table id="trade">
						<tr id="tradeDateReadHit"">
							<td style="width: 60%">
								<select id="tradeTypeBox" name="tradeTypeBox" onchange="className_change()" style="font-size: 14px;">
									<option value="all">-- 거래상태
									<option value="writer">판매중
									<option value="writer">판매완료
									<option value="writer">구매중
									<option value="writer">구매완료
								</select>
							</td>
							<td style="width: 10%; text-align: center;">작성일자</td>
							<td style="width: 10%; text-align: center;">${requestScope.tradeInfo.regDate }</td>
							<td style="width: 10%; text-align: center;">조회수</td>
							<td width="10%">
								${requestScope.tradeInfo.viewCnt }
								<input type="hidden" name="viewCnt" value="${requestScope.tradeInfo.viewCnt }">
							</td>
						</tr>
					</table>
					<table class="table table-striped">
						<thead>
							<ul id="tradeUpdateInfo">
								<li>
									<span>작성자&nbsp;:</span><span>&nbsp;&nbsp;${requestScope.tradeInfo.writer}</span>
									<input type="hidden" name="writer" value="${requestScope.tradeInfo.writer}">
								</li>
								<li>
									<span>제목&nbsp;&nbsp;&nbsp;&nbsp;:</span>
									<input style="margin-top: 8px;" type="text" class="form-control" name="title" value="${requestScope.tradeInfo.title }"></li>
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
										<textarea class="form-control" rows="10" id="trade_content"
											name="trade_content" placeholder="내용을 입력해주세요" required>${requestScope.tradeInfo.content }</textarea>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<div align="right">
						<a href="/TicketTrade/ticket_trade_detail" id="tradeBackBtn" class="btn btn-primary" style="background-color:#FFFFFF; color: #6667AB; border: 1px solid #6667AB">뒤로가기</a>&nbsp;&nbsp;
						<button type="submit" class="btn btn-primary pull-right" id="trade_submit" style="background-color:#FFFFFF; color: #6667AB; border: 1px solid #6667AB">수정하기</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>