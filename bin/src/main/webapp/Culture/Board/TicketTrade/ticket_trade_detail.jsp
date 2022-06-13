<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../Intro/header/nav.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		$(document).ready(function(){
			// 로그인 구현 해야함.
			/*$('#trade_write').click(function(){
				if(${whologin == 0}){
					alert('로그인 하셔야 게시글 작성이 가능합니다.');
					$("#trade_write").attr("href", "meLogin");
				}
			});*/
			
			$('[value="판매중"]').css({'background-color':'LightBlue','cursor':'default'});
			$('[value="판매완료"]').css({'background-color':'lightgray','color':'black','cursor':'default'});
			$('[value="구매중"]').css({'background-color':'LightCoral','cursor':'default'});
			$('[value="구매완료"]').css({'background-color':'lightgray','color':'black','cursor':'default'});
			
			$('#tradeDeleteBtn').hover(function(){
				$(this).css({"background-color":"rgb(104, 105, 172, 0.3)"});
			}, function(){
				$(this).css({"background-color":"#FFFFFF"});
			});
			
			$('#tradeUpdateBtn').hover(function(){
				$(this).css({"background-color":"rgb(104, 105, 172, 0.3)"});
			}, function(){
				$(this).css({"background-color":"#FFFFFF"});
			});
			
			$('#goToBoardPage').hover(function(){
				$(this).css({"background-color":"rgb(104, 105, 172, 0.3)"});
			}, function(){
				$(this).css({"background-color":"#FFFFFF"});
			})
			
			$('#comment_submit').hover(function(){
				$(this).css({"background-color":"rgb(104, 105, 172, 0.3)"});
			}, function(){
				$(this).css({"background-color":"#FFFFFF"});
			});
		});
		
		function deleteFunction(){
			var text = "게시글을 삭제하시겠습니까?";
			
			if(confirm(text) == true){
				location.href = "tradeDelete&num=${bean.tradeNum }";
				return true;
			}else{
				return false;
			}
		}
		
		function updateFunction(){
			var text = "게시글을 수정하시겠습니까?";
			
			if(confirm(text) == true){
				location.href = "tradeUpdate&num=${bean.tradeNum }";
				return true;
			}else{
				return false;
			}
		}
		
		function deleteCommentFunction(commentNum){
			var text = "댓글을 삭제하시겠습니까?";
			
			if(confirm(text) == true){
				location.href = "tradeFreeCommentDelete&commentNum=" + commentNum + "&tradeNum=${bean.tradeNum}";
				return true;
			}else{
				return false;
			}
		}
	</script>
	<!-- flex-direction: column; 나중에 div 내부에 추가 할 수 있으니 남겨둠 -->
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
		#tradeDetailInfo{
			width: 100%; list-style: none;
			padding-left: 0;
		}
		#tradeDetailInfo li{
			display: flex; line-height: 50px; border-bottom: 1px solid lightgray;
		}
		#tradeDetailInfo span:first-child{
			text-align: center; line-height: 50px; font-size: 18px; font-weight: bold; white-space:nowrap;
		}
		#tradeDetailInfo span:last-child{
			width: 90%;
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
			<table id="trade">
				<tr id="tradeDateReadHit"">
					<td style="width: 60%">
						<input type="button" class="ticketStatus" class="ticketStatus" type="button" style="border: 1px solid black; border-radius: 5px; padding: 2px; vertical-align: middle; width: 10%;" value="판매중"></input>
					</td>
					<td style="width: 10%; text-align: center;">작성일자</td>
					<td style="width: 10%; text-align: center;">2022-10-10</td>
					<td style="width: 10%; text-align: center;">조회수</td>
					<td style="width: 10%; text-align: center;">100000</td>
				</tr>
			</table>
			<ul id="tradeDetailInfo">
				<li><span>작성자&nbsp;:</span><span>&nbsp;&nbsp;asdaasdasdasdasdasdassd</span></li>
				<li><span>제목&nbsp;&nbsp;&nbsp;&nbsp;:</span><span>&nbsp;&nbsp;asdaasdasdasdasdasdassd</span></li>
			</ul>
			
			<table class="table table-striped" id="content_table">
				<tbody>
					<tr>
						<%
							pageContext.setAttribute("crcn", "\r\n");
							pageContext.setAttribute("br", "<br/>");
						%>
						<td colspan="6"><p id="text"></p>${fn:replace(bean.content, crcn, br )}</td>
					</tr>
					
				</tbody>
			</table>
			
			<table class="table table-striped" id="comment_table">
				<tr>
					<td rowspan="1" colspan="4">
						댓글
					</td>
				<tr>
				<c:choose>
					<c:when test="${empty requestScope.commentLists }">
						<tr>
							<td colspan="3"><p>댓글이 없습니다.</p></td>
						</tr>
					</c:when>
					
					<c:otherwise>
						<c:forEach var="comment_bean" items="${requestScope.commentLists }">
							<tr>
								<td width="10%">${comment_bean.nickname }</td>
								<td width="70%"><p id="comment_p">${comment_bean.fComment }</p></td>
								<td width="15%">${comment_bean.regDate }</td>
								<c:if test="${sessionScope.loginfo.nickname == comment_bean.nickname }">
									<td width="5%" ><a href="#" id="deleteComment" style="display: block" onclick="deleteCommentFunction(${comment_bean.commentNum})">삭제</a></td>
								</c:if>
								<c:if test="${sessionScope.loginfo.nickname != comment_bean.nickname }">
									<td width="5%" ><a href="#" id="deleteComment" style="display: none">삭제</a></td>
								</c:if>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
			
				<td colspan="10" align="center">
					<form action="" method="post" id="commentForm" onsubmit="return false">
					<p>댓글작성</p>
					<div class="form-group">
					<textarea style="width:93%" rows="2" id="comment_area" name="member_comment" placeholder="댓글을 작성해주세요"></textarea>
					<input type="hidden" id="trade_nickname" name="nickname" value=${sessionScope.loginfo.nickname }>
					<input type="hidden" id="trade_num" name="tradeNum" value=${bean.tradeNum }>
					<button type="submit" class="btn btn-primary pull-right" id="comment_submit" style="background-color:#FFFFFF; color: #6667AB; border: 1px solid #6667AB">댓글달기</button>
						</div>
					</form>
					<br/>
					<a href="/TicketTrade/ticket_trade_main" class="btn btn-primary pull-right" id="tradeDeleteBtn" style="background-color:#FFFFFF; color: #6667AB; border: 1px solid #6667AB; box-sizing:border-box; margin-top: 10px;"><b>삭제</b></a>
					<a href="/TicketTrade/ticket_trade_update" class="btn btn-primary pull-right" id="tradeUpdateBtn" style="background-color:#FFFFFF; color: #6667AB; border: 1px solid #6667AB; box-sizing:border-box; margin-top: 10px;"><b>수정</b></a>
					<a href="/TicketTrade/ticket_trade_main" class="btn btn-primary pull-right" id="goToBoardPage" style="background-color:#FFFFFF; color: #6667AB; border: 1px solid #6667AB; box-sizing:border-box; margin-top: 10px;"><b>뒤로가기</b></a>					
				</td>
			
		</div>
	</div>
</body>
</html>