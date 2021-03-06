<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../../Intro/header/nav.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
 	// contextPath : 해당 애플리케이션의 이름(=컨덱스트 이름)
 	String contextPath = request.getContextPath();
 
 	// 서블릿 매핑 이름
 	String mapping = "/Culture";
 	// url 패턴
 
 	// 폼 태그에서 사용할 공용 변수
 	String yesForm = contextPath+mapping;

 	// 폼이 없는 <a>,<img> 태그에서 사용할 공용 변수
 	String noForm=contextPath+mapping+"?command=";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		$(document).ready(function(){
				
			if(${bean.writer == sessionScope.loginfo.nickname}){
				$('#boardUpdateBtn').show();
				$('#boardDeleteBtn').show();
			}else{
				$('#boardUpdateBtn').hide();
				$('#boardDeleteBtn').hide();
			} 
			
			 $('#comment_submit').click(function(){
				if(${whologin == 0}){
					alert('로그인을 하셔야 댓글 작성이 가능합니다..');
					location.href = "<%=noForm %>meLogin";
				}else{
					$('#commentForm').attr('onsubmit', 'return true');
				}
			}); 
			
			$('#boardDeleteBtn').hover(function(){
				$(this).css({"background-color": "#6255f6","color":"#FFFFFF"});
			}, function(){
				$(this).css({"background-color": "#FFFFFF", "color":"#6255f6", "border":"1px solid #6255f6"});
			});
			
			$('#boardUpdateBtn').hover(function(){
				$(this).css({"background-color": "#6255f6","color":"#FFFFFF"});
			}, function(){
				$(this).css({"background-color": "#FFFFFF", "color":"#6255f6", "border":"1px solid #6255f6"});
			});
			
			$('#goToBoardPage').hover(function(){
				$(this).css({"background-color": "#6255f6","color":"#FFFFFF"});
			}, function(){
				$(this).css({"background-color": "#FFFFFF", "color":"#6255f6", "border":"1px solid #6255f6"});
			})
			
			$('#comment_submit').hover(function(){
				$(this).css({"background-color": "#6255f6","color":"#FFFFFF"});
			}, function(){
				$(this).css({"background-color": "#FFFFFF", "color":"#6255f6", "border":"1px solid #6255f6"});
			});
			
		});
		
		function deleteFunction(){
			var text = "게시글을 삭제하시겠습니까?";
			
			if(confirm(text) == true){
				location.href = "boardDelete&num=${bean.boardNum }";
				return true;
			}else{
				return false;
			}
		}
		
		function updateFunction(){
			var text = "게시글을 수정하시겠습니까?";
			
			if(confirm(text) == true){
				location.href = "boardUpdate&num=${bean.boardNum }";
				return true;
			}else{
				return false;
			}
		}
		
		function deleteCommentFunction(commentNum){
			var text = "댓글을 삭제하시겠습니까?";
			
			if(confirm(text) == true){
				location.href = "boardFreeCommentDelete&commentNum=" + commentNum + "&boardNum=${bean.boardNum}";
				return true;
			}else{
				return false;
			}
		}
		
	</script>

	<style type="text/css">
		#title{padding-top:56px; padding-left:10px;margin-left:25%;  width:60%; height:105px; color:#666666; font-weight: 600; font-size: 30px;border-bottom: 3px solid #cccccc;}
		#btitle{font-weight:bold; font-size:17px;}
		
	</style>
</head>
<body>
	<div>
		<h2 id=title>리뷰 게시판</h2>
	</div>
	
	<div style="width: 60%; margin-left: 25%; padding-left: 10px;">
		<table class="table table-striped">
			<thead>
				<tr>
					<th width="10%" id=btitle>제목</th>
					<th width="60%" colspan="3" id=btitle>후기인증해요 ${bean.title }</th>
					<td width="10%">카테고리</td>
					<td width="45%">연극${bean.category }</td>
				</tr>
				<tr>
					<td width="10%">작성자</td>
					<td width="45%">홍길동 ${bean.writer }</td>
					<td width="10%">작성일자</td>
					<td width="15%">2022-01-01 ${bean.regDate }</td>
					<td width="10%">조회수</td>
					<td width="10%">100 ${bean.viewCnt }</td>
				</tr>
			</thead>
		</table>

		<table class="table table-striped" id="content_table">
			<tbody>
				<tr>
					<%
						pageContext.setAttribute("crcn", "\r\n");
						pageContext.setAttribute("br", "<br/>");
					%>
					<td colspan="6"><p id="text"></p>재밌어요~
						${fn:replace(bean.content, crcn, br )}
					</td>
				</tr>
				<tr>
					<%
						String fileName = (String)request.getAttribute("fileName");
					%>
					<td colspan="6">
						<img alt=""
						src="/Culture/images/Board/BoardReviewImg/ticket1.jpg"
						style="width: 500px; height: 500px;">
					</td>
				</tr>
			</tbody>
		</table>

		<table class="table table-striped" id="comment_table">
			<c:choose>
				<c:when test="${empty requestScope.commentLists }">
					<tr>
						<td colspan="3"><p>댓글이 없습니다.</p></td>
					</tr>
				</c:when>

				<c:otherwise>
					<c:forEach var="comment_bean"
						items="${requestScope.commentLists }">
						<tr>
							<td width="10%">${comment_bean.nickname }</td>
							<td width="75%"><p id="comment_p">${comment_bean.fComment }</p></td>
							<td width="10%">${comment_bean.regDate }</td>
							<c:if
								test="${sessionScope.loginfo.nickname == comment_bean.nickname }">
								<td width="5%"><a href="#" id="deleteComment"
									style="display: block"
									onclick="deleteCommentFunction(${comment_bean.commentNum})">삭제</a></td>
							</c:if>
							<c:if
								test="${sessionScope.loginfo.nickname != comment_bean.nickname }">
								<td width="5%"><a href="#" id="deleteComment"
									style="display: none">삭제</a></td>
							</c:if>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>

<%--
		<form action="<%=noForm %>boardReviewComment" method="post"
			id="commentForm" onsubmit="return false">
			<p>댓글작성</p>
			<div class="form-group">
				<textarea style="width: 92%" rows="2" id="comment_area"
					name="member_comment" placeholder="댓글을 작성해주세요"></textarea>
				<input type="hidden" id="board_nickname" name="nickname"
					value=${sessionScope.loginfo.nickname }> <input
					type="hidden" id="board_num" name="boardNum"
					value=${bean.boardNum }>
				<button type="submit" class="btn btn-primary pull-right"
					id="comment_submit"
					style="background-color: #FFFFFF; color: #6255f6; border: 1px solid #6255f6; font-weight:bold" >댓글달기</button>
			</div>
		</form> --%>

		<div id="boardDetailBtn" align="right">
			<a href="board/main"
				class="btn btn-primary pull-right" id="boardDeleteBtn"
				style="background-color: #FFFFFF; color: #6255f6; border: 1px solid #6255f6; box-sizing: border-box; margin-top: 10px;"><b>삭제</b></a>
			<a href="/Culture/Board/Board_Review/boardReview_update.jsp"
				class="btn btn-primary pull-right" id="boardUpdateBtn"
				style="background-color: #FFFFFF; color: #6255f6; border: 1px solid #6255f6; box-sizing: border-box; margin-top: 10px;"><b>수정</b></a>
			<a href="board/main"
				class="btn btn-primary pull-right" id="goToBoardPage"
				style="background-color: #FFFFFF; color: #6255f6; border: 1px solid #6255f6; box-sizing: border-box; margin-top: 10px;"><b>돌아가기</b></a>
		</div>
	</div>
	<br><br><br><br><br>
	
</body>
</html>